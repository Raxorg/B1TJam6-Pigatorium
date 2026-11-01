package com.jammers;

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
}
