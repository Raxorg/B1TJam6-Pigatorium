package com.jammers.demos;

import static com.badlogic.gdx.graphics.Color.CLEAR;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.jammers.BorderDetection;
import com.jammers.Listener;
import com.jammers.Transition;
import com.jammers.rooms.ChurchRoom;
import com.jammers.rooms.Room;
import com.jammers.rooms.ShrineRoom;
import com.jammers.temp.SpriteCharacter;
import com.jammers.temp.SpriteMovement;

public class TransitionAndAnimationDemo extends ApplicationAdapter {

    private SpriteBatch spriteBatch;
    private TextureAtlas pigAtlas;
    private SpriteCharacter character;
    private SpriteMovement movement;
    private BorderDetection borderDetection;

    private Room currentRoom;
    private Transition transition;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        pigAtlas = new TextureAtlas("pig.atlas");
        Array<Sprite> atlasSprites = pigAtlas.createSprites();
        Sprite[] spriteArray = new Sprite[atlasSprites.size];
        for (int i = 0; i < atlasSprites.size; i++) {
            spriteArray[i] = atlasSprites.get(i);
        }
        character = new SpriteCharacter(spriteArray);
        movement = new SpriteMovement(character);

        // Position character in the center initially
        character.setPosition(350, 350);

        // Initialize rooms
        ShrineRoom shrineRoom = new ShrineRoom();
        ChurchRoom churchRoom = new ChurchRoom();

        // Connect rooms: Shrine connects to Church on the LEFT; Church connects to Shrine on the RIGHT
        shrineRoom.connectRoom(Room.Direction.LEFT, churchRoom);
        churchRoom.connectRoom(Room.Direction.RIGHT, shrineRoom);

        currentRoom = shrineRoom;
        transition = new Transition();
        borderDetection = new BorderDetection(transition, character, new Listener<Room>() {
            @Override
            public void trigger(Room nextRoom) {
                currentRoom = nextRoom;
            }
        });
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        update(delta);
        renderGame();
    }

    private void update(float delta) {
        transition.update(delta);
        movement.update(delta);
        borderDetection.update(currentRoom);
    }

    private void renderGame() {
        ScreenUtils.clear(CLEAR);

        spriteBatch.begin();
        currentRoom.draw(spriteBatch);
        character.draw(spriteBatch);
        transition.render(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        if (spriteBatch != null) {
            spriteBatch.dispose();
        }
        if (pigAtlas != null) {
            pigAtlas.dispose();
        }
        if (transition != null) {
            transition.dispose();
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
