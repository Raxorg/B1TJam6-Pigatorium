package com.jammers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class Movement
{
    Vector2 velocity = new Vector2(0,0);
    Character character;

    public Movement(Character character)
    {
        this.character = character;
    }

    public void input()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.A))
        {
            if (!(Math.abs(velocity.x) == 10)) velocity.x-=2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D))
        {
            if(!(Math.abs(velocity.x) == 10)) velocity.x+=2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S))
        {
            if(!(Math.abs(velocity.y) == 10)) velocity.y-=2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W))
        {
            if(!(Math.abs(velocity.y) == 10)) velocity.y+=2;
        }

    }

    public void physics()
    {
        character.setVelocity(velocity);
        character.translate(velocity.x,  velocity.y);
        if(velocity.y > 0)velocity.y = velocity.y-1f;
        if(velocity.x > 0)velocity.x = velocity.x-1f;
        if(velocity.x < 0)velocity.x = velocity.x+1f;
        if(velocity.y < 0)velocity.y = velocity.y+1f;
    }

}
