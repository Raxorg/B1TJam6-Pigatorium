package com.jammers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TimerAndSacrificesDemo extends ApplicationAdapter {

    private Timer timer;
    private Sacrifices sacrifices;
    private SpriteBatch batch;
    private BitmapFont font;
    private final float REQUIRED_FAVOR = 100f; // Favor needed for Heaven

    @Override
    public void create() {
        timer = new Timer(60f); // 60 seconds game timer
        sacrifices = new Sacrifices();
        batch = new SpriteBatch();
        font = new BitmapFont(); // Default libGDX font
    }

    @Override
    public void render() {
        // 1. Update timer (passing sacrifices and threshold)
        timer.update(Gdx.graphics.getDeltaTime(), sacrifices, REQUIRED_FAVOR);

        if (timer.isExpired()) {
            // Timer ran out! Check judgment result
            Timer.JudgmentResult result = timer.getJudgmentResult();
            if (result == Timer.JudgmentResult.HEAVEN) {
                // TODO: Show Heaven Win Screen
            } else {
                // TODO: Show Hell Game Over Screen
            }
            return;
        }

        // 2. Render timer on screen
        batch.begin();
        timer.draw(batch, font, 50, Gdx.graphics.getHeight() - 50);
        batch.end();

        // Example player interacting with a shrine:
        // if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
        //     sacrifices.sacrifice("Gold Coin", 10);
        // }
    }

    @Override
    public void dispose() {
        if (batch != null) batch.dispose();
        if (font != null) font.dispose();
    }
}
