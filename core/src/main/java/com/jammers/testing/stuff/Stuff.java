package com.jammers.testing.stuff;

import static com.jammers.testing.stuff.Direction.DOWN;
import static com.jammers.testing.stuff.Direction.LEFT;
import static com.jammers.testing.stuff.Direction.RIGHT;
import static com.jammers.testing.stuff.Direction.UP;
import static com.jammers.testing.stuff.RoomEnum.CHURCH;
import static com.jammers.testing.stuff.RoomEnum.GARDEN;
import static com.jammers.testing.stuff.RoomEnum.GRASS;
import static com.jammers.testing.stuff.RoomEnum.HALLWAY;
import static com.jammers.testing.stuff.RoomEnum.KITCHEN;
import static com.jammers.testing.stuff.RoomEnum.LIBRARY;
import static com.jammers.testing.stuff.RoomEnum.MESS_HALL;
import static com.jammers.testing.stuff.RoomEnum.OUTSIDE;
import static com.jammers.testing.stuff.RoomEnum.SHRINE;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.jammers.testing.Assets;

import java.util.EnumMap;

public class Stuff {

    private final Pig pig;
    private final Room currentRoom;
    private final InfoPanel infoPanel;
    private final Array<Sprite> arrows;
    private final Dialog dialog;
    private final JudgementScreen judgementScreen;
    private final EnumMap<RoomEnum, RoomData> roomDataMap;

    public Stuff(Assets assets) {
        pig = new Pig(assets.getAtlasSprites());
        pig.setPosition(
            (320 - pig.getWidth()) / 2f,
            (320 - pig.getHeight()) / 2f
        );
        roomDataMap = new EnumMap<>(RoomEnum.class);
        populateRoomDataMap(assets);
        connectRooms();
        currentRoom = new Room(roomDataMap.get(SHRINE));
        infoPanel = new InfoPanel(assets);
        arrows = new Array<>();
        dialog = new Dialog(assets.getPixel(), assets.getDetermination(), assets.getGod());
        judgementScreen = new JudgementScreen(assets);
    }

    private void populateRoomDataMap(Assets assets) {
        roomDataMap.put(KITCHEN, new RoomData("KITCHEN", assets.getKitchen(), assets.getRoomCollider("kitchen")));
        roomDataMap.put(MESS_HALL, new RoomData("MESS HALL", assets.getMessHall(), assets.getRoomCollider("messhall")));
        roomDataMap.put(HALLWAY, new RoomData("HALLWAY", assets.getHallway(), assets.getRoomCollider("hallway")));
        roomDataMap.put(SHRINE, new RoomData("THE SHRINE", assets.getShrine(), assets.getRoomCollider("shrine")));
        roomDataMap.put(LIBRARY, new RoomData("LIBRARY", assets.getLibrary(), assets.getRoomCollider("library")));
        roomDataMap.put(CHURCH, new RoomData("CHURCH", assets.getChurch(), assets.getRoomCollider("church")));
        roomDataMap.put(GARDEN, new RoomData("GARDEN", assets.getGarden(), assets.getRoomCollider("garden")));
        roomDataMap.put(OUTSIDE, new RoomData("OUTSIDE", assets.getOutside(), assets.getRoomCollider("outside")));
        roomDataMap.put(GRASS, new RoomData("GRASS OF DOOM", assets.getGrass(), assets.getRoomCollider("grass")));
    }

    private void connectRooms() {
        RoomData kitchen = roomDataMap.get(KITCHEN);
        RoomData messHall = roomDataMap.get(MESS_HALL);
        RoomData hallway = roomDataMap.get(HALLWAY);
        RoomData shrine = roomDataMap.get(SHRINE);
        RoomData library = roomDataMap.get(LIBRARY);
        RoomData church = roomDataMap.get(CHURCH);
        RoomData garden = roomDataMap.get(GARDEN);
        RoomData outside = roomDataMap.get(OUTSIDE);
        RoomData grass = roomDataMap.get(GRASS);

        kitchen.connectRoom(RIGHT, messHall);

        messHall.connectRoom(LEFT, kitchen);
        messHall.connectRoom(RIGHT, hallway);

        hallway.connectRoom(LEFT, messHall);
        hallway.connectRoom(RIGHT, shrine);

        shrine.connectRoom(LEFT, hallway);
        shrine.connectRoom(RIGHT, library);
        shrine.connectRoom(DOWN, church);

        library.connectRoom(LEFT, shrine);

        church.connectRoom(UP, shrine);
        church.connectRoom(DOWN, outside);

        garden.connectRoom(RIGHT, outside);

        outside.connectRoom(UP, church);
        outside.connectRoom(LEFT, garden);
        outside.connectRoom(RIGHT, grass);

        grass.connectRoom(LEFT, outside);
    }

    public Pig getPig() {
        return pig;
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

    public EnumMap<RoomEnum, RoomData> getRoomDataMap() {
        return roomDataMap;
    }
}
