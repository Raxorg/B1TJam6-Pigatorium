package com.jammers;

import com.jammers.testing.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter
{
    Item item;
    Movement movement;
    Character character;
    ShapeRenderer shapeRenderer;
    ExtendViewport extendViewport ;
    SpriteBatch spriteBatch;
    Pigatorium pigatorium;
    @Override
    public void create()
    {

        item = new Item();
        extendViewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer = new ShapeRenderer();
        spriteBatch = new SpriteBatch();
        character = new Character();
        movement = new Movement(character);
        pigatorium = new Pigatorium();
        pigatorium.create();
    }

    @Override
    public void resize(int width, int height)
    {
        extendViewport.update(width, height);
        pigatorium.resize(width, height);
    }
    @Override
    public void render()
    {
       ScreenUtils.clear(Color.BLACK);
       extendViewport.apply();
       pigatorium.render();

    }
}
