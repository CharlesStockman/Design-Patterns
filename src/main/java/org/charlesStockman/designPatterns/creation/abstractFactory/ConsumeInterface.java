package org.charlesStockman.designPatterns.creation.abstractFactory;

/**
 * An interface consume a liquid
 */
public interface ConsumeInterface {

    /**
     * Consumes the Liquid.
     *
     * @param drinkName -- Either the name of a drink or ( null or empty string which will converted to unknown )
     *
     */
    public default void consume(String drinkName ) {
        drinkName = ( drinkName == null || drinkName.isEmpty() ) ? "Unknown" : drinkName;
        System.out.println("Currently consuming " + drinkName);
    }
}
