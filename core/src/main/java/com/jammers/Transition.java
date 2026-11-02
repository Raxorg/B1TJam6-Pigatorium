package com.jammers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jammers.rooms.Room;

public class Transition {

    private final Sprite sprite;
    private float alpha = 0f;
    private static final float DURATION = 0.5f;
    private boolean isTransitioning = false;
    private boolean fadingOut = true;
    private Room nextRoom;
    private Listener<Room> roomListener;

    public Transition() {
        sprite = new Sprite(new Texture("pixel.png"));
        sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void start(Room nextRoom, Listener<Room> fadeListener) {
        if (isTransitioning) return;
        this.isTransitioning = true;
        this.fadingOut = true;
        this.alpha = 0f;
        this.nextRoom = nextRoom;
        this.roomListener = fadeListener;
    }

    public void update(float delta) {
        if (!isTransitioning) return;

        if (fadingOut) {
            alpha += delta / DURATION;
            if (alpha >= 1f) {
                alpha = 1f;
                fadingOut = false;
                // position
                roomListener.trigger(nextRoom);
            }
        } else {
            alpha -= delta / DURATION;
            if (alpha <= 0f) {
                alpha = 0f;
                isTransitioning = false;
            }
        }
    }

    public void render(SpriteBatch batch) {
        if (alpha <= 0f) return;
        sprite.setColor(0, 0, 0, alpha);
        sprite.draw(batch);
    }

    public boolean isTransitioning() {
        return isTransitioning;
    }

    public float getAlpha() {
        return alpha;
    }

    public void dispose() {
        if (sprite.getTexture() != null) {
            sprite.getTexture().dispose();
        }
    }
}
