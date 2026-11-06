package com.jammers.testing.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.jammers.testing.Assets;
import com.jammers.testing.stuff.Direction;
import com.jammers.testing.stuff.RoomData;
import com.jammers.testing.stuff.Stuff;

public class ArrowHandler {

    private final Sprite arrowSprite;
    private final Array<Sprite> arrows;

    public ArrowHandler(Assets assets, Stuff stuff) {
        arrowSprite = assets.getArrow();
        arrows = stuff.getArrows();
        updateArrows(stuff.getShrineRoomData());
    }

    public void updateArrows(RoomData roomData) {
        arrows.clear();
        Direction[] directions = Direction.values();
        for (int i = 0; i < directions.length; i++) {
            if (roomData.getConnectedRoom(directions[i]) != null) {
                placeArrow(directions[i]);
            }
        }
    }

    private void placeArrow(Direction direction) {
        Sprite arrow = new Sprite(arrowSprite);
        switch (direction) {
            case UP:
                arrow.rotate(180f);
                arrow.setPosition(200f, 200f);
                break;
            case DOWN:
                arrow.setPosition(100f, 200f);
                break;
            case LEFT:
                arrow.rotate(-90f);
                arrow.setY(220f);
                break;
            case RIGHT:
                arrow.rotate(90f);
                arrow.setPosition(415f, 220f);
                break;
        }
        arrows.add(arrow);
    }
}
