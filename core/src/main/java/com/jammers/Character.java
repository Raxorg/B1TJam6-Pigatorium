package com.jammers;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
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
    Sprite s;
    public Character()    {

        ;
    }
    public void draw(SpriteBatch s, Matrix4 m)
    {
        this.s.setPosition(x, y);
        this.s.setSize(width, height);
        s.setProjectionMatrix(m);
        s.begin();
        this.s.draw(s);
        s.end();
    }
}
