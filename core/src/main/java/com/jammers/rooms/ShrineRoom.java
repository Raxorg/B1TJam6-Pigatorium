package com.jammers.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ShrineRoom extends Room {

    private final Sprite shrine;

    public ShrineRoom() {
        super("Shrine Room");

        shrine = new Sprite(new Texture("raw/shrine-2.png"));
        shrine.setSize(800, 800);
        shrine.setPosition(0, 0);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        shrine.draw(spriteBatch);
    }
}
