package com.jammers.testing.logic;

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

    private void setupDialog(String text, float y) {
        targetText = text;
        index = 0;
        time = 0f;
        active = true;
        dialog.setDialogText("");
        dialog.setY(y);
    }

    public void startDialog(String text, float y) {
        setupDialog(text, y);
        dialog.show();
    }

    public void startDialogWithoutLabel(String text, float y) {
        setupDialog(text, y);
        dialog.showWithoutLabel();
    }

    public void hideDialog() {
        dialog.hide();
        active = false;
    }

    public boolean isActive() {
        return active;
    }

    public void update(float delta) {
        if (!active) return;

        time += delta;
        if (time >= 0.08f) {
            time -= 0.08f;
            dialog.setDialogText(targetText.substring(0, index));
            index++;
            if (index > targetText.length()) active = false;
        }
    }
}
