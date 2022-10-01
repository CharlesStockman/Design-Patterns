package org.charlesStockman.designPatterns.creation.abstractFactory;

import lombok.Data;
import org.charlesStockman.designPatterns.util.ReflectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Purpose : A class that collects method functions ( using a filter ) and allow the developer to execute them by
 * providing a string
 */
@Data
public class MethodInvoker {

    private Map<String, Supplier> factoryFunctions = new HashMap<>();

    /**
     * Extract out the functions that will create the objects
     *
     * @param  abstractFactoryNames One or more class that contains functions to build abstract factories
     *
     * @return                          A map of functions that can create an instance
     */
    public Map build(String... abstractFactoryNames) {

        for ( String abstractFactoryName : abstractFactoryNames ) {

            // Get the class template from the fully qualified class name
            try {
                Object object = ReflectionUtil.createInstanceFromName(abstractFactoryName);
                Set<Method> methods =  ReflectionUtil.getPublicMethodsUsingFilter(null, null);
            } catch (Exception e) {
                throw new IllegalArgumentException("Could not create an instance of " + abstractFactoryName, e);
            }

            // Instantiate an object
        }
        return factoryFunctions;
    }


}
