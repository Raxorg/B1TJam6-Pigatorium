package com.jammers.temp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class SpriteMovement {

    private final Vector2 velocity = new Vector2(0, 0);
    private final SpriteCharacter character;

    private static final float MAX_SPEED = 400f;
    private static final float ACCELERATION = 1500f;
    private static final float FRICTION = 1200f;

    public SpriteMovement(SpriteCharacter character) {
        this.character = character;
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
        character.translate(velocity.x * delta, velocity.y * delta);

        // Update character animation with input directions
        character.update(delta, moveX, moveY);
    }
}
