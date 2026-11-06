package com.jammers.testing.stuff;

import static com.jammers.testing.Constants.GAME_HEIGHT;
import static com.jammers.testing.Constants.GAME_WIDTH;
import static com.jammers.testing.stuff.Direction.LEFT;
import static com.jammers.testing.stuff.Direction.RIGHT;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.jammers.testing.Assets;

public class Stuff {

    private final Pig pig;
    private final RoomData shrineRoomData;
    private final Room currentRoom;
    private final Text timerText;
    private final Array<Sprite> arrows;
    private final Dialog dialog;
    private final JudgementScreen judgementScreen;

    public Stuff(Assets assets) {
        pig = new Pig(assets.getAtlasSprites());

        Item[] shrineItems = new Item[]{
            new Item(assets.getBook(), 10)
        };
        shrineItems[0].setPosition(240f, 200f);

        shrineRoomData = new RoomData("The Shrine Room", assets.getShrine(), shrineItems);
        RoomData churchRoomData = new RoomData("The Church", assets.getChurch(), new Item[0]);
        shrineRoomData.connectRoom(LEFT, churchRoomData);
        churchRoomData.connectRoom(RIGHT, shrineRoomData);
        currentRoom = new Room(shrineRoomData);

        timerText = new Text(assets.getDetermination());
        timerText.setX(GAME_WIDTH * 0.5f - 40f);
        timerText.setY(GAME_HEIGHT - 10f);

        arrows = new Array<>();
        dialog = new Dialog(assets.getPixel(), assets.getDetermination(), assets.getGod());
        judgementScreen = new JudgementScreen(assets);
    }

    public Pig getPig() {
        return pig;
    }

    public RoomData getShrineRoomData() {
        return shrineRoomData;
    }

    public Room getRoom() {
        return currentRoom;
    }

    public Text getTimerText() {
        return timerText;
    }

    public Array<Sprite> getArrows() {
        return arrows;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public JudgementScreen getJudgementScreen() {
        return judgementScreen;
    }
}
