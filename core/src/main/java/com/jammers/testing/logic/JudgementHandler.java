package com.jammers.testing.logic;

import static com.jammers.testing.Constants.END_DIALOG_Y;

import com.badlogic.gdx.audio.Sound;
import com.jammers.testing.Assets;
import com.jammers.testing.stuff.JudgementScreen;
import com.jammers.testing.stuff.Stuff;

public class JudgementHandler {

    private final DialogHandler dialogHandler;
    private final Sound deepVoiceJudgement;
    private final JudgementScreen judgementScreen;

    public JudgementHandler(DialogHandler dialogHandler, Assets assets, Stuff stuff) {
        this.dialogHandler = dialogHandler;
        deepVoiceJudgement = assets.getDeepVoiceJudgement();
        judgementScreen = stuff.getJudgementScreen();
        judgementScreen.hide();
    }

    public void end() {
        judgementScreen.show();
        dialogHandler.startDialogSimple("  The time has come...  let's see how you've done", END_DIALOG_Y);
        deepVoiceJudgement.play();
    }
}
