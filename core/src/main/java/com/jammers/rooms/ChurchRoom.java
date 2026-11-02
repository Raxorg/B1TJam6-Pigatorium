package com.jammers.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ChurchRoom extends Room {

    private final Sprite churchRoom;

    public ChurchRoom() {
        super("Church");
        churchRoom = new Sprite(new Texture("raw/church.png"));
        churchRoom.setSize(800, 800);
        churchRoom.setPosition(0, 0);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        churchRoom.draw(spriteBatch);
    }
}
