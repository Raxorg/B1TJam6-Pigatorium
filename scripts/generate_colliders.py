#!/usr/bin/env python3
"""Convert visible pure-black pixels into non-overlapping collider rectangles.

Requires Pillow: python3 -m pip install Pillow
Run from any directory; defaults resolve relative to the repository.
Coordinates are image-local pixels, with a bottom-left origin by default.
Rectangles cover the mask exactly, but are not guaranteed to be minimal.
"""

import argparse
import json
from pathlib import Path

from PIL import Image


ROOT = Path(__file__).resolve().parents[1]


def extract_rectangles(image, origin="bottom-left"):
    """Merge identical black runs in consecutive rows into rectangles."""
    image = image.convert("RGBA")
    pixels = image.load()
    rectangles = []
    active = {}

    for y in range(image.height):
        runs = []
        x = 0
        while x < image.width:
            r, g, b, a = pixels[x, y]
            if (r, g, b) != (0, 0, 0) or a == 0:
                x += 1
                continue
            start = x
            x += 1
            while x < image.width:
                r, g, b, a = pixels[x, y]
                if (r, g, b) != (0, 0, 0) or a == 0:
                    break
                x += 1
            runs.append((start, x - start))

        following = {}
        for start, width in runs:
            rectangle = active.pop((start, width), None)
            if rectangle is None:
                rectangle = {"x": start, "y": y, "width": width, "height": 0}
            rectangle["height"] += 1
            following[(start, width)] = rectangle
        rectangles.extend(active.values())
        active = following

    rectangles.extend(active.values())
    if origin == "bottom-left":
        for rectangle in rectangles:
            rectangle["y"] = image.height - rectangle["y"] - rectangle["height"]
    return sorted(rectangles, key=lambda rect: (rect["y"], rect["x"]))


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument(
        "images", nargs="*", type=Path,
        help="Input PNGs; defaults to assets/sprites/320x320/map/*-collider.png",
    )
    parser.add_argument(
        "-o", "--output", type=Path, default=ROOT / "assets/models/colliders.json",
        help="Destination JSON file (default: assets/models/colliders.json)",
    )
    parser.add_argument(
        "--origin", choices=("bottom-left", "top-left"), default="bottom-left",
        help="Coordinate origin (default: bottom-left, for LibGDX)",
    )
    args = parser.parse_args()
    paths = args.images or sorted((ROOT / "assets/sprites/320x320/map").glob("*-collider.png"))
    if not paths:
        parser.error("No collider images found")

    rooms = {}
    for path in paths:
        room = path.stem.removesuffix("-collider")
        if room in rooms:
            parser.error(f"Duplicate room name: {room}")
        with Image.open(path) as image:
            rooms[room] = {
                "width": image.width,
                "height": image.height,
                "rectangles": extract_rectangles(image, args.origin),
            }

    args.output.parent.mkdir(parents=True, exist_ok=True)
    args.output.write_text(
        json.dumps({"origin": args.origin, "rooms": rooms}, indent=2) + "\n",
        encoding="utf-8",
    )
    count = sum(len(room["rectangles"]) for room in rooms.values())
    print(f"Wrote {count} rectangles for {len(rooms)} rooms to {args.output}")


if __name__ == "__main__":
    main()
