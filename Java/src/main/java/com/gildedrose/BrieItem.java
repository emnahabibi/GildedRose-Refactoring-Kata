package com.gildedrose;

public class BrieItem extends AggregateItem {
    public BrieItem(Item item) {
        super(item);
    }

    @Override
    public void dailyUpdateQuality() {
        super.itemUpdate(1, 0, 50);
    }
}
