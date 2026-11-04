package com.jammers.testing.logic;

import static com.badlogic.gdx.Input.Keys.F;

import com.badlogic.gdx.Gdx;
import com.jammers.testing.stuff.Dialog;
import com.jammers.testing.stuff.Stuff;

public class DialogHandler {

    private final Dialog dialog;
    private String targetText;
    private int index;
    private float time;
    private boolean active;

    public DialogHandler(Stuff stuff) {
        dialog = stuff.getDialog();
        dialog.hide();
    }

    public void startDialog(String text) {
        targetText = text;
        index = 0;
        time = 0f;
        active = true;
        dialog.setDialogText("");
        dialog.show();
    }

    public void hideDialog() {
        dialog.hide();
        active = false;
    }

    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(F)) {
            startDialog("Place your offerings within the circle, and I shall judge their worth.");
        }

        if (!active) return;

        time += delta;
        if (time >= 0.2f) {
            time -= 0.2f;
            dialog.setDialogText(targetText.substring(0, index));
            index++;
            if (index > targetText.length()) active = false;
        }
    }
}
