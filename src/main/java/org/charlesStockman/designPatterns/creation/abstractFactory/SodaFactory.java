package org.charlesStockman.designPatterns.creation.abstractFactory;

/**
 * A factory to crete different types of soda
 */
public class SodaFactory {

    /**
     * Create a Pepsi Soda
     */
    public Drink createPepsi() {
        return new Drink("Pepsi");
    }

    /**
     * Create a Coke Soda
     */
    public Drink createCoke() {
        return new Drink("coke");
    }
}
