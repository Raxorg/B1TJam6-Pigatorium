package com.jammers.rooms;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Room {

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private Room upRoom;
    private Room downRoom;
    private Room leftRoom;
    private Room rightRoom;

    private final String name;

    public Room(String name) {
        this.name = name;
    }

    public abstract void draw(SpriteBatch spriteBatch);

    public void connectRoom(Direction direction, Room room) {
        switch (direction) {
            case UP:
                this.upRoom = room;
                break;
            case DOWN:
                this.downRoom = room;
                break;
            case LEFT:
                this.leftRoom = room;
                break;
            case RIGHT:
                this.rightRoom = room;
                break;
        }
    }

    public Room getConnectedRoom(Direction direction) {
        switch (direction) {
            case UP:
                return upRoom;
            case DOWN:
                return downRoom;
            case LEFT:
                return leftRoom;
            case RIGHT:
                return rightRoom;
            default:
                return null;
        }
    }

    public String getName() {
        return name;
    }
}
