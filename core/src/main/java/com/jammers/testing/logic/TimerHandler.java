package com.jammers.testing.logic;

import com.jammers.testing.stuff.Stuff;
import com.jammers.testing.stuff.Text;

public class TimerHandler {

    private final JudgementHandler judgementHandler;
    private final Text timerText;
    private float timeRemaining; // In seconds
    private boolean running;

    public TimerHandler(JudgementHandler judgementHandler, Stuff stuff) {
        this.judgementHandler = judgementHandler;
        timerText = stuff.getTimerText();
        timeRemaining = 180f;
        running = true;
    }

    public void update(float delta) {
        if (!running) return;

        timeRemaining = Math.max(timeRemaining - delta, 0f);
        int minutes = (int) (timeRemaining / 60);
        int seconds = (int) (timeRemaining % 60);
        timerText.setText(String.format("Time: %02d:%02d", minutes, seconds));
        if (timeRemaining == 0f) {
            judgementHandler.end();
            running = false;
        }
    }

    public void setTimeRemaining(float time) {
        timeRemaining = time;
    }
}
