package org.charlesStockman.designPatterns.creation.other;

import lombok.Getter;

/**
 * Create a Rectangle that will describe an interface
 */
public interface RectangleInterface {

    public int getWidth();

    public int getHeight();

    default public int getArea() {
        return getWidth() * getHeight();
    }


}
