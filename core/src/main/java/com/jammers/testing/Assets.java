package com.jammers.testing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {

    private final Sprite[] atlasSprites;
    private final Sprite shrine, shrineActive, church;
    private final Sprite book;
    private final Sprite pixel, god, god2, arrow;
    private final Sprite judgement;
    private final BitmapFont determination;
    private final Sound pickUpSound, putDownSound, deepVoiceJudgement;

    public Assets() {
        TextureAtlas pigAtlas = new TextureAtlas("pig.atlas");
        atlasSprites = pigAtlas.createSprites().items;

        shrine = new Sprite(new Texture("raw/shrine-2.png"));
        shrineActive = new Sprite(new Texture("raw/shrineActive.png"));
        church = new Sprite(new Texture("raw/church.png"));

        TextureAtlas itemAtlas = new TextureAtlas("sprites/32x32/items/items.atlas");
        book = itemAtlas.createSprite("book");

        pixel = new Sprite(new Texture("pixel.png"));
        god = new Sprite(new Texture("god.png"));
        god2 = new Sprite(new Texture("god2.png"));
        arrow = new Sprite(new Texture("arrow.png"));

        judgement = new Sprite(new Texture("raw/judgement.png"));

        determination = new BitmapFont(Gdx.files.internal("fonts/determination_12.fnt"));

        pickUpSound = Gdx.audio.newSound(Gdx.files.internal("Audio/SFX/pickUp.ogg"));
        putDownSound = Gdx.audio.newSound(Gdx.files.internal("Audio/SFX/putDown.ogg"));
        deepVoiceJudgement = Gdx.audio.newSound(Gdx.files.internal("Audio/VA/deepVoiceJudgement.ogg"));
    }

    public Sprite[] getAtlasSprites() {
        return atlasSprites;
    }

    public Sprite getShrine() {
        return shrine;
    }

    public Sprite getShrineActive() {
        return shrineActive;
    }

    public Sprite getChurch() {
        return church;
    }

    public Sprite getBook() {
        return book;
    }

    public Sprite getPixel() {
        return pixel;
    }

    public Sprite getGod() {
        return god;
    }

    public Sprite getGod2() {
        return god2;
    }

    public Sprite getArrow() {
        return arrow;
    }

    public Sprite getJudgement() {
        return judgement;
    }

    public BitmapFont getDetermination() {
        return determination;
    }

    public Sound getPickUpSound() {
        return pickUpSound;
    }

    public Sound getPutDownSound() {
        return putDownSound;
    }

    public Sound getDeepVoiceJudgement() {
        return deepVoiceJudgement;
    }

    public void dispose() {
        atlasSprites[0].getTexture().dispose();
        shrine.getTexture().dispose();
        shrineActive.getTexture().dispose();
        church.getTexture().dispose();
        book.getTexture().dispose();
        pixel.getTexture().dispose();
        god.getTexture().dispose();
        god2.getTexture().dispose();
        arrow.getTexture().dispose();
        judgement.getTexture().dispose();
        determination.dispose();
        pickUpSound.dispose();
        putDownSound.dispose();
        deepVoiceJudgement.dispose();
    }
}
