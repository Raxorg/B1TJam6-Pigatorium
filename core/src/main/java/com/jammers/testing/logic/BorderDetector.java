package com.jammers.testing.logic;

import static com.jammers.testing.Constants.GAME_WIDTH;
import static com.jammers.testing.stuff.Direction.LEFT;
import static com.jammers.testing.stuff.Direction.RIGHT;

import com.jammers.testing.stuff.Pig;
import com.jammers.testing.stuff.Room;
import com.jammers.testing.stuff.RoomData;
import com.jammers.testing.stuff.Stuff;

public class BorderDetector {

    private final TransitionHandler transitionHandler;
    private final Room room;
    private final Pig pig;

    public BorderDetector(TransitionHandler transitionHandler, Stuff stuff) {
        this.transitionHandler = transitionHandler;
        room = stuff.getRoom();
        pig = stuff.getPig();
    }

    public void update() {
        if (pig.getX() + pig.getWidth() < 0) {
            RoomData nextRoomData = room.getConnectedRoom(LEFT);
            if (nextRoomData == null) pig.setX(0f);
            else transitionHandler.start(nextRoomData, LEFT);

        } else if (pig.getX() > GAME_WIDTH) {
            RoomData nextRoomData = room.getConnectedRoom(RIGHT);
            if (nextRoomData == null) pig.setX(GAME_WIDTH - pig.getWidth());
            else transitionHandler.start(nextRoomData, RIGHT);
        }
    }
}
