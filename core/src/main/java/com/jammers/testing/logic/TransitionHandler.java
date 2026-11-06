package com.jammers.testing.logic;

import static com.jammers.testing.Constants.GAME_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jammers.testing.stuff.Direction;
import com.jammers.testing.stuff.InfoPanel;
import com.jammers.testing.stuff.Pig;
import com.jammers.testing.stuff.Room;
import com.jammers.testing.stuff.RoomData;
import com.jammers.testing.stuff.Stuff;

public class TransitionHandler {

    private final ArrowHandler arrowHandler;
    private final Sprite sprite;
    private float alpha = 0f;
    private static final float DURATION = 0.5f;
    private boolean isTransitioning = false;
    private boolean fadingOut = true;
    private RoomData nextRoomData;
    private final Room room;
    private final InfoPanel infoPanel;
    private final Pig pig;
    private Direction transitionDirection;

    public TransitionHandler(ArrowHandler arrowHandler, Stuff stuff) {
        this.arrowHandler = arrowHandler;
        sprite = new Sprite(new Texture("pixel.png"));
        sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        room = stuff.getRoom();
        infoPanel = stuff.getInfoPanel();
        pig = stuff.getPig();
    }

    public void start(RoomData nextRoomData, Direction transitionDirection) {
        if (isTransitioning) return;
        this.isTransitioning = true;
        this.fadingOut = true;
        this.alpha = 0f;
        this.nextRoomData = nextRoomData;
        this.transitionDirection = transitionDirection;
    }

    public void update(float delta) {
        if (!isTransitioning) return;

        if (fadingOut) {
            alpha += delta / DURATION;
            if (alpha >= 1f) {
                alpha = 1f;
                fadingOut = false;
                setupRoom();
            }
        } else {
            alpha -= delta / DURATION;
            if (alpha <= 0f) {
                alpha = 0f;
                isTransitioning = false;
            }
        }
    }

    private void setupRoom() {
        room.set(nextRoomData);
        switch (transitionDirection) {
            case LEFT:
                pig.setX(GAME_WIDTH - pig.getWidth());
                break;
            case RIGHT:
                pig.setX(0f);
                break;
        }
        infoPanel.getRoomLabel().setText(nextRoomData.getName());
        arrowHandler.updateArrows(nextRoomData);
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
