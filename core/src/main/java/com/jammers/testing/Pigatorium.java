package com.jammers.testing;

import static com.jammers.testing.Constants.DARK_COLOR;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.jammers.testing.logic.Logic;
import com.jammers.testing.stuff.Stuff;

public class Pigatorium extends ApplicationAdapter {

    private OrthographicCamera camera;
    private ExtendViewport viewport;
    private SpriteBatch spriteBatch;

    private Assets assets;
    private Stuff stuff;
    private Logic logic;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new ExtendViewport(480, 480, camera);
        spriteBatch = new SpriteBatch();
        assets = new Assets();
        stuff = new Stuff(assets);
        logic = new Logic(assets, stuff);

    }

    @Override
    public void render() {
        logic.update(Gdx.graphics.getDeltaTime());
        renderGame();
    }

    private void renderGame() {
        ScreenUtils.clear(DARK_COLOR);
        viewport.apply();
        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();
        stuff.getRoom().draw(spriteBatch);
        stuff.getPig().draw(spriteBatch);
        for (int i = 0; i < stuff.getArrows().size; i++) {
            stuff.getArrows().get(i).draw(spriteBatch);
        }
        stuff.getInfoPanel().draw(spriteBatch);
        stuff.getJudgementScreen().draw(spriteBatch);
        stuff.getDialog().draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        assets.dispose();
    }
}
