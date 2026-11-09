package com.jammers.testing.stuff;

import static com.jammers.testing.Constants.GAME_HEIGHT;
import static com.jammers.testing.Constants.GAME_WIDTH;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;

import java.util.HashMap;
import java.util.Map;

public final class RoomData {

    private final String name;
    private final Sprite background;
    private final Array<Rectangle> colliderRects;
    private final DelayedRemovalArray<Item> items;
    private final Map<Direction, RoomData> roomMap;
    public Pixmap bgDat;

    public RoomData(String roomName, Sprite backgroundSprite, Array<Rectangle> colliderRects)
    {
        name = roomName;
        background = new Sprite(backgroundSprite);
        background.setPosition(
            (GAME_WIDTH - background.getWidth()) * 0.5f,
            (GAME_HEIGHT - background.getHeight()) * 0.5f
        );
        this.colliderRects = colliderRects;
        items = new DelayedRemovalArray<>();
        roomMap = new HashMap<>();
    }
    public String getName() {
        return name;
    }

    public Sprite getBackground() {
        return background;
    }

    public Array<Rectangle> getColliderRects() {
        return colliderRects;
    }


    public DelayedRemovalArray<Item> getItems() {
        return items;
    }

    public void connectRoom(Direction direction, RoomData room) {
        roomMap.put(direction, room);
    }

    public RoomData getConnectedRoom(Direction direction) {
        return roomMap.get(direction);
    }
}
