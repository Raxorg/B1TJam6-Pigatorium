package com.jammers.testing.logic;

import com.badlogic.gdx.audio.Sound;
import com.jammers.testing.Assets;
import com.jammers.testing.stuff.Item;
import com.jammers.testing.stuff.Room;
import com.jammers.testing.stuff.Stuff;

public class SacrificeHandler {

    private final Room room;
    private final Sound goodSacrifice, badSacrifice;
    private int favor;

    public SacrificeHandler(Stuff stuff, Assets assets) {
        room = stuff.getRoom();
        goodSacrifice = assets.getGoodSacrifice();
        badSacrifice = assets.getBadSacrifice();
        favor = 0;
    }

    public void sacrifice(Item item) {
        favor += item.value;
        if (item.value > 0) goodSacrifice.play();
        else if (item.value < 0) badSacrifice.play();
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
