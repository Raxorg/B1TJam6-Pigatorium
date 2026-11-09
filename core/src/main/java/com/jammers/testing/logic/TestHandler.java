package com.jammers.testing.logic;

import static com.badlogic.gdx.Input.Keys.F;
import static com.badlogic.gdx.Input.Keys.G;
import static com.badlogic.gdx.Input.Keys.T;

import com.badlogic.gdx.Gdx;

public class TestHandler {

    private final TimerHandler timerHandler;
    private final SacrificeHandler sacrificeHandler;
    private final IntroHandler introHandler;

    public TestHandler(TimerHandler timerHandler, SacrificeHandler sacrificeHandler, IntroHandler introHandler) {
        this.timerHandler = timerHandler;
        this.sacrificeHandler = sacrificeHandler;
        this.introHandler = introHandler;
    }

    public void update() {
        if (Gdx.input.isKeyJustPressed(F) && introHandler.isBlocking()) {
            introHandler.skip();
            return;
        }
        if (introHandler.isBlocking()) return;
        if (Gdx.input.isKeyJustPressed(T)) timerHandler.setTimeRemaining(1f);

        if (Gdx.input.isKeyJustPressed(G)) sacrificeHandler.addFavor(100);
    }
}
