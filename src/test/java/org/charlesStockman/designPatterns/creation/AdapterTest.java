package org.charlesStockman.designPatterns.creation;

import org.charlesStockman.designPatterns.creation.other.RectangleInterface;
import org.charlesStockman.designPatterns.creation.other.Square;
import org.charlesStockman.designPatterns.creation.other.SquareToRectangleAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

public class AdapterTest {

    /**
     * Test written to verify that a square can be create
     *
     * @return A <code>Square.java</code> used as input to the Adapter
     */
    @Test
    @Order(1)
    public void testCreateSquare() {
        Square square = new Square(5);
        Assertions.assertEquals(5, square.getLengthOfSide());
    }

    /**
     * Test that a Rectangle can be created from a Square.java
     */
    @Test
    @Order(2)
    public void testAdaptSquare() {

        // Create a square
        int lengthOfSquareSide = 5;
        Square square = new Square(lengthOfSquareSide);

        // Convert the square into a rectangle
        RectangleInterface rectangle = new SquareToRectangleAdapter(square);

        // Verify that the Rectangle has the same properties as the square
        Assertions.assertEquals(5,rectangle.getWidth());
        Assertions.assertEquals(5,rectangle.getHeight());
        Assertions.assertEquals(25, rectangle.getArea());
    }


}
