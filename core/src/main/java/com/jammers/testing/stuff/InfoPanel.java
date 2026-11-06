package com.jammers.testing.stuff;

import static com.jammers.testing.Constants.DARK_COLOR;
import static com.jammers.testing.Constants.GAME_HEIGHT;
import static com.jammers.testing.Constants.GAME_WIDTH;
import static com.jammers.testing.Constants.INFO_BG_HEIGHT;
import static com.jammers.testing.Constants.INFO_BG_WIDTH;
import static com.jammers.testing.Constants.INFO_BG_X;
import static com.jammers.testing.Constants.INFO_BG_Y;
import static com.jammers.testing.Constants.INFO_HOME_SIZE;
import static com.jammers.testing.Constants.INFO_HOME_X;
import static com.jammers.testing.Constants.INFO_HOME_Y;
import static com.jammers.testing.Constants.INFO_STRIPE_HEIGHT;
import static com.jammers.testing.Constants.INFO_STRIPE_WIDTH;
import static com.jammers.testing.Constants.INFO_STRIPE_X;
import static com.jammers.testing.Constants.INFO_STRIPE_Y;
import static com.jammers.testing.Constants.JUDGEMENT_LABEL_X;
import static com.jammers.testing.Constants.JUDGEMENT_LABEL_Y;
import static com.jammers.testing.Constants.LIGHT_COLOR;
import static com.jammers.testing.Constants.ROOM_LABEL_X;
import static com.jammers.testing.Constants.ROOM_LABEL_Y;
import static com.jammers.testing.Constants.TIMER_BG_HEIGHT;
import static com.jammers.testing.Constants.TIMER_BG_WIDTH;
import static com.jammers.testing.Constants.TIMER_BG_X;
import static com.jammers.testing.Constants.TIMER_BG_Y;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jammers.testing.Assets;

public class InfoPanel {

    private final Sprite background, stripe, home, timerBackground;
    private final Text roomLabel, judgementLabel, timerText;

    public InfoPanel(Assets assets) {
        background = new Sprite(assets.getPixel());
        background.setPosition(INFO_BG_X, INFO_BG_Y);
        background.setSize(INFO_BG_WIDTH, INFO_BG_HEIGHT);
        background.setColor(LIGHT_COLOR);

        stripe = new Sprite(assets.getPixel());
        stripe.setPosition(INFO_STRIPE_X, INFO_STRIPE_Y);
        stripe.setSize(INFO_STRIPE_WIDTH, INFO_STRIPE_HEIGHT);
        stripe.setColor(DARK_COLOR);

        home = new Sprite(assets.getHome());
        home.setPosition(INFO_HOME_X, INFO_HOME_Y);
        home.setSize(INFO_HOME_SIZE, INFO_HOME_SIZE);

        timerBackground = new Sprite(assets.getPixel());
        timerBackground.setPosition(TIMER_BG_X, TIMER_BG_Y);
        timerBackground.setSize(TIMER_BG_WIDTH, TIMER_BG_HEIGHT);
        timerBackground.setColor(DARK_COLOR);

        roomLabel = new Text(assets.getDetermination());
        roomLabel.setPosition(ROOM_LABEL_X, ROOM_LABEL_Y);
        roomLabel.setVerticallyCentered(true);
        roomLabel.setScale(1.2f);
        roomLabel.setColor(LIGHT_COLOR);

        judgementLabel = new Text(assets.getDetermination(), "UNTIL JUDGEMENT");
        judgementLabel.setPosition(JUDGEMENT_LABEL_X, JUDGEMENT_LABEL_Y);
        judgementLabel.hAlignCenter();
        judgementLabel.setVerticallyCentered(true);
        judgementLabel.setScale(1.2f);
        judgementLabel.setColor(LIGHT_COLOR);
        judgementLabel.setTargetWidth(INFO_BG_WIDTH);

        timerText = new Text(assets.getDetermination(), "00:00");
        timerText.setX(GAME_WIDTH * 0.5f - timerText.getWidth() * 0.5f);
        timerText.setY(GAME_HEIGHT - 10f);
        timerText.setColor(LIGHT_COLOR);
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        stripe.draw(spriteBatch);
        home.draw(spriteBatch);
        timerBackground.draw(spriteBatch);
        roomLabel.draw(spriteBatch);
        judgementLabel.draw(spriteBatch);
        timerText.draw(spriteBatch);
    }

    public Text getRoomLabel() {
        return roomLabel;
    }

    public Text getTimerText() {
        return timerText;
    }
}
