package com.jammers.testing.logic;

import com.jammers.testing.stuff.Stuff;

public class Logic {

    private final TransitionHandler transitionHandler;
    private final BorderDetector borderDetector;
    private final MovementHandler movementHandler;
    private final TimerHandler timerHandler;

    public Logic(Stuff stuff) {
        EndingHandler endingHandler = new EndingHandler();
        transitionHandler = new TransitionHandler(stuff);
        borderDetector = new BorderDetector(transitionHandler, stuff);
        movementHandler = new MovementHandler(stuff);
        timerHandler = new TimerHandler(endingHandler, stuff);
    }

    public void update(float delta) {
        movementHandler.update(delta);
        borderDetector.update();
        transitionHandler.update(delta);
        timerHandler.update(delta);
    }
}
