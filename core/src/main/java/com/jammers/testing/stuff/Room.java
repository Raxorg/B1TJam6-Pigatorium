package com.jammers.testing.stuff;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;

public class Room {

    private RoomData roomData;

    public Room(RoomData roomData) {
        this.roomData = roomData;
    }

    public void set(RoomData roomData) {
        this.roomData = roomData;
    }

    public void draw(SpriteBatch spriteBatch) {
        roomData.getBackground().draw(spriteBatch);
        for (int i = 0; i < roomData.getItems().size; i++) {
            roomData.getItems().get(i).draw(spriteBatch);
        }
    }

    public String getName() {
        return roomData.getName();
    }

    public RoomData getRoomData()
    {
        return roomData;
    }
    public RoomData getConnectedRoom(Direction direction) {
        return roomData.getConnectedRoom(direction);
    }

    public DelayedRemovalArray<Item> getItems() {
        return roomData.getItems();
    }
}
