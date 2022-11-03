package com.gildedrose;

public class BackStageItem extends AggregateItem {
    public BackStageItem(Item item) {
        super(item);
    }

    @Override
    public void dailyUpdateQuality() {
        if (this.getItem().sellIn <= 0) {
            this.getItem().quality = 0;
        } else if (this.getItem().sellIn < 6) {
            super.itemUpdate(3, 0, 50);
        } else if (this.getItem().sellIn < 11) {
            super.itemUpdate(2, 0, 50);
        } else {
            super.itemUpdate(1, 0, 50);
        }
    }
}
