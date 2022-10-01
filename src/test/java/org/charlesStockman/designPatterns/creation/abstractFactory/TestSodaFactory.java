package org.charlesStockman.designPatterns.creation.abstractFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSodaFactory {

    private SodaFactory sodaFactory;

    @BeforeEach
    public void setup() {
        sodaFactory = new SodaFactory();
    }

    /**
     * Create a Coke
     */
    @Test
    public void testCreatePepsi() {
        SodaFactory factory = new SodaFactory();
        Drink drink = factory.createPepsi();
        drink.consume();
    }

    /**
     * Create a Pepsi
     */
    @Test
    public void testCreateCoke() {
        SodaFactory factory = new SodaFactory();
        Drink drink = factory.createCoke();
        drink.consume();
    }
}
