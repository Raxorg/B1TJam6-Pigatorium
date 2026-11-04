package com.jammers.testing.logic;

import com.jammers.testing.stuff.Dialog;
import com.jammers.testing.stuff.Stuff;

public class DialogHandler {

    private Dialog dialog;
    private float time;

    public DialogHandler(Stuff stuff) {
        dialog = stuff.getDialog();
    }

    public void update(float delta) {
        time += delta;
        if (time >= 0.1f) {
            time -= delta;
        }

    }
}
