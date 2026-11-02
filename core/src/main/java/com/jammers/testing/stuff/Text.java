package com.jammers.testing.stuff;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Text {

    private final BitmapFont font;
    private String text;
    private float x, y;

    public Text(BitmapFont font) {
        this.font = font;
        text = "";
    }

    public void draw(SpriteBatch spriteBatch) {
        font.draw(spriteBatch, text, x, y);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
