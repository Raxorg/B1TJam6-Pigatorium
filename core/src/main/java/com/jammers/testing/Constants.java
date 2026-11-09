package com.jammers.testing;

import com.badlogic.gdx.graphics.Color;

public class Constants {

    public static final Color DARK_COLOR = new Color(0x382B26FF);
    public static final Color LIGHT_COLOR = new Color(0xBAC0B5FF);
    public static final float GAME_WIDTH = 480f;
    public static final float GAME_HEIGHT = 480f;

    public static final int REQUIRED_FAVOR = 100;
    public static final float MAX_SPEED = 300f;
    public static final float ACCELERATION = 1500f;
    public static final float FRICTION = 1200f;

    public static final float DIALOG_X = 4f;
    public static final float DIALOG_Y = 4f;
    public static final float DIALOG_WIDTH = GAME_WIDTH - 10f;
    public static final float DIALOG_HEIGHT = 60f;
    public static final float DIALOG_THICKNESS = 2.5f;

    public static final float DIALOG_LABEL_BG_HEIGHT = 20f;
    public static final float DIALOG_LABEL_BG_X = DIALOG_X + 10f;
    public static final float DIALOG_LABEL_BG_Y = DIALOG_Y + DIALOG_HEIGHT - DIALOG_LABEL_BG_HEIGHT * 0.5f - DIALOG_THICKNESS * 0.5f;
    public static final float DIALOG_LABEL_X = DIALOG_LABEL_BG_X + 5f;
    public static final float DIALOG_LABEL_Y = DIALOG_LABEL_BG_Y + DIALOG_LABEL_BG_HEIGHT * 0.5f;
    public static final float DIALOG_TEXT_X = DIALOG_LABEL_X;
    public static final float DIALOG_TEXT_Y = DIALOG_Y + DIALOG_HEIGHT * 0.5f;

    public static final float END_DIALOG_Y = 202f;

    public static final float GOD_SIZE = 175f;
    public static final float GOD_X = GAME_WIDTH * 0.5f - GOD_SIZE * 0.5f;
    public static final float GOD_Y = END_DIALOG_Y + DIALOG_HEIGHT;

    public static final float INFO_BG_WIDTH = GAME_WIDTH - 30f;
    public static final float INFO_BG_HEIGHT = 40f;
    public static final float INFO_BG_X = 15f;
    public static final float INFO_BG_Y = GAME_HEIGHT - INFO_BG_HEIGHT - 14f;

    public static final float INFO_STRIPE_X = INFO_BG_X;
    public static final float INFO_STRIPE_Y = INFO_BG_Y + 2.5f;
    public static final float INFO_STRIPE_WIDTH = INFO_BG_WIDTH;
    public static final float INFO_STRIPE_HEIGHT = INFO_BG_HEIGHT - 5f;

    public static final float INFO_HOME_SIZE = 13f;
    public static final float INFO_HOME_X = INFO_BG_X;
    public static final float INFO_HOME_Y = INFO_BG_Y + INFO_BG_HEIGHT * 0.5f - INFO_HOME_SIZE * 0.5f;

    public static final float TIMER_BG_WIDTH = 45f;
    public static final float TIMER_BG_HEIGHT = 30f;
    public static final float TIMER_BG_X = INFO_BG_X + INFO_BG_WIDTH * 0.5f - TIMER_BG_WIDTH * 0.5f;
    public static final float TIMER_BG_Y = INFO_BG_Y + INFO_BG_HEIGHT - TIMER_BG_HEIGHT * 0.5f;

    public static final float ROOM_LABEL_X = INFO_HOME_X + INFO_HOME_SIZE + 7f;
    public static final float ROOM_LABEL_Y = INFO_HOME_Y + INFO_HOME_SIZE * 0.5f - 1f;

    public static final float JUDGEMENT_LABEL_X = INFO_BG_X;
    public static final float JUDGEMENT_LABEL_Y = INFO_BG_Y + INFO_BG_HEIGHT * 0.5f - 1f;
}
