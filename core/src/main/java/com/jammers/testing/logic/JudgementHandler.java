package com.jammers.testing.logic;

import static com.jammers.testing.Constants.END_DIALOG_Y;
import static com.jammers.testing.Constants.REQUIRED_FAVOR;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.jammers.testing.Assets;
import com.jammers.testing.stuff.JudgementScreen;
import com.jammers.testing.stuff.Stuff;

public class JudgementHandler {

    private static final float ENDING_DELAY_SECONDS = 2f;
    private static final String UNDERWORLD_DIALOG =
        "What is this pitiful penance? Mere mortal\n" +
            "I find great joy banishing you to the Underworld...";
    private static final String ASCENSION_DIALOG =
        "AH HA HA HA such a beautiful bounty, it's truly worthy\n" +
            "Your soul has been spared, join me in the gardens of Elysium";

    private final DialogHandler dialogHandler;
    private final SacrificeHandler sacrificeHandler;
    private final Sound deepVoiceJudgement;
    private final Sound deepVoiceLoseEnding;
    private final Sound deepVoiceWinEnding;
    private final JudgementScreen judgementScreen;
    private final Music overture;
    private boolean waitingForIntro;
    private boolean endingShown;
    private float endingDelay;

    public JudgementHandler(DialogHandler dialogHandler, SacrificeHandler sacrificeHandler, Assets assets, Stuff stuff) {
        this.dialogHandler = dialogHandler;
        this.sacrificeHandler = sacrificeHandler;
        deepVoiceJudgement = assets.getDeepVoiceJudgement();
        deepVoiceLoseEnding = assets.getDeepVoiceLoseEnding();
        deepVoiceWinEnding = assets.getDeepVoiceWinEnding();
        judgementScreen = stuff.getJudgementScreen();
        judgementScreen.hide();
        overture = assets.getOvertureLoop();
    }

    public void end() {
        if (waitingForIntro || endingShown) return;

        overture.stop();
        judgementScreen.show();
        dialogHandler.startDialogWithoutLabel("  The time has come...  let's see how you've done", END_DIALOG_Y);
        deepVoiceJudgement.play();
        endingDelay = 0f;
        waitingForIntro = true;
    }

    public void update(float delta) {
        if (!waitingForIntro || dialogHandler.isActive()) return;

        endingDelay += delta;
        if (endingDelay < ENDING_DELAY_SECONDS) return;

        boolean won = sacrificeHandler.getFavor() >= REQUIRED_FAVOR;
        judgementScreen.showEnding(won);
        if (won) {
            dialogHandler.startDialogWithoutLabel(ASCENSION_DIALOG, END_DIALOG_Y);
            deepVoiceWinEnding.play();
        } else {
            dialogHandler.startDialogWithoutLabel(UNDERWORLD_DIALOG, END_DIALOG_Y);
            deepVoiceLoseEnding.play();
        }
        waitingForIntro = false;
        endingShown = true;
    }

    public boolean isEndingShown() {
        return endingShown;
    }
}
