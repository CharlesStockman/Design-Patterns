package org.charlesStockman.designPatterns.creation.abstractFactory;

import org.junit.jupiter.api.Test;

/**
 * Test the Drink Class
 */
public class TestDrinkClass {

    /**
     * Test the happy path
     */
    @Test
    public void createDrinkClass() {
        Drink drink = new Drink("Pepsi");
        drink.consume();
    }

    /**
     * Test the path where a null is entered for the drinkName
     */
    @Test
    public void createDrinkClassWithNullName() {
        Drink drink = new Drink(null);
        drink.consume();
    }

    /**
     * Test the path where a empty stirng is entered for the drinkName
     */
    @Test
    public void createDrinkClassWithEmptyName() {
        Drink drink = new Drink("");
        drink.consume();
    }
}
