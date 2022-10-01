
package org.charlesStockman.designPatterns.creation.abstractFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBreakfastDrinkFactory {

    private BreakfastDrinkFactory sodaFactory;

    @BeforeEach
    public void setup() {
        sodaFactory = new BreakfastDrinkFactory();
    }

    /**
     * Create a Coke
     */
    @Test
    public void testCreateCoffee() {
        BreakfastDrinkFactory factory = new BreakfastDrinkFactory();
        Drink drink = factory.createCoffee();
        drink.consume();
    }

    /**
     * Create a Pepsi
     */
    @Test
    public void testCreateTea() {
        BreakfastDrinkFactory factory = new BreakfastDrinkFactory();
        Drink drink = factory.createTea();
        drink.consume();
    }
}