package com.jammers.testing.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.jammers.testing.Assets;
import com.jammers.testing.stuff.Item;
import com.jammers.testing.stuff.Pig;
import com.jammers.testing.stuff.RoomData;
import com.jammers.testing.stuff.Stuff;

public class ShrineHandler {

    private final SacrificeHandler sacrificeHandler;
    private final Pig pig;
    private final RoomData shrineData;
    private final Vector2 shrineCenter, pigCenter;
    private final Sprite shrine, activeShrine;
    private boolean shrineActive;

    public ShrineHandler(SacrificeHandler sacrificeHandler, Assets assets, Stuff stuff) {
        this.sacrificeHandler = sacrificeHandler;
        pig = stuff.getPig();
        shrineData = stuff.getShrineRoomData();
        stuff.getInfoPanel().getRoomLabel().setText(shrineData.getName());
        Sprite background = shrineData.getBackground();
        background.translateY(20f);
        shrineCenter = new Vector2(
            background.getX() + background.getWidth() * 0.5f,
            background.getY() + background.getHeight() * 0.45f
        );
        pigCenter = new Vector2();
        shrine = assets.getShrine();
        activeShrine = assets.getShrineActive();
        shrineActive  = false;
    }

    public void update() {
        handlePlayerProximity();
    }

    private void handlePlayerProximity() {
        pigCenter.set(pig.getX() + pig.getWidth() * 0.5f, pig.getY() + pig.getHeight() * 0.5f);
        if (pigCenter.dst(shrineCenter) < 80f) {
            shrineData.getBackground().setRegion(activeShrine);
            shrineActive = true;
        } else {
            shrineData.getBackground().setRegion(shrine);
            shrineActive = false;
        }
    }

    public void itemDropped(Item item) {
        if (shrineActive) sacrificeHandler.sacrifice(item);
    }
}
