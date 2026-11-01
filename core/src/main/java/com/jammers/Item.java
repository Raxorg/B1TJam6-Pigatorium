package com.jammers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Item
{
    Vector2 position = new Vector2(MathUtils.random(0, 100), MathUtils.random(0, 100));
    boolean holding = false;
    public Vector2 getPosition()
    {
        return position;
    }

    public void setPosition(Vector2 position1)
    {
        this.position = position1;
    }
    public void pickUp(Character character)
    {
        position = new Vector2(character.getX() + character.getWidth() / 2f, character.getY() + character.getHeight() / 2f);
    }


    public void loop(Character character, ShapeRenderer shapeRenderer)
    {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            if (holding)
            {
                holding = false;
            }
            else if (Math.abs(character.getX() - position.x) <= 100 && Math.abs(character.getY() - position.y) <= 100)
            {
                holding = true;
            }
        }
        if(holding) pickUp(character);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.TEAL);
        shapeRenderer.rect(position.x, position.y, 100,100);
        shapeRenderer.end();
    }
}
