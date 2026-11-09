package com.jammers.testing.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.jammers.testing.Assets;
import com.jammers.testing.stuff.Item;
import com.jammers.testing.stuff.RoomData;
import com.jammers.testing.stuff.RoomEnum;
import com.jammers.testing.stuff.Stuff;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Stack;

public class ItemSpawner {

    private final Stack<ItemData> itemDataStack;

    public ItemSpawner(Assets assets, Stuff stuff) {
        itemDataStack = new Stack<>();
        populateItemData(assets);
        spawnItems(assets, stuff.getRoomDataMap());
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

    private void spawnItems(Assets assets, EnumMap<RoomEnum, RoomData> roomDataMap) {
        DelayedRemovalArray<Item> kitchenItems = roomDataMap.get(RoomEnum.KITCHEN).getItems();
        kitchenItems.add(new Item(assets.getAxe(), 140, 300, randomValue(), "AN AXE"));
        kitchenItems.add(new Item(assets.getBook(), 140, 110, randomValue(), "A BOOK"));
        kitchenItems.add(new Item(assets.getBread(), 205, 175, randomValue(), "BREAD"));
        kitchenItems.add(new Item(assets.getCandle(), 270, 80, randomValue(), "A CANDLE"));
        kitchenItems.add(new Item(assets.getChalice(), 310, 335, randomValue(), "A CHALICE"));
        kitchenItems.add(new Item(assets.getComedy(), 340, 207, randomValue(), "COMEDY"));

        DelayedRemovalArray<Item> messHallItems = roomDataMap.get(RoomEnum.MESS_HALL).getItems();
        messHallItems.add(new Item(assets.getAxe(), 115, 337, randomValue(), "AN AXE"));
        messHallItems.add(new Item(assets.getBook(), 114, 182, randomValue(), "A BOOK"));
        messHallItems.add(new Item(assets.getBread(), 146, 87, randomValue(), "BREAD"));
        messHallItems.add(new Item(assets.getCandle(), 205, 337, randomValue(), "A CANDLE"));
        messHallItems.add(new Item(assets.getChalice(), 240, 242, randomValue(), "A CHALICE"));
        messHallItems.add(new Item(assets.getComedy(), 309, 337, randomValue(), "COMEDY"));
        messHallItems.add(new Item(assets.getCrown(), 330, 210, randomValue(), "A CROWN"));

        DelayedRemovalArray<Item> hallwayItems = roomDataMap.get(RoomEnum.HALLWAY).getItems();
        hallwayItems.add(new Item(assets.getAxe(), 78, 270, randomValue(), "AN AXE"));
        hallwayItems.add(new Item(assets.getBook(), 78, 212, randomValue(), "A BOOK"));
        hallwayItems.add(new Item(assets.getBread(), 183, 212, randomValue(), "BREAD"));
        hallwayItems.add(new Item(assets.getCandle(), 212, 270, randomValue(), "A CANDLE"));
        hallwayItems.add(new Item(assets.getChalice(), 312, 212, randomValue(), "A CHALICE"));
        hallwayItems.add(new Item(assets.getComedy(), 341, 270, randomValue(), "COMEDY"));

        DelayedRemovalArray<Item> libraryItems = roomDataMap.get(RoomEnum.LIBRARY).getItems();
        libraryItems.add(new Item(assets.getFeather(), 110, 243, randomValue(), "A FEATHER"));
        libraryItems.add(new Item(assets.getBook(), 270, 339, randomValue(), "A BOOK"));
        libraryItems.add(new Item(assets.getBread(), 270, 212, randomValue(), "BREAD"));
        libraryItems.add(new Item(assets.getDice(), 270, 108, randomValue(), "A DICE"));
        libraryItems.add(new Item(assets.getChalice(), 335, 240, randomValue(), "A CHALICE"));
        libraryItems.add(new Item(assets.getComedy(), 335, 143, randomValue(), "COMEDY"));

        DelayedRemovalArray<Item> churchItems = roomDataMap.get(RoomEnum.CHURCH).getItems();
        churchItems.add(new Item(assets.getGem(), 140, 337, randomValue(), "A GEM"));
        churchItems.add(new Item(assets.getBook(), 140, 108, randomValue(), "A BOOK"));
        churchItems.add(new Item(assets.getBread(), 177, 173, randomValue(), "BREAD"));
        churchItems.add(new Item(assets.getDice(), 305, 170, randomValue(), "A DICE"));
        churchItems.add(new Item(assets.getGrapes(), 305, 110, randomValue(), "GRAPES"));
        churchItems.add(new Item(assets.getComedy(), 337, 337, randomValue(), "COMEDY"));

        DelayedRemovalArray<Item> outsideItems = roomDataMap.get(RoomEnum.OUTSIDE).getItems();
        outsideItems.add(new Item(assets.getJewel(), 78, 270, randomValue(), "A JEWEL"));
        outsideItems.add(new Item(assets.getBook(), 135, 145, randomValue(), "A BOOK"));
        outsideItems.add(new Item(assets.getBread(), 280, 178, randomValue(), "BREAD"));
        outsideItems.add(new Item(assets.getDice(), 345, 270, randomValue(), "A DICE"));

        DelayedRemovalArray<Item> gardenItems = roomDataMap.get(RoomEnum.GARDEN).getItems();
        gardenItems.add(new Item(assets.getJewel(), 140, 275, randomValue(), "A JEWEL"));
        gardenItems.add(new Item(assets.getJug(), 165, 135, randomValue(), "A JUG"));
        gardenItems.add(new Item(assets.getKnife(), 205, 335, randomValue(), "A KNIFE"));
        gardenItems.add(new Item(assets.getLyre(), 298, 135, randomValue(), "A LYRE"));
        gardenItems.add(new Item(assets.getMace(), 338, 310, randomValue(), "A MACE"));

        DelayedRemovalArray<Item> grassItems = roomDataMap.get(RoomEnum.GRASS).getItems();
        grassItems.add(new Item(assets.getNecklace(), 135, 300, randomValue(), "A NECKLACE"));
        grassItems.add(new Item(assets.getPaper(), 170, 143, randomValue(), "A PAPER"));
        grassItems.add(new Item(assets.getPear(), 275, 215, randomValue(), "A PEAR"));
        grassItems.add(new Item(assets.getPotion(), 307, 300, randomValue(), "A POTION"));
    }

    private int randomValue() {
        return MathUtils.random(-20, 40);
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
