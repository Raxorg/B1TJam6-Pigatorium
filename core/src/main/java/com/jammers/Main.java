package com.jammers;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter
{
    Movement movement;
    Character character;
    ShapeRenderer shapeRenderer;
    @Override
    public void create()
    {
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
    public void render()
    {
    ScreenUtils.clear(Color.BLACK);
    movement.input();
    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
    shapeRenderer.rect(character.getX(), character.getY(), character.getWidth(), character.getHeight(),
    character.getColor(), character.getColor(), character.getColor(), character.getColor());
    shapeRenderer.end();
    }
}
