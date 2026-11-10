package com.jammers.testing.logic;

import static com.jammers.testing.Constants.DIALOG_Y;
import static com.jammers.testing.Constants.INTRO_TEXT;

import com.jammers.testing.Assets;

public class IntroHandler {

    private static final float DISPLAY_TIME_AFTER_TEXT = 2f;

    private final DialogHandler dialogHandler;
    private final Assets assets;
    private boolean blocking = true;
    private boolean waitingAfterText;
    private float timeAfterText;

    public IntroHandler(DialogHandler dialogHandler, Assets assets) {
        this.dialogHandler = dialogHandler;
        this.assets = assets;
        dialogHandler.startDialog(INTRO_TEXT, DIALOG_Y);
        assets.getDeepVoiceIntro().play();
    }

    public void update(float delta) {
        if (!blocking || dialogHandler.isActive()) return;

        if (!waitingAfterText) {
            waitingAfterText = true;
            timeAfterText = 0f;
        }

        timeAfterText += delta;
        if (timeAfterText >= DISPLAY_TIME_AFTER_TEXT) {
            dialogHandler.hideDialog();
            assets.getOvertureLoop().setLooping(true);
            assets.getOvertureLoop().setVolume(0.65f);
            assets.getOvertureLoop().play();
            blocking = false;
        }
    }

    public void skip() {
        if (!blocking) return;

        dialogHandler.hideDialog();
        assets.getOvertureLoop().setLooping(true);
        assets.getOvertureLoop().play();
        assets.getDeepVoiceIntro().stop();
        blocking = false;
    }

    public boolean isBlocking() {
        return blocking;
    }
}
