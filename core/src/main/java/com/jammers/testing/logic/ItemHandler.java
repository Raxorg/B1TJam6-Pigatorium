package com.jammers.testing.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.jammers.testing.Assets;
import com.jammers.testing.stuff.Item;
import com.jammers.testing.stuff.Pig;
import com.jammers.testing.stuff.Room;
import com.jammers.testing.stuff.Stuff;

public class ItemHandler {

    private final Room room;
    private final Pig pig;
    private final Sound pickUpSound, putDownSound;

    private static final float INTERACTION_DISTANCE = 50f;

    public ItemHandler(Assets assets, Stuff stuff) {
        room = stuff.getRoom();
        pig = stuff.getPig();
        pickUpSound = assets.getPickUpSound();
        putDownSound = assets.getPutDownSound();
    }

    public void update() {
        handleInput();
        updateHeldItem();
    }

    private void handleInput() {
        if (!Gdx.input.isKeyJustPressed(Input.Keys.E)) return;

        if (pig.getHeldItem() == null) {
            // Try to pick up an item
            DelayedRemovalArray<Item> items = room.getItems();
            float pigCenterX = pig.getX() + pig.getWidth() * 0.5f;
            float pigCenterY = pig.getY() + pig.getHeight() * 0.5f;

            Item closestItem = null;
            float closestDist = Float.MAX_VALUE;

            for (int i = 0; i < items.size; i++) {
                Item item = items.get(i);
                float itemCenterX = item.getX() + item.getWidth() * 0.5f;
                float itemCenterY = item.getY() + item.getHeight() * 0.5f;
                float dist = Vector2.dst(pigCenterX, pigCenterY, itemCenterX, itemCenterY);

                if (dist <= INTERACTION_DISTANCE && dist < closestDist) {
                    closestDist = dist;
                    closestItem = item;
                }
            }

            if (closestItem != null) {
                pig.setHeldItem(closestItem);
                pickUpSound.play();
            }
        } else {
            // Drop the held item at pig's position
            pig.getHeldItem().setPosition(pig.getX(), pig.getY());
            pig.setHeldItem(null);
            putDownSound.play();
        }
    }

    private void updateHeldItem() {
        Item heldItem = pig.getHeldItem();
        if (heldItem == null) return;
        heldItem.setPosition(
            pig.getX() + (pig.getWidth() - heldItem.getWidth()) * 0.5f,
            pig.getY() + pig.getHeight() + 4f
        );
    }
}
