package com.jammers.testing.stuff;

import static com.jammers.testing.stuff.Direction.LEFT;
import static com.jammers.testing.stuff.Direction.RIGHT;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.jammers.testing.Assets;

public class Stuff {

    private final Pig pig;
    private final RoomData shrineRoomData;
    private final Room currentRoom;
    private final InfoPanel infoPanel;
    private final Array<Sprite> arrows;
    private final Dialog dialog;
    private final JudgementScreen judgementScreen;

    public Stuff(Assets assets) {
        pig = new Pig(assets.getAtlasSprites());

        Item[] shrineItems = new Item[]{
            new Item(assets.getBook(), 10)
        };
        shrineItems[0].setPosition(240f, 200f);

        shrineRoomData = new RoomData("THE SHRINE", assets.getShrine(), shrineItems);
        RoomData churchRoomData = new RoomData("THE CHURCH", assets.getChurch(), new Item[0]);
        shrineRoomData.connectRoom(LEFT, churchRoomData);
        churchRoomData.connectRoom(RIGHT, shrineRoomData);
        currentRoom = new Room(shrineRoomData);
        infoPanel = new InfoPanel(assets);
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

    public InfoPanel getInfoPanel() {
        return infoPanel;
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
