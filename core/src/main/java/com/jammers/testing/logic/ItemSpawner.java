package com.jammers.testing.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
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
        itemDataStack.add(new ItemData(assets.getAxe(), randomValue(), "AN AXE"));
        itemDataStack.add(new ItemData(assets.getBook(), randomValue(), "A BOOK"));
        itemDataStack.add(new ItemData(assets.getBread(), randomValue(), "BREAD"));
        itemDataStack.add(new ItemData(assets.getCandle(), randomValue(), "A CANDLE"));
        itemDataStack.add(new ItemData(assets.getChalice(), randomValue(), "A CHALICE"));
        itemDataStack.add(new ItemData(assets.getComedy(), randomValue(), "COMEDY"));
        itemDataStack.add(new ItemData(assets.getCrown(), randomValue(), "A CROWN"));
        itemDataStack.add(new ItemData(assets.getDice(), randomValue(), "A DICE"));
        itemDataStack.add(new ItemData(assets.getFeather(), randomValue(), "A FEATHER"));
        itemDataStack.add(new ItemData(assets.getFork(), randomValue(), "A FORK"));
        itemDataStack.add(new ItemData(assets.getGem(), randomValue(), "A GEM"));
        itemDataStack.add(new ItemData(assets.getGrapes(), randomValue(), "GRAPES"));
        itemDataStack.add(new ItemData(assets.getJewel(), randomValue(), "A JEWEL"));
        itemDataStack.add(new ItemData(assets.getJug(), randomValue(), "A JUG"));
        itemDataStack.add(new ItemData(assets.getKnife(), randomValue(), "A KNIFE"));
        itemDataStack.add(new ItemData(assets.getLyre(), randomValue(), "A LYRE"));
        itemDataStack.add(new ItemData(assets.getMace(), randomValue(), "A MACE"));
        itemDataStack.add(new ItemData(assets.getNecklace(), randomValue(), "A NECKLACE"));
        itemDataStack.add(new ItemData(assets.getPaper(), randomValue(), "A PAPER"));
        itemDataStack.add(new ItemData(assets.getPear(), randomValue(), "A PEAR"));
        itemDataStack.add(new ItemData(assets.getPotion(), randomValue(), "A POTION"));
        itemDataStack.add(new ItemData(assets.getScales(), randomValue(), "SCALES"));
        itemDataStack.add(new ItemData(assets.getScroll(), randomValue(), "A SCROLL"));
        itemDataStack.add(new ItemData(assets.getSpanner(), randomValue(), "A SPANNER"));
        itemDataStack.add(new ItemData(assets.getSpoon(), randomValue(), "A SPOON"));
        itemDataStack.add(new ItemData(assets.getSword(), randomValue(), "A SWORD"));
        itemDataStack.add(new ItemData(assets.getTeapot(), randomValue(), "A TEAPOT"));
        itemDataStack.add(new ItemData(assets.getTragedy(), randomValue(), "TRAGEDY"));
        itemDataStack.add(new ItemData(assets.getVial(), randomValue(), "A VIAL"));
        itemDataStack.add(new ItemData(assets.getWine(), randomValue(), "WINE"));
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

    private int randomValue() {
        return MathUtils.random(-20, 40);
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
