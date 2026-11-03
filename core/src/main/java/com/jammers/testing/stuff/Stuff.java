package com.jammers.testing.stuff;

import static com.jammers.testing.Constants.GAME_HEIGHT;
import static com.jammers.testing.Constants.GAME_WIDTH;
import static com.jammers.testing.stuff.Direction.LEFT;
import static com.jammers.testing.stuff.Direction.RIGHT;

import com.jammers.testing.Assets;

public class Stuff {

    private final Pig pig;
    private final Room currentRoom;
    private final Text timerText;

    public Stuff(Assets assets) {
        pig = new Pig(assets.getAtlasSprites());

        Item[] shrineItems = new Item[]{
            new Item(assets.getBook())
        };
        shrineItems[0].setPosition(240f, 200f);

        RoomData shrineRoomData = new RoomData("The Shrine Room", assets.getShrine(), shrineItems);
        RoomData churchRoomData = new RoomData("The Church", assets.getChurch(), new Item[0]);
        shrineRoomData.connectRoom(LEFT, churchRoomData);
        churchRoomData.connectRoom(RIGHT, shrineRoomData);
        currentRoom = new Room(shrineRoomData);

        timerText = new Text(assets.getTimerFont());
        timerText.setX(GAME_WIDTH * 0.5f - 40f);
        timerText.setY(GAME_HEIGHT - 10f);
    }

    public Pig getPig() {
        return pig;
    }

    public Room getRoom() {
        return currentRoom;
    }

    public Text getTimerText() {
        return timerText;
    }
}
