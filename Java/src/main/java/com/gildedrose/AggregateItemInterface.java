package com.gildedrose;

public interface AggregateItemInterface {
    /**
     * Update quality for normal cases
     */
    void dailyUpdateQuality();

    /**
     * Update item base on specific cases
     *
     * @param coef
     * @param minQuality
     * @param maxQuality
     */
    void itemUpdate(int coef, int minQuality, int maxQuality);

    void itemUpdate(int coef, int minQuality, int maxQuality, boolean isLegendary);
}
