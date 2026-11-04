package com.jammers.testing;

import static com.epicness.fundamentals.constants.ColorConstants.ANSI_CYAN;
import static com.epicness.fundamentals.constants.ColorConstants.ANSI_RED;
import static com.epicness.fundamentals.constants.ColorConstants.ANSI_RESET;
import static com.epicness.fundamentals.constants.ColorConstants.ANSI_YELLOW;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.constants.ColorConstants;
import com.jammers.testing.stuff.Text;

public final class TextUtils {

    private static final GlyphLayout SHARED_LAYOUT = new GlyphLayout();

    private TextUtils() {
    }

    private static Vector2 getTextSize(BitmapFont font, String text, Vector2 result) {
        SHARED_LAYOUT.setText(font, text);
        return result.set(SHARED_LAYOUT.width, SHARED_LAYOUT.height);
    }

    private static Vector2 getTextSize(BitmapFont font, String text, float targetWidth, int hAlign, boolean wrap, String truncate, Vector2 result) {
        SHARED_LAYOUT.setText(font, text, 0, text.length(), font.getColor(), targetWidth, hAlign, wrap, truncate);
        return result.set(SHARED_LAYOUT.width, SHARED_LAYOUT.height);
    }

    /**
     * Ignores alignment and wrapping
     */
    public static float getTextWidth(BitmapFont font, String text) {
        SHARED_LAYOUT.setText(font, text);
        return SHARED_LAYOUT.width;
    }

    public static float getTextWidth(BitmapFont font, String text, float targetWidth, int hAlign, boolean wrap, String truncate) {
        SHARED_LAYOUT.setText(font, text, 0, text.length(), font.getColor(), targetWidth, hAlign, wrap, truncate);
        return SHARED_LAYOUT.width;
    }

    public static float getTextWidth(Text text) {
        return getTextWidth(
            text.getFont(),
            text.getText(),
            text.getTargetWidth(),
            text.getHAlign(),
            text.wrapEnabled(),
            text.getTruncate());
    }

    /**
     * Ignores alignment and wrapping
     */
    public static float getTextHeight(BitmapFont font, String text) {
        SHARED_LAYOUT.setText(font, text);
        return SHARED_LAYOUT.height;
    }

    public static float getTextHeight(BitmapFont font, String text, float targetWidth, int hAlign, boolean wrap, String truncate) {
        SHARED_LAYOUT.setText(font, text, 0, text.length(), font.getColor(), targetWidth, hAlign, wrap, truncate);
        return SHARED_LAYOUT.height;
    }

    public static float getTextHeight(Text text) {
        return getTextHeight(
            text.getFont(),
            text.getText(),
            text.getTargetWidth(),
            text.getHAlign(),
            text.wrapEnabled(),
            text.getTruncate());
    }
}
