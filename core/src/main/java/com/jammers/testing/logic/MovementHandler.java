package com.jammers.testing.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jammers.testing.stuff.Pig;
import com.jammers.testing.stuff.Stuff;

public class MovementHandler {

    private final Vector2 velocity = new Vector2(0, 0);
    private final Pig pig;
    Stuff stuff;

    private static final float MAX_SPEED = 300f;
    private static final float ACCELERATION = 1500f;
    private static final float FRICTION = 1200f;

    public MovementHandler(Stuff stuff) {
        this.pig = stuff.getPig();
        this.stuff = stuff;
    }

    public void update(float delta) {
        boolean collided = false;
        Rectangle collider = null;
        for (int i = 0; i < stuff.getRoom().getRoomData().getColliderRects().size-1; i++)
        {
            collided = pig.getBoundingRectangle().overlaps(stuff.getRoom().getRoomData().getColliderRects().get(i));
            if (collided)
            {
                collider = stuff.getRoom().getRoomData().getColliderRects().get(i);
                break;
            }
        }
        if (!collided)
        {
            float moveX = (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT) ? -1f : 0f) +
                (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT) ? 1f : 0f);
            float moveY = (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN) ? -1f : 0f) +
                (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP) ? 1f : 0f);

            // Apply acceleration or friction
            if (moveX != 0f)
            {
                velocity.x += moveX * ACCELERATION * delta;
            } else
            {
                if (velocity.x > 0f)
                {
                    velocity.x = Math.max(0f, velocity.x - FRICTION * delta);
                } else if (velocity.x < 0f)
                {
                    velocity.x = Math.min(0f, velocity.x + FRICTION * delta);
                }
            }

            if (moveY != 0f)
            {
                velocity.y += moveY * ACCELERATION * delta;
            } else
            {
                if (velocity.y > 0f)
                {
                    velocity.y = Math.max(0f, velocity.y - FRICTION * delta);
                } else if (velocity.y < 0f)
                {
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
        else
        {
            Rectangle pigRect = pig.getBoundingRectangle();
            float overlapX = Math.min(pigRect.x + pigRect.width - collider.x, collider.x + collider.width - pigRect.x);
            float overlapY = Math.min(pigRect.y + pigRect.height - collider.y, collider.y + collider.height - pigRect.y);

            if (overlapX < overlapY)
            {
                float dir = pigRect.x < collider.x ? -1f : 1f;
                pig.translate(dir * overlapX, 0f);
                velocity.x = 0f;
            } else
            {
                float dir = pigRect.y < collider.y ? -1f : 1f;
                pig.translate(0f, dir * overlapY);
                velocity.y = 0f;
            }
        }
        }
    }

