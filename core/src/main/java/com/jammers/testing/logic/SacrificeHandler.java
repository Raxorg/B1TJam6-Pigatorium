package com.jammers.testing.logic;

import com.jammers.testing.stuff.Item;

public class SacrificeHandler {

    private int favor;

    public SacrificeHandler() {
        favor = 0;
    }

    public void sacrifice(Item item) {
        favor += item.value;
        System.out.println("Item Value: " + item.value + " New Favor: " + favor);
    }

    public int getFavor() {
        return favor;
    }
}
