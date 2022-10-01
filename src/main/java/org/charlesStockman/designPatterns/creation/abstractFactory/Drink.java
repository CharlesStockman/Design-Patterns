package org.charlesStockman.designPatterns.creation.abstractFactory;

import lombok.Data;

/**
 * Creates a drink that a human can consume
 */
@Data
public class Drink implements ConsumeInterface {

    // Name of the drink
    private String drinkName;

    /**
     * Create an instance of a Drink
     *
     * @param drinkName The drink name
     */
    public Drink(String drinkName) {
        this.drinkName = drinkName;
    }

    /**
     * Consume the drink
     */
    public void consume() {
        consume(drinkName);
    }
}
