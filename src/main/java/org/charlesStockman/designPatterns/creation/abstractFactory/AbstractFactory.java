package org.charlesStockman.designPatterns.creation.abstractFactory;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Implement the AbstractFactory Design Pattern
 *
 * <ol></ol>There are two abstract facotries
 * <li>Add creation factories from many different factory that create thge same type</li>
 * <li>Return a set of instances.  For example for a them return an Font, Desktop background, icons </li>
 * </ol>
 *
 * We will be implementing the first item.
 */
public class AbstractFactory {

    /**
     * Returns an instance of Unmodifiable <code>HashMap</code.  If the <code>Map Interface</code> has not been created
     * then create it ( lazy creation)
     */
    //private Map<String, Supplier<Drink>> getFactory() {

    //}

    /**
     * Add the create functions from a specific factory
     *
     * @param instanceContainingClassFunctions           The instance containing the creation functions
     * @param returnType                                 The type the creation functions will return
     *
     * @freturn An Unmodifiable <code>Map</code>
     *
     */
    //public addFactory( )
}
