package com.jammers;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles player offerings at shrines to gain favor with the gods.
 */
public class Sacrifices {

    private int favor;
    private final Map<String, Integer> sacrificedItemsCount;

    public Sacrifices() {
        this.favor = 0;
        this.sacrificedItemsCount = new HashMap<>();
    }

    /**
     * Sacrifice an item at the shrine to gain favor with the gods.
     *
     * @param itemName  Name or type of the item being sacrificed
     * @param itemValue Favor value gained from this item
     */
    public void sacrifice(String itemName, int itemValue) {
        if (itemValue > 0f) {
            favor += itemValue;
            sacrificedItemsCount.put(itemName, sacrificedItemsCount.getOrDefault(itemName, 0) + 1);
        }
    }

    public float getFavor() {
        return favor;
    }

    public Map<String, Integer> getSacrificedItemsCount() {
        return sacrificedItemsCount;
    }

    public void reset() {
        favor = 0;
        sacrificedItemsCount.clear();
    }
}
