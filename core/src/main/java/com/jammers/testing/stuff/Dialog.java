package com.jammers.testing.stuff;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.jammers.testing.Constants.DARK_COLOR;
import static com.jammers.testing.Constants.DIALOG_HEIGHT;
import static com.jammers.testing.Constants.DIALOG_LABEL_BG_X;
import static com.jammers.testing.Constants.DIALOG_LABEL_BG_Y;
import static com.jammers.testing.Constants.DIALOG_LABEL_X;
import static com.jammers.testing.Constants.DIALOG_LABEL_Y;
import static com.jammers.testing.Constants.DIALOG_THICKNESS;
import static com.jammers.testing.Constants.DIALOG_WIDTH;
import static com.jammers.testing.Constants.DIALOG_X;
import static com.jammers.testing.Constants.DIALOG_Y;
import static com.jammers.testing.Constants.LIGHT_COLOR;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Dialog {

    private final Sprite outline, background, labelBackground, character;
    private final Text label, text;

    public Dialog(Sprite pixel, BitmapFont font, Sprite characterSprite) {
        outline = new Sprite(pixel);
        outline.setPosition(DIALOG_X, DIALOG_Y);
        outline.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
        outline.setColor(LIGHT_COLOR);

        background = new Sprite(pixel);
        background.setPosition(DIALOG_X + DIALOG_THICKNESS, DIALOG_Y + DIALOG_THICKNESS);
        background.setSize(DIALOG_WIDTH - DIALOG_THICKNESS * 2f, DIALOG_HEIGHT - DIALOG_THICKNESS * 2f);
        background.setColor(DARK_COLOR);

        label = new Text(font, "Dionysis");
        label.setPosition(DIALOG_LABEL_X, DIALOG_LABEL_Y);
        label.setColor(LIGHT_COLOR);
        label.setVerticallyCentered(true);

        labelBackground = new Sprite(pixel);
        labelBackground.setPosition(DIALOG_LABEL_BG_X, DIALOG_LABEL_BG_Y);
        labelBackground.setSize(label.getWidth() + 10f, 20f);
        labelBackground.setColor(DARK_COLOR);

        text = new Text(font);

        character = new Sprite(characterSprite);
    }

    public void draw(SpriteBatch spriteBatch) {
        outline.draw(spriteBatch);
        background.draw(spriteBatch);
        labelBackground.draw(spriteBatch);
        label.draw(spriteBatch);
        text.draw(spriteBatch);
        character.draw(spriteBatch);
    }

    public void setLabelText(String text) {
        label.setText(text);
        labelBackground.setSize(label.getWidth() + 10f, labelBackground.getHeight());
    }

    public void setDialogText(String dialogText) {
        text.setText(dialogText);
    }

    public void show() {
        outline.setColor(LIGHT_COLOR);
        background.setColor(DARK_COLOR);
        labelBackground.setColor(DARK_COLOR);
        label.setColor(LIGHT_COLOR);
        text.setColor(LIGHT_COLOR);
    }

    public void hide() {
        outline.setColor(CLEAR);
        background.setColor(CLEAR);
        labelBackground.setColor(CLEAR);
        label.setColor(CLEAR);
        text.setColor(CLEAR);
    }
}
