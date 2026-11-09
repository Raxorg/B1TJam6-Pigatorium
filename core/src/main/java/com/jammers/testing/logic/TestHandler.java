package com.jammers.testing.logic;

import static com.badlogic.gdx.Input.Keys.G;
import static com.badlogic.gdx.Input.Keys.T;

import com.badlogic.gdx.Gdx;

public class TestHandler {

    private final TimerHandler timerHandler;
    private final SacrificeHandler sacrificeHandler;

    public TestHandler(TimerHandler timerHandler, SacrificeHandler sacrificeHandler) {
        this.timerHandler = timerHandler;
        this.sacrificeHandler = sacrificeHandler;
    }

    public void update() {
        if (Gdx.input.isKeyJustPressed(T)) timerHandler.setTimeRemaining(1f);

        if (Gdx.input.isKeyJustPressed(G)) sacrificeHandler.addFavor(100);
    }
}
