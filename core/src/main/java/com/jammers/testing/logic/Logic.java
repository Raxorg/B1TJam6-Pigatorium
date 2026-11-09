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
    private final JudgementHandler judgementHandler;
    private final TestHandler testHandler;
    private final IntroHandler introHandler;

    public Logic(Assets assets, Stuff stuff) {
        ArrowHandler arrowHandler = new ArrowHandler(assets, stuff);
        SacrificeHandler sacrificeHandler = new SacrificeHandler(stuff, assets);
        transitionHandler = new TransitionHandler(arrowHandler, stuff);
        borderDetector = new BorderDetector(transitionHandler, stuff);
        movementHandler = new MovementHandler(stuff);
        shrineHandler = new ShrineHandler(sacrificeHandler, assets, stuff);
        itemHandler = new ItemHandler(shrineHandler, assets, stuff);
        dialogHandler = new DialogHandler(stuff);
        judgementHandler = new JudgementHandler(dialogHandler, sacrificeHandler, assets, stuff);
        timerHandler = new TimerHandler(judgementHandler, stuff);
        testHandler = new TestHandler(timerHandler, sacrificeHandler);
        new ItemSpawner(assets, stuff);
        introHandler = new IntroHandler(dialogHandler, assets);
    }

    public void update(float delta) {
        if (!introHandler.isBlocking()) {
            movementHandler.update(delta);
            timerHandler.update(delta);
        }
        borderDetector.update();
        transitionHandler.update(delta);
        itemHandler.update();
        shrineHandler.update();
        dialogHandler.update(delta);
        judgementHandler.update(delta);
        introHandler.update(delta);
        if (!introHandler.isBlocking() && !judgementHandler.isEndingShown()) testHandler.update();
    }
}
