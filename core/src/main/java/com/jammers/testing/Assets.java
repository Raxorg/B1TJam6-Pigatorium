package com.jammers.testing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {

    private final Sprite[] atlasSprites;
    private final Sprite shrine, church;
    private final Sprite book;
    private final BitmapFont timerFont;

    public Assets() {
        TextureAtlas pigAtlas = new TextureAtlas("pig.atlas");
        atlasSprites = pigAtlas.createSprites().items;

        shrine = new Sprite(new Texture("raw/shrine-2.png"));
        church = new Sprite(new Texture("raw/church.png"));

        TextureAtlas itemAtlas = new TextureAtlas("sprites/32x32/items/items.atlas");
        book = itemAtlas.createSprite("book");

        timerFont = new BitmapFont(Gdx.files.internal("fonts/determination_12.fnt"));
    }

    public Sprite[] getAtlasSprites() {
        return atlasSprites;
    }

    public Sprite getShrine() {
        return shrine;
    }

    public Sprite getChurch() {
        return church;
    }

    public Sprite getBook() {
        return book;
    }

    public BitmapFont getTimerFont() {
        return timerFont;
    }

    public void dispose() {
        atlasSprites[0].getTexture().dispose();
        shrine.getTexture().dispose();
        church.getTexture().dispose();
        book.getTexture().dispose();
        timerFont.dispose();
    }
}
