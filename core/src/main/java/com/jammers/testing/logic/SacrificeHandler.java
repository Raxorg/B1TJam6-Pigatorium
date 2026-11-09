package com.jammers.testing.logic;

import com.jammers.testing.stuff.Item;
import com.jammers.testing.stuff.Room;
import com.jammers.testing.stuff.Stuff;

public class SacrificeHandler {

    private final Room room;
    private int favor;

    public SacrificeHandler(Stuff stuff) {
        room = stuff.getRoom();
        favor = 0;
    }

    public void sacrifice(Item item) {
        favor += item.value;
        room.getItems().removeValue(item, true);
        System.out.println("Item Value: " + item.value + " New Favor: " + favor);
    }

    public void addFavor(int amount) {
        favor += amount;
    }

    public int getFavor() {
        return favor;
    }
}
