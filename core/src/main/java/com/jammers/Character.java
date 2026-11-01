package com.jammers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Character
{
    private float x = 0, y = 0, width = 10, height = 10;
    Vector2 velocity = new Vector2();

    public Vector2 getVelocity()
    {
        return velocity;
    }

    public void setVelocity(Vector2 velocity2)
    {
        this.velocity = velocity2;
    }

    public float getWidth()
    {
        return width;
    }

    public float getHeight()
    {
        return height;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }

    public void setWidth(float width)
    {
        this.width = width;
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    private Color color;

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public void translate(float x, float y)
    {
        this.x += x;
        this.y += y;
    }

    public void translateX(float x)
    {
        this.x += x;
    }

    public void translateY(float y)
    {
        this.y += y;
    }

    ShapeRenderer shapeRenderer;

    public Character(ShapeRenderer shapeRenderer)
    {
        this.color = color;
        this.shapeRenderer = shapeRenderer;
    }

    public void draw(ShapeRenderer shapeRenderer)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(x, y, width, height, color,color,color,color);
        shapeRenderer.end();
    }
}
