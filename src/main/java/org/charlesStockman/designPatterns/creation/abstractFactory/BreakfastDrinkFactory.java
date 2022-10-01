package org.charlesStockman.designPatterns.creation.abstractFactory;

public class BreakfastDrinkFactory {

    /**
     * Create a Coffee Drink
     */
    public Drink createCoffee() {
        return new Drink("coffee");
    }

    /**
     * Create a Tea Drink
     */
    public Drink createTea() {
        return new Drink("tea");
    }
}
