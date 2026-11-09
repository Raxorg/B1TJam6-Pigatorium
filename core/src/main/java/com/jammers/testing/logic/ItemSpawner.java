package com.jammers.testing.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.jammers.testing.Assets;
import com.jammers.testing.stuff.Item;
import com.jammers.testing.stuff.RoomData;
import com.jammers.testing.stuff.RoomEnum;
import com.jammers.testing.stuff.Stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Stack;

public class ItemSpawner {

    private final Stack<ItemData> itemDataStack;

    public ItemSpawner(Assets assets, Stuff stuff) {
        itemDataStack = new Stack<>();
        populateItemData(assets);
        spawnItems(stuff.getRoomDataMap());
    }

    private void populateItemData(Assets assets) {
        itemDataStack.add(new ItemData(assets.getAxe(), 11, "AN AXE"));
        itemDataStack.add(new ItemData(assets.getBook(), 6, "A BOOK"));
        itemDataStack.add(new ItemData(assets.getBread(), -7, "BREAD"));
        itemDataStack.add(new ItemData(assets.getCandle(), 7, "A CANDLE"));
        itemDataStack.add(new ItemData(assets.getChalice(), 15, "A CHALICE"));
        itemDataStack.add(new ItemData(assets.getComedy(), 6, "COMEDY"));
        itemDataStack.add(new ItemData(assets.getCrown(), 13, "A CROWN"));
        itemDataStack.add(new ItemData(assets.getDice(), 5, "A DICE"));
        itemDataStack.add(new ItemData(assets.getFeather(), -3, "A FEATHER"));
        itemDataStack.add(new ItemData(assets.getFork(), -4, "A FORK"));
        itemDataStack.add(new ItemData(assets.getGem(), 14, "A GEM"));
        itemDataStack.add(new ItemData(assets.getGrapes(), 13, "GRAPES"));
        itemDataStack.add(new ItemData(assets.getJewel(), 14, "A JEWEL"));
        itemDataStack.add(new ItemData(assets.getJug(), 4, "A JUG"));
        itemDataStack.add(new ItemData(assets.getKnife(), 6, "A KNIFE"));
        itemDataStack.add(new ItemData(assets.getLyre(), 9, "A LYRE"));
        itemDataStack.add(new ItemData(assets.getMace(), 8, "A MACE"));
        itemDataStack.add(new ItemData(assets.getNecklace(), 12, "A NECKLACE"));
        itemDataStack.add(new ItemData(assets.getPaper(), -6, "A PAPER"));
        itemDataStack.add(new ItemData(assets.getPear(), -3, "A PEAR"));
        itemDataStack.add(new ItemData(assets.getPotion(), 12, "A POTION"));
        itemDataStack.add(new ItemData(assets.getScales(), 5, "SCALES"));
        itemDataStack.add(new ItemData(assets.getScroll(), 6, "A SCROLL"));
        itemDataStack.add(new ItemData(assets.getSpanner(), -4, "A SPANNER"));
        itemDataStack.add(new ItemData(assets.getSpoon(), -4, "A SPOON"));
        itemDataStack.add(new ItemData(assets.getSword(), 11, "A SWORD"));
        itemDataStack.add(new ItemData(assets.getTeapot(), -7, "A TEAPOT"));
        itemDataStack.add(new ItemData(assets.getTragedy(), 13, "TRAGEDY"));
        itemDataStack.add(new ItemData(assets.getVial(), 9, "A VIAL"));
        itemDataStack.add(new ItemData(assets.getWine(), 15, "WINE"));
        Collections.shuffle(itemDataStack);
    }

    private Item getItem(float x, float y) {
        ItemData itemData = itemDataStack.pop();
        return new Item(itemData.sprite, x, y, itemData.value, itemData.name);
    }

    private void spawnItems(EnumMap<RoomEnum, RoomData> roomDataMap) {
        List<ItemSpawnPoint> spawnPoints = new ArrayList<>();

        addSpawnPoints(spawnPoints, roomDataMap, RoomEnum.KITCHEN,
            new int[][]{{140, 300}, {140, 110}, {205, 175}, {270, 80}, {310, 335}, {340, 207}});
        addSpawnPoints(spawnPoints, roomDataMap, RoomEnum.MESS_HALL,
            new int[][]{{115, 337}, {114, 182}, {146, 87}, {205, 337}, {240, 242}, {309, 337}, {330, 210}});
        addSpawnPoints(spawnPoints, roomDataMap, RoomEnum.HALLWAY,
            new int[][]{{78, 270}, {78, 212}, {183, 212}, {212, 270}, {312, 212}, {341, 270}});
        addSpawnPoints(spawnPoints, roomDataMap, RoomEnum.LIBRARY,
            new int[][]{{110, 243}, {270, 339}, {270, 212}, {270, 108}, {335, 240}, {335, 143}});
        addSpawnPoints(spawnPoints, roomDataMap, RoomEnum.CHURCH,
            new int[][]{{140, 337}, {140, 108}, {177, 173}, {305, 170}, {305, 110}, {337, 337}});
        addSpawnPoints(spawnPoints, roomDataMap, RoomEnum.OUTSIDE,
            new int[][]{{78, 270}, {135, 145}, {280, 178}, {345, 270}});
        addSpawnPoints(spawnPoints, roomDataMap, RoomEnum.GARDEN,
            new int[][]{{140, 275}, {165, 135}, {205, 335}, {298, 135}, {338, 310}});
        addSpawnPoints(spawnPoints, roomDataMap, RoomEnum.GRASS,
            new int[][]{{135, 300}, {170, 143}, {275, 215}, {307, 300}});

        Collections.shuffle(spawnPoints);
        int itemsToSpawn = Math.min(itemDataStack.size(), spawnPoints.size());
        for (int i = 0; i < itemsToSpawn; i++) {
            ItemSpawnPoint point = spawnPoints.get(i);
            point.roomItems.add(getItem(point.x, point.y));
        }
    }

    private void addSpawnPoints(List<ItemSpawnPoint> spawnPoints,
                                EnumMap<RoomEnum, RoomData> roomDataMap,
                                RoomEnum room, int[][] coordinates) {
        DelayedRemovalArray<Item> items = roomDataMap.get(room).getItems();
        for (int[] coordinate : coordinates) {
            spawnPoints.add(new ItemSpawnPoint(items, coordinate[0], coordinate[1]));
        }
    }

    private static class ItemSpawnPoint {

        private final DelayedRemovalArray<Item> roomItems;
        private final float x;
        private final float y;

        private ItemSpawnPoint(DelayedRemovalArray<Item> roomItems, float x, float y) {
            this.roomItems = roomItems;
            this.x = x;
            this.y = y;
        }
    }

    private static class ItemData {

        private final Sprite sprite;
        private final int value;
        private final String name;

        private ItemData(Sprite sprite, int value, String name) {
            this.sprite = sprite;
            this.value = value;
            this.name = name;
        }
    }
}
