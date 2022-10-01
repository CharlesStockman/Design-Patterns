package org.charlesStockman.designPatterns.creation;

import lombok.Getter;
import org.charlesStockman.designPatterns.creation.other.RectangleInterface;
import org.charlesStockman.designPatterns.creation.other.Square;

/**
 * Convert a give square to a rectangle
 */
public class SquareToRectangleAdapter implements RectangleInterface {

    @Getter
    // The width of the rectangle
    private int width;

    @Getter
    // The height of the rectangle
    private int height;

    /**
     * Converts a square to a rectanlge
     *
     * @param square            The square that will be converted
     */
    public SquareToRectangleAdapter(Square square ) {
        this.width = square.getLengthOfSide();
        this.height = square.getLengthOfSide();
    }


}
