package org.charlesStockman.designPatterns.creation.other;

import lombok.Getter;

/**
 * Create a class that models a Square
 */
public class Square {

    @Getter
    private int lengthOfSide;

    /**
     * Creates an instance of Square
     *
     * @param lengthOfSide -- The length of one of square.  Note each side of a square is equal
     */
    public Square(int lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }
}