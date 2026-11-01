package com.jammers;

import com.badlogic.gdx.ScreenAdapter;

public class TimerAndSacrificesDemo extends ScreenAdapter {

    private Timer timer;
    private Sacrifices sacrifices;
    private final float REQUIRED_FAVOR = 100f; // Favor needed for Heaven

    @Override
    public void show() {
        timer = new Timer(60f); // 60 seconds game timer
        sacrifices = new Sacrifices();
    }

    @Override
    public void render(float delta) {
        // 1. Update timer (passing sacrifices and threshold)
        timer.update(delta, sacrifices, REQUIRED_FAVOR);

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

        // Example player interacting with a shrine:
        // if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
        //     sacrifices.sacrifice("Gold Coin", 10f);
        // }
    }
}
