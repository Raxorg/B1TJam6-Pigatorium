package com.jammers.testing.logic;

import static com.badlogic.gdx.Input.Keys.F;
import static com.badlogic.gdx.Input.Keys.G;
import static com.badlogic.gdx.Input.Keys.T;
import static com.jammers.testing.Constants.DIALOG_Y;

import com.badlogic.gdx.Gdx;

public class TestHandler {

    private final DialogHandler dialogHandler;
    private final TimerHandler timerHandler;
    private final SacrificeHandler sacrificeHandler;

    public TestHandler(DialogHandler dialogHandler, TimerHandler timerHandler, SacrificeHandler sacrificeHandler) {
        this.dialogHandler = dialogHandler;
        this.timerHandler = timerHandler;
        this.sacrificeHandler = sacrificeHandler;
    }

    public void update() {
        if (Gdx.input.isKeyJustPressed(F))
            dialogHandler.startDialog("Place your offerings within the circle, and I shall judge their worth.", DIALOG_Y);

        if (Gdx.input.isKeyJustPressed(T)) timerHandler.setTimeRemaining(1f);

        if (Gdx.input.isKeyJustPressed(G)) sacrificeHandler.addFavor(100);
    }
}
