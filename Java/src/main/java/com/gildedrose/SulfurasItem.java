package com.gildedrose;

public class SulfurasItem extends AggregateItem {
    public SulfurasItem(Item item) {
        super(item);
    }

    @Override
    public void dailyUpdateQuality() {
        super.itemUpdate(0, 80, 80, true);
    }
}
