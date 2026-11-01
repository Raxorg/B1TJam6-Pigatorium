package com.jammers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class Movement
{
    Character character;
    Vector2 velocity = new Vector2(0,0);
    public Movement(Character character)
    {
        this.character = character;
    }
    public void input()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {character.translateX(velocity.x-=1); return ;}
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {character.translateX(velocity.x+=1); return ;}
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {character.translateY(velocity.y-=1); return ;}
        if(Gdx.input.isKeyPressed(Input.Keys.W)){ character.translateY(velocity.y+=1); return ;}
        if(velocity.x > 0) velocity.x-=.05f;
        if(velocity.x < 0) velocity.x+=.05f;
        if(velocity.y > 0) velocity.y-=.05f;
        if(velocity.y < 0) velocity.y+=.05f;
    }

}
