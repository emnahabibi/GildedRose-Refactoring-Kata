package com.gildedrose;

public class ConjuredItem extends AggregateItem {
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void dailyUpdateQuality() {
        super.itemUpdate(-2,0,50);
    }
}
