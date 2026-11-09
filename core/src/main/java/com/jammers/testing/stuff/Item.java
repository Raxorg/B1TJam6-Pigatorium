package com.jammers.testing.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public final class Item {

    private final Sprite sprite;
    public final int value;
    public final String name;

    public Item(Sprite sprite, int value, String name) {
        this.sprite = sprite;
        this.value = value;
        this.name = name;
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    public float getWidth() {
        return sprite.getWidth();
    }

    public float getHeight() {
        return sprite.getHeight();
    }

    public Sprite getSprite() {
        return sprite;
    }
}
