package com.jammers.testing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {

    private final Sprite[] atlasSprites;
    private final Sprite shrine, shrineActive, church, garden, grass, hallway, kitchen, library, messHall, outside;
    private final Sprite axe, book, bread, candle, chalice, comedy, crown, dice, feather, fork, gem, grapes, items, jewel, jug,
        knife, lyre, mace, necklace, paper, pear, potion, scales, scroll, spanner, spoon, sword, teapot, tragedy, vial, wine;
    private final Sprite pixel, god, god2, arrow, home;
    private final Sprite judgement;
    private final BitmapFont determination;
    private final Sound pickUpSound, putDownSound, deepVoiceJudgement;

    public Assets() {
        TextureAtlas pigAtlas = new TextureAtlas("pig.atlas");
        atlasSprites = pigAtlas.createSprites().items;

        shrine = new Sprite(new Texture("raw/shrine-2.png"));
        shrineActive = new Sprite(new Texture("raw/shrineActive.png"));
        church = new Sprite(new Texture("raw/church.png"));
        garden = new Sprite(new Texture("sprites/320x320/map/garden.png"));
        grass = new Sprite(new Texture("sprites/320x320/map/grass.png"));
        hallway = new Sprite(new Texture("sprites/320x320/map/hallway.png"));
        kitchen = new Sprite(new Texture("sprites/320x320/map/kitchen.png"));
        library = new Sprite(new Texture("sprites/320x320/map/library.png"));
        messHall = new Sprite(new Texture("sprites/320x320/map/messHall.png"));
        outside = new Sprite(new Texture("sprites/320x320/map/outside.png"));

        TextureAtlas itemAtlas = new TextureAtlas("sprites/32x32/items/items.atlas");
        axe = itemAtlas.createSprite("axe");
        book = itemAtlas.createSprite("book");
        bread = itemAtlas.createSprite("bread");
        candle = itemAtlas.createSprite("candle");
        chalice = itemAtlas.createSprite("chalice");
        comedy = itemAtlas.createSprite("comedy");
        crown = itemAtlas.createSprite("crown");
        dice = itemAtlas.createSprite("dice");
        feather = itemAtlas.createSprite("feather");
        fork = itemAtlas.createSprite("fork");
        gem = itemAtlas.createSprite("gem");
        grapes = itemAtlas.createSprite("grapes");
        items = itemAtlas.createSprite("items");
        jewel = itemAtlas.createSprite("jewel");
        jug = itemAtlas.createSprite("jug");
        knife = itemAtlas.createSprite("knife");
        lyre = itemAtlas.createSprite("lyre");
        mace = itemAtlas.createSprite("mace");
        necklace = itemAtlas.createSprite("necklace");
        paper = itemAtlas.createSprite("paper");
        pear = itemAtlas.createSprite("pear");
        potion = itemAtlas.createSprite("potion");
        scales = itemAtlas.createSprite("scales");
        scroll = itemAtlas.createSprite("scroll");
        spanner = itemAtlas.createSprite("spanner");
        spoon = itemAtlas.createSprite("spoon");
        sword = itemAtlas.createSprite("sword");
        teapot = itemAtlas.createSprite("teapot");
        tragedy = itemAtlas.createSprite("tragedy");
        vial = itemAtlas.createSprite("vial");
        wine = itemAtlas.createSprite("wine");

        pixel = new Sprite(new Texture("pixel.png"));
        god = new Sprite(new Texture("god.png"));
        god2 = new Sprite(new Texture("god2.png"));
        arrow = new Sprite(new Texture("arrow.png"));
        home = new Sprite(new Texture("home.png"));

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

    public Sprite getGarden() {
        return garden;
    }

    public Sprite getGrass() {
        return grass;
    }

    public Sprite getHallway() {
        return hallway;
    }

    public Sprite getKitchen() {
        return kitchen;
    }

    public Sprite getLibrary() {
        return library;
    }

    public Sprite getMessHall() {
        return messHall;
    }

    public Sprite getOutside() {
        return outside;
    }

    public Sprite getAxe() {
        return axe;
    }

    public Sprite getBook() {
        return book;
    }

    public Sprite getBread() {
        return bread;
    }

    public Sprite getCandle() {
        return candle;
    }

    public Sprite getChalice() {
        return chalice;
    }

    public Sprite getComedy() {
        return comedy;
    }

    public Sprite getCrown() {
        return crown;
    }

    public Sprite getDice() {
        return dice;
    }

    public Sprite getFeather() {
        return feather;
    }

    public Sprite getFork() {
        return fork;
    }

    public Sprite getGem() {
        return gem;
    }

    public Sprite getGrapes() {
        return grapes;
    }

    public Sprite getJewel() {
        return jewel;
    }

    public Sprite getJug() {
        return jug;
    }

    public Sprite getKnife() {
        return knife;
    }

    public Sprite getLyre() {
        return lyre;
    }

    public Sprite getMace() {
        return mace;
    }

    public Sprite getNecklace() {
        return necklace;
    }

    public Sprite getPaper() {
        return paper;
    }

    public Sprite getPear() {
        return pear;
    }

    public Sprite getPotion() {
        return potion;
    }

    public Sprite getScales() {
        return scales;
    }

    public Sprite getScroll() {
        return scroll;
    }

    public Sprite getSpanner() {
        return spanner;
    }

    public Sprite getSpoon() {
        return spoon;
    }

    public Sprite getSword() {
        return sword;
    }

    public Sprite getTeapot() {
        return teapot;
    }

    public Sprite getTragedy() {
        return tragedy;
    }

    public Sprite getVial() {
        return vial;
    }

    public Sprite getWine() {
        return wine;
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

    public Sprite getHome() {
        return home;
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
        home.getTexture().dispose();
        judgement.getTexture().dispose();
        determination.dispose();
        pickUpSound.dispose();
        putDownSound.dispose();
        deepVoiceJudgement.dispose();
    }
}
