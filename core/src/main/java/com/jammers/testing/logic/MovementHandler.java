package com.jammers.testing.logic;

import static com.jammers.testing.Constants.ACCELERATION;
import static com.jammers.testing.Constants.FRICTION;
import static com.jammers.testing.Constants.MAX_SPEED;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.jammers.testing.stuff.Pig;
import com.jammers.testing.stuff.Stuff;

public class MovementHandler {

    private final Vector2 velocity = new Vector2(0, 0);
    private final Pig pig;

    public MovementHandler(Stuff stuff) {
        this.pig = stuff.getPig();
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

        // Move character
        pig.translate(velocity.x * delta, velocity.y * delta);

        // Update character animation with input directions
        pig.update(delta, moveX, moveY);
    }
}
