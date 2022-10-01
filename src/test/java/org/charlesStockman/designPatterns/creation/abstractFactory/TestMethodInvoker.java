package org.charlesStockman.designPatterns.creation.abstractFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Supplier;

/**
 * The purpose is to create a class that allow the developer to provide a string to call a specific integer
 *
 * Test Driven Development -- Allow the time to think about how to create extra classes to avoid testing providing functions
 * Could be an example of Single Responsibility
 */
public class TestMethodInvoker {

    private MethodInvoker abstractFactory;

    @BeforeEach
    public void setup() {
        abstractFactory = new MethodInvoker();
    }

    /**
     * Verify that an empty map is returned when no parameters provided
     */
    @Test
    public void testMethodInvokerWith0Parameters() {
        Map<String, Supplier> result = abstractFactory.build();
        Assertions.assertTrue( result.size() == 0,
                String.format("The result should contain 0 values, but contains %d values", result.size()));
    }

    /**
     * Verify if fully qualified class is given then an IllegalArgumentException will be thrown
     */
    @Test
    public void testInvalidClassNameGiven() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> abstractFactory.build("chucks.invalid.instance.Instantiate"));
    }


}
