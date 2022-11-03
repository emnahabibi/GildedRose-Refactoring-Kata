package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    /**
     * Aged Brie item is never more than 50
     */
    @Test
    void agedBriePassesQualityShouldNotBeMoreThan50() {
        Item item = new Item("Aged Brie", 8, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo("Aged Brie");
        assertThat(item.quality).isEqualTo(50);
        assertThat(item.sellIn).isEqualTo(7);
    }


    /**
     * Backstage quality increases by 2 when there are 10 days or less
     */
    @Test
    void backstageQualityIncreases2TimesIn10Days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 30);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        assertThat(item.quality).isEqualTo(32);
        assertThat(item.sellIn).isEqualTo(7);
    }

    /**
     * Backstage quality increases by 3 when there are 5 days
     */
    @Test
    void backStagePassesQualityIncreases3TimesIn5Days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(5);
    }

    /**
     * Backstage item quality is 0 after concert
     */
    @Test
    void backstagePassesQualityIs0AfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item.quality).isZero();
    }

    /**
     * Sulfuras is a legendary item increases when Sell in is off
     */
    @Test
    void sulfurasPassesQualityIncreases0WhenSellInOff() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -5, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo("Sulfuras, Hand of Ragnaros");
        assertThat(item.sellIn).isEqualTo(-5);
    }

    /**
     * Sulfuras is a legendary item quality is 80 and it never alter
     */
    @Test
    void sulfurasItemsNeverDecreaseInQuality() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        GildedRose subject = new GildedRose(new Item[]{item});

        subject.updateQuality();

        assertThat(item.quality).isEqualTo(80);
    }
}
