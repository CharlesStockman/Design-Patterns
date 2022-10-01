package org.charlesStockman.designPatterns.creation.abstractFactory;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test the Consume Interface
 */
public class TestConsumeInterface {

    private static class TestConsume implements ConsumeInterface {};
    private  TestConsume testConsume;

    // How much liquid do you start with
    private static final int AMOUNT_LIQUID = 25;

    /**
     * Sets the initial condition for most of the test
     */
    @BeforeEach
    public void beforeEach() {
        System.out.println("Calling ");
        testConsume = new TestConsume();
    }

    /**
     * Test a null String which should be changed to unknown created
     */
    @Test
    public void intializeConsumeWithNegativeAmount() {
        testConsume.consume(null);
    }

    /**
     * Test an empty String which should be changed to unknown in the string created
     */
    @Test
    public void consumeHappyPath() {
        testConsume.consume("");
    }

    /**
     * Test that the provided string name is printed out
     */
    @Test
    public void consumeAllTheLiquidAndMore() {
        testConsume.consume("Pepsi");
    }
}
