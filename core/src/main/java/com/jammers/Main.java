package com.jammers;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
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
    @Override
    public void create()
    {
        item = new Item();
        extendViewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer = new ShapeRenderer();
        character = new Character(shapeRenderer);
        movement = new Movement(character);
        character.setX(100);
        character.setY(100);
        character.setWidth(100);
        character.setHeight(100);
        character.setColor(Color.MAROON);
    }

    @Override
    public void resize(int width, int height)
    {
        extendViewport.update(width, height);
    }
    @Override
    public void render()
    {
        ScreenUtils.clear(Color.BLACK);
        extendViewport.apply();
        shapeRenderer.setProjectionMatrix(extendViewport.getCamera().combined);
        movement.input();
        movement.physics();
        item.loop(character, shapeRenderer);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(character.getX(), character.getY(), character.getWidth(), character.getHeight(),
        character.getColor(), character.getColor(), character.getColor(), character.getColor());
        shapeRenderer.end();

    }
}
