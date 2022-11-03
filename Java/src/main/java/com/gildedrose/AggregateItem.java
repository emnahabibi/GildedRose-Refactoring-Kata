package com.gildedrose;

public class AggregateItem implements AggregateItemInterface {

    private Item item;

    public Item getItem() {
        return item;
    }

    public AggregateItem(Item item) {
        this.item = item;
    }

    public static AggregateItem generateNewItemFromItem(Item item) {
        if (ItemTypesConst.BRIE.equals(item.name)) {
            return new BrieItem(item);
        }
        if (ItemTypesConst.SULFURAS.equals(item.name)) {
            return new SulfurasItem(item);
        }
        if (ItemTypesConst.BACKSTAGE.equals(item.name)) {
            return new BackStageItem(item);
        }
        return new AggregateItem(item);
    }

    @Override
    public void dailyUpdateQuality() {
        if (itemExpired()) {
            itemUpdate(-2, 0, 50);
        } else {
            itemUpdate(-1, 0, 50);
        }
    }


    @Override
    public void itemUpdate(int coef, int minQuality, int maxQuality) {
        itemUpdate(coef, minQuality, maxQuality, false);
    }

    /**
     *
     * @param coef
     * @param minQuality
     * @param maxQuality
     * @param isLegendary
     */
    @Override
    public void itemUpdate(int coef, int minQuality, int maxQuality, boolean isLegendary) {
        updateQuality(coef, minQuality, maxQuality);
        if (!isLegendary) {
            --this.getItem().sellIn;
        }

    }

    private boolean itemExpired() {
        return this.getItem().sellIn < 0;
    }

    /**
     * Refactoring updateQuality to increment and decrement quality based on minQuality and maxQuality
     *
     * @param coef
     * @param minQuality
     * @param maxQuality
     */
    private void updateQuality(int coef, int minQuality, int maxQuality) {
        if (item.quality + coef < minQuality) {//do not exceed the min value
            item.quality = minQuality;
        } else if (item.quality + coef > maxQuality) {//do not exceed the max value
            item.quality = maxQuality;
        } else if (item.quality > minQuality && item.quality < maxQuality) {
            item.quality = item.quality + coef;
        }
    }

}
