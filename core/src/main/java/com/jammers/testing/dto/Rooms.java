package com.jammers.testing.dto;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;

public class Rooms {
    private HashMap<String, Room> rooms;

    public static class Room {
        public Array<Rectangle> rectangles;
    }

    public HashMap<String, Array<Rectangle>> getRooms() {
        HashMap<String, Array<Rectangle>> result = new HashMap<>();

        for (var entry : rooms.entrySet()) {
            result.put(entry.getKey(), entry.getValue().rectangles);
        }

        return result;
    }
}
