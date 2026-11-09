package com.jammers.testing.logic;

import com.jammers.testing.Assets;
import com.jammers.testing.stuff.Stuff;

public class Logic {

    private final TransitionHandler transitionHandler;
    private final BorderDetector borderDetector;
    private final MovementHandler movementHandler;
    private final TimerHandler timerHandler;
    private final ItemHandler itemHandler;
    private final ShrineHandler shrineHandler;
    private final DialogHandler dialogHandler;
    private final TestHandler testHandler;

    public Logic(Assets assets, Stuff stuff) {
        ArrowHandler arrowHandler = new ArrowHandler(assets, stuff);
        SacrificeHandler sacrificeHandler = new SacrificeHandler(stuff);
        transitionHandler = new TransitionHandler(arrowHandler, stuff);
        borderDetector = new BorderDetector(transitionHandler, stuff);
        movementHandler = new MovementHandler(stuff);
        shrineHandler = new ShrineHandler(sacrificeHandler, assets, stuff);
        itemHandler = new ItemHandler(shrineHandler, assets, stuff);
        dialogHandler = new DialogHandler(stuff);
        JudgementHandler judgementHandler = new JudgementHandler(dialogHandler, assets, stuff);
        timerHandler = new TimerHandler(judgementHandler, stuff);
        testHandler = new TestHandler(dialogHandler, timerHandler);
        new ItemSpawner(assets, stuff);
    }

    public void update(float delta) {
        movementHandler.update(delta);
        borderDetector.update();
        transitionHandler.update(delta);
        timerHandler.update(delta);
        itemHandler.update();
        shrineHandler.update();
        dialogHandler.update(delta);
        testHandler.update();
    }
}
