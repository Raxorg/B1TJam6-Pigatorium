package com.jammers;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Handles the game timer, win/lose conditions, and divine judgment upon expiration.
 */
public class Timer {

    private float totalDuration; // in seconds
    private float timeRemaining;
    private boolean isRunning;
    private boolean isExpired;

    public enum JudgmentResult {
        PENDING,
        HEAVEN,
        HELL
    }

    private JudgmentResult judgmentResult = JudgmentResult.PENDING;

    public Timer(float durationSeconds) {
        this.totalDuration = durationSeconds;
        this.timeRemaining = durationSeconds;
        this.isRunning = true;
        this.isExpired = false;
    }

    /**
     * Updates the timer each frame. When time runs out, evaluates the player's fate based on sacrifices.
     */
    public void update(float delta, Sacrifices sacrifices, float requiredFavorForHeaven) {
        if (!isRunning || isExpired) return;

        timeRemaining -= delta;
        if (timeRemaining <= 0f) {
            timeRemaining = 0f;
            isExpired = true;
            isRunning = false;
            evaluateJudgment(sacrifices, requiredFavorForHeaven);
        }
    }

    private void evaluateJudgment(Sacrifices sacrifices, float requiredFavorForHeaven) {
        if (sacrifices.getFavor() >= requiredFavorForHeaven) {
            judgmentResult = JudgmentResult.HEAVEN;
        } else {
            judgmentResult = JudgmentResult.HELL;
        }
    }

    public void reset(float newDuration) {
        this.totalDuration = newDuration;
        this.timeRemaining = newDuration;
        this.isRunning = true;
        this.isExpired = false;
        this.judgmentResult = JudgmentResult.PENDING;
    }

    public void pause() {
        isRunning = false;
    }

    public void resume() {
        if (!isExpired) {
            isRunning = true;
        }
    }

    public float getTimeRemaining() {
        return timeRemaining;
    }

    public float getProgress() {
        return Math.clamp(timeRemaining / totalDuration, 0f, 1f);
    }

    public boolean isExpired() {
        return isExpired;
    }

    public JudgmentResult getJudgmentResult() {
        return judgmentResult;
    }

    /**
     * Renders the remaining time on screen using the provided SpriteBatch and BitmapFont.
     */
    public void draw(SpriteBatch batch, BitmapFont font, float x, float y) {
        int minutes = (int) (timeRemaining / 60);
        int seconds = (int) (timeRemaining % 60);
        String timeText = String.format("Time: %02d:%02d", minutes, seconds);
        font.draw(batch, timeText, x, y);
    }
}
