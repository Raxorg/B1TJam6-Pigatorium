package com.jammers;

import static com.jammers.rooms.Room.Direction.LEFT;
import static com.jammers.rooms.Room.Direction.RIGHT;

import com.badlogic.gdx.Gdx;
import com.jammers.rooms.Room;
import com.jammers.temp.SpriteCharacter;

public class BorderDetection {

    private final Transition transition;
    private final SpriteCharacter character;
    private final Listener<Room> borderListener;
    private Room.Direction transitionDirection;

    public BorderDetection(Transition transition, SpriteCharacter character, Listener<Room> transitionListener) {
        this.transition = transition;
        this.character = character;
        borderListener = object -> {
            switch (transitionDirection) {
                case LEFT:
                    character.setX(Gdx.graphics.getWidth() - character.getWidth());
                    break;
                case RIGHT:
                    character.setX(0f);
                    break;
            }
            transitionListener.trigger(object);
        };
    }

    public void update(Room currentRoom) {
        float screenWidth = Gdx.graphics.getWidth();

        if (character.getX() + character.getWidth() < 0) {
            Room nextRoom = currentRoom.getConnectedRoom(LEFT);
            if (nextRoom == null) character.setX(0f);
            else {
                transition.start(nextRoom, borderListener);
                transitionDirection = LEFT;
            }
        } else if (character.getX() > screenWidth) {
            Room nextRoom = currentRoom.getConnectedRoom(RIGHT);
            if (nextRoom == null) character.setX(screenWidth - character.getWidth());
            else {
                transition.start(nextRoom, borderListener);
                transitionDirection = RIGHT;
            }
        }
    }
}
