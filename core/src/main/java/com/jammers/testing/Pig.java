package com.jammers.testing;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jammers.testing.stuff.Direction;

public class Pig {

    private final Sprite sprite;
    private final Animation<Sprite> walkingRight;
    private final Animation<Sprite> walkingLeft;
    private final Animation<Sprite> walkingUp;
    private final Animation<Sprite> walkingDown;

    private float animTime = 0f;
    private Direction currentDirection = Direction.RIGHT;

    public Pig(Sprite[] sprites) {
        sprite = new Sprite();

        walkingRight = new Animation<>(0.1f, sprites[0], sprites[1], sprites[2], sprites[3]);
        walkingRight.setPlayMode(Animation.PlayMode.LOOP);
        walkingLeft = new Animation<>(0.1f, sprites[4], sprites[5], sprites[6], sprites[7]);
        walkingLeft.setPlayMode(Animation.PlayMode.LOOP);
        walkingDown = new Animation<>(0.1f, sprites[8], sprites[9], sprites[10], sprites[11]);
        walkingDown.setPlayMode(Animation.PlayMode.LOOP);
        walkingUp = new Animation<>(0.1f, sprites[12], sprites[13], sprites[14], sprites[15]);
        walkingUp.setPlayMode(Animation.PlayMode.LOOP);

        // Use frame 1 of the initial direction (DOWN, sprites[12]) as the idle sprite
        sprite.set(sprites[12]);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public void update(float delta, float moveX, float moveY) {
        boolean isMoving = (moveX != 0f || moveY != 0f);

        if (isMoving) {
            // Determine direction based on movement input
            if (Math.abs(moveX) > Math.abs(moveY)) {
                if (moveX > 0) currentDirection = Direction.RIGHT;
                else if (moveX < 0) currentDirection = Direction.LEFT;
            } else {
                if (moveY > 0) currentDirection = Direction.UP;
                else if (moveY < 0) currentDirection = Direction.DOWN;
            }

            animTime += delta;
        } else {
            animTime = 0f;
        }

        Animation<Sprite> currentAnim = getAnimationForDirection(currentDirection);
        Sprite frameSprite = currentAnim.getKeyFrame(animTime);

        // Preserve current world position while updating to the new frame sprite
        // (which correctly preserves atlas rotation / transform properties like rotate: 90)
        float x = sprite.getX();
        float y = sprite.getY();
        sprite.set(frameSprite);
        sprite.setPosition(x, y);
    }

    private Animation<Sprite> getAnimationForDirection(Direction dir) {
        switch (dir) {
            case RIGHT:
                return walkingRight;
            case LEFT:
                return walkingLeft;
            case UP:
                return walkingUp;
            case DOWN:
            default:
                return walkingDown;
        }
    }

    public void translate(float xAmount, float yAmount) {
        sprite.translate(xAmount, yAmount);
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    public void setX(float x) {
        sprite.setX(x);
    }

    public void setY(float y) {
        sprite.setY(y);
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    public float getWidth() {
        return sprite.getWidth();
    }

    public float getHeight() {
        return sprite.getHeight();
    }
}
