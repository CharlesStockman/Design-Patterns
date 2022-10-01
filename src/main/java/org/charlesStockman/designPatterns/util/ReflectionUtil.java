package org.charlesStockman.designPatterns.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.HashSet;

/** Better API Javadoc */
public class ReflectionUtil {

    /**
     * Instantiated a class by providing the fully qualified package name
     *
     * @param fullyQualifiedClassName A java class that can be instantiated
     *
     * @return An instance of fully qualified class name
     *
     * @exception ClassNotFoundException  The Class information could not be found.
     * @exception NoSuchMethodException   The constructor signature has not been found
     *
     */
    public static Object createInstanceFromName(String fullyQualifiedClassName) throws Exception {
        Class<?> tmpClass = Class.forName(fullyQualifiedClassName);
        try {
            Constructor<?> constructor = tmpClass.getConstructor();
            Object returnObject = constructor.newInstance();
            return returnObject;
        } catch ( Exception exception) {
            throw new Exception("Could not create an instance from qualified anme " + fullyQualifiedClassName);
        }
    }

    /**
     * A routine that will filter the public methods of a class based on a filter routine.
     *
     * @param parameterClass         The Metadata for the class being passed in.  If null an empty HashSet is returned.
     * @param methodFilter           The filter which decides what methods will be returned.
     *
     * @Exception IllegalArgumentException -- The filter can never be null since I cannot discern what is the default methods the developer wants returned
     *
     * @return The list of public function filtered by the filter
     */
    public static Set<Method> getPublicMethodsUsingFilter(Class<?> parameterClass, Predicate<Method> methodFilter) {

        HashSet<Method> methodSet = new HashSet<>();
        if ( parameterClass == null ) return methodSet;

        if ( methodFilter == null )  throw new IllegalArgumentException("The filter is null the cannot cannot determine the methods the developer wants returned");

        methodSet = Arrays.stream(parameterClass.getMethods()).filter(methodFilter).collect(Collectors.toCollection(HashSet<Method>::new));

        return methodSet;

    }

    /**
     * Executes a method reference
     *
     * Assumption       The method is inside the class
     *  @param instanceClass            String
     *  @param method                   The method to be executed
     *
     * @return
     */
    public static Object executeMethod(Class<?> instanceClass, Method method) throws NullPointerException, Exception {

        StringBuilder errorMessages = new StringBuilder("");

        if ( instanceClass == null ) errorMessages.append("The instanceClass cannot be null\n");
        if ( method == null ) errorMessages.append("The method cannot be null\n");
        if ( errorMessages.isEmpty() == false ) throw new NullPointerException(errorMessages.toString());

        try {
            Object result = method.invoke(createInstanceFromName(instanceClass.getName()), null);
            return result;
        } catch(Exception exception) {
            throw new Exception("A problem happen with Class Method, Member Function : invoke", exception );
        }
    }

    /**
     * Retrieve the methods that match the following names
     *
     * Assumptions there is no function overloading being used by the class.   Can be an empty list or return elements,
     * but can never be null
     *
     * @param  classInfo                The information for a specific class
     * @param  methodNames              Can contain 0 to many method names
     *
     * @return A <code>List</code> of <code>Methods</code> where each method is a  names in methodNames and found in the classInfo
     */
    public Set<Method> retrieveMethod( Class<?> classInfo, String... methodNames ) throws Exception  {

        StringBuilder messageBuilder = new StringBuilder();

        if ( classInfo == null ) {
            messageBuilder.append("The classInfo parameter is null\n");
        }

        if (methodNames == null) {
            messageBuilder.append("The methodsNames is null");
        }

        if ( messageBuilder.isEmpty() == false ) {
            throw new Exception("Error in retrieveMethod\n" + messageBuilder.toString());
        }

        java.util.Set<Method> methods = new HashSet<>();
        for ( String methodName : methodNames ) {
            Arrays.stream(classInfo.getMethods()).filter((Method method) -> {
                return method.getName().equals(methodName);
            }).collect(Collectors.toSet());
        };


        return methods;
    }
}
