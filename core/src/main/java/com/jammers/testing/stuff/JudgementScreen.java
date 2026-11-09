package com.jammers.testing.stuff;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.jammers.testing.Constants.DARK_COLOR;
import static com.jammers.testing.Constants.GAME_HEIGHT;
import static com.jammers.testing.Constants.GAME_WIDTH;
import static com.jammers.testing.Constants.GOD_SIZE;
import static com.jammers.testing.Constants.GOD_X;
import static com.jammers.testing.Constants.GOD_Y;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jammers.testing.Assets;

public class JudgementScreen {

    private final Sprite background, god;
    private final Sprite judgementFloor, underworldFloor, ascensionFloor;
    private Sprite floor;

    public JudgementScreen(Assets assets) {
        background = new Sprite(assets.getPixel());
        background.setSize(GAME_WIDTH, GAME_HEIGHT);
        background.setColor(DARK_COLOR);

        judgementFloor = new Sprite(assets.getJudgement());
        underworldFloor = new Sprite(assets.getUnderworld());
        ascensionFloor = new Sprite(assets.getAscension());
        sizeFloor(judgementFloor);
        sizeFloor(underworldFloor);
        sizeFloor(ascensionFloor);
        floor = judgementFloor;

        god = assets.getGod2();
        god.setPosition(GOD_X, GOD_Y);
        god.setSize(GOD_SIZE, GOD_SIZE);
    }

    private void sizeFloor(Sprite floor) {
        float ratio = floor.getWidth() / floor.getHeight();
        floor.setSize(GAME_WIDTH, GAME_WIDTH / ratio);
    }

    public void show() {
        background.setColor(DARK_COLOR);
        floor = judgementFloor;
        floor.setColor(WHITE);
        god.setColor(WHITE);
    }

    public void showEnding(boolean won) {
        background.setColor(DARK_COLOR);
        floor = won ? ascensionFloor : underworldFloor;
        floor.setColor(WHITE);
        god.setColor(WHITE);
    }

    public void hide() {
        background.setColor(CLEAR);
        judgementFloor.setColor(CLEAR);
        underworldFloor.setColor(CLEAR);
        ascensionFloor.setColor(CLEAR);
        god.setColor(CLEAR);
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        floor.draw(spriteBatch);
        god.draw(spriteBatch);
    }
}
