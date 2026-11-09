package com.jammers.testing.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.jammers.testing.stuff.Pig;
import com.jammers.testing.stuff.Room;
import com.jammers.testing.stuff.RoomData;
import com.jammers.testing.stuff.Stuff;

public class MovementHandler {

    private final Vector2 velocity = new Vector2(0, 0);
    private final Pig pig;

    private static final float MAX_SPEED = 300f;
    private static final float ACCELERATION = 1500f;
    private static final float FRICTION = 1200f;
    private final Room room;
    private final Rectangle nextBounds = new Rectangle();

    public MovementHandler(Stuff stuff) {
        this.pig = stuff.getPig();
        room = stuff.getRoom();
    }

    public void update(float delta) {
        float moveX = (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT) ? -1f : 0f) +
            (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT) ? 1f : 0f);
        float moveY = (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN) ? -1f : 0f) +
            (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP) ? 1f : 0f);

        // Apply acceleration or friction
        if (moveX != 0f) {
            velocity.x += moveX * ACCELERATION * delta;
        } else {
            if (velocity.x > 0f) {
                velocity.x = Math.max(0f, velocity.x - FRICTION * delta);
            } else if (velocity.x < 0f) {
                velocity.x = Math.min(0f, velocity.x + FRICTION * delta);
            }
        }

        if (moveY != 0f) {
            velocity.y += moveY * ACCELERATION * delta;
        } else {
            if (velocity.y > 0f) {
                velocity.y = Math.max(0f, velocity.y - FRICTION * delta);
            } else if (velocity.y < 0f) {
                velocity.y = Math.min(0f, velocity.y + FRICTION * delta);
            }
        }

        // Clamp velocity to max speed
        velocity.clamp(0f, MAX_SPEED);

        float dx = velocity.x * delta;
        float dy = velocity.y * delta;

        if (canMove(dx, 0)) {
            pig.translate(dx, 0);
        } else {
            velocity.x = 0;
        }

        if (canMove(0, dy)) {
            pig.translate(0, dy);
        } else {
            velocity.y = 0;
        }

        // Update character animation with input directions
        pig.update(delta, moveX, moveY);

    }

    private boolean canMove(float dx, float dy) {
        RoomData roomData = room.getRoomData();
        Sprite background = roomData.getBackground();
        Array<Rectangle> colliderRects = roomData.getColliderRects();

        nextBounds.set(
            pig.getX() + dx - background.getX(),
            pig.getY() + dy - background.getY(),
            pig.getWidth(),
            pig.getHeight()
        );

        if (colliderRects != null) {
            for (Rectangle collider : colliderRects) {
                if (nextBounds.overlaps(collider)) {
                    return false;
                }
            }
        }

        return true;
    }
}
