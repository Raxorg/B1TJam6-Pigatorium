package com.jammers.testing.logic;

import static com.badlogic.gdx.Input.Keys.F;
import static com.badlogic.gdx.Input.Keys.T;
import static com.jammers.testing.Constants.DIALOG_Y;

import com.badlogic.gdx.Gdx;

public class TestHandler {

    private final DialogHandler dialogHandler;
    private final TimerHandler timerHandler;

    public TestHandler(DialogHandler dialogHandler, TimerHandler timerHandler) {
        this.dialogHandler = dialogHandler;
        this.timerHandler = timerHandler;
    }

    public void update() {
        if (Gdx.input.isKeyJustPressed(F))
            dialogHandler.startDialog("Place your offerings within the circle, and I shall judge their worth.", DIALOG_Y);

        if (Gdx.input.isKeyJustPressed(T)) timerHandler.setTimeRemaining(1f);
    }
}
