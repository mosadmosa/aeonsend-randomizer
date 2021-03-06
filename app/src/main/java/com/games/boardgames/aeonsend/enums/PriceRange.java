package com.games.boardgames.aeonsend.enums;

/**
 * Created by honza on 14.9.17.
 */

public enum PriceRange {
    ANY(0, 9, "ANY"),
    TWO(2, 2, "2"),
    THREE(3, 3, "3"),
    FOUR(4, 4, "4"),
    FIVE(5, 5, "5"),
    SIX(6, 6, "6"),
    SEVEN(7, 7, "7"),
    EIGHT(8, 8, "8"),
    NULL(0, 0, "0"),
    LESSTHANFOUR(0, 3, "<4"),
    LESSTHANFIVE(0, 4, "<5"),
    LESSTHANSIX(0, 5, "<6"),
    MORETHANTHREE(4, 9, ">3"),
    MORETHANFOUR(5, 9, ">4"),
    MORETHANFIVE(6, 9, ">5"),
    MORETHANSIX(7, 9, ">6"),
    THREEORFOUR(3, 4, "3/4"),
    FOURORFIVE(4, 5, "4/5"),
    FIVEORSIX(5, 6, "5/6");

    private int minPrice;
    private int maxPrice;
    private String name;

    PriceRange(int minPrice, int maxPrice, String name) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.name = name;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public String toString() {
        return name;
    }

    private static final PriceRange[] copyOfValues = values();

    public static PriceRange fromString(String name) {
        for (PriceRange priceRange : copyOfValues) {
            if (priceRange.name.equalsIgnoreCase(name)) {
                return priceRange;
            }
        }
        return null;
    }

}
