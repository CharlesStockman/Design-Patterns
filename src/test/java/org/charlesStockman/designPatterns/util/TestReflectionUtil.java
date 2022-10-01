package org.charlesStockman.designPatterns.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Provide tools to make it easier to use Java Reflection
 *
 * With Test Driven sometime you will need to go back and rewrite the code.
 * One note you need to plan the internals since they may throw execptions that you are not expecting.
 * Errors do not need to test other developers
 */
public class TestReflectionUtil {

    ReflectionUtil util;

    @BeforeEach
    public void setup() {
        util = new ReflectionUtil();
    }

    /**
     * Verify when there is a invalid class name and exception is thrown.
     */
    @Test
    public void testInvalidClassNameGiven() {
        Assertions.assertThrows(Exception.class,
                () -> util.createInstanceFromName("chucks.invalid.instance.Instantiate"));
    }

    /**
     * Verify when a valid class is provided then the instance can be created.
     */
    @Test
    public void testInstantiation() throws Exception {
        String testData = "org.charlesStockman.designPatterns.creation.abstractFactory.BreakfastDrinkFactory";
        Object newInstance = util.createInstanceFromName(testData);
        Assertions.assertTrue( newInstance.getClass().getName() == testData);
    }

    /**
     * Verify the happy path for getPublicMethods for one Factory
     */
    @Test
    public void testGetPublicMethodsWhereFilterHappyPath() throws Exception {

        // Create the object that contains the methods
        String testData = "org.charlesStockman.designPatterns.creation.abstractFactory.BreakfastDrinkFactory";
        Class<?> objectToGetMethods = Class.forName(testData);

        Set<Method> answerMethods = new HashSet<Method>();
        answerMethods.add(objectToGetMethods.getMethod("createCoffee", null));
        answerMethods.add(objectToGetMethods.getMethod("createTea", null));

        Predicate<Method> filterFunction = ( Method method ) -> {  return (method.getReturnType().getSimpleName().equals("Drink")) ? true : false; };
        Set<Method> methods =  util.getPublicMethodsUsingFilter(objectToGetMethods, filterFunction);
        Assertions.assertEquals(methods, answerMethods);

    }

    /**
     * Verify when the filter is null that a default filter is created and all the pubic functions are returned
     */
    @Test
    public void testGetPublicMethodsWhereFilterIsNull() throws Exception {

        // Create the object that contians the methods
        String testData = "org.charlesStockman.designPatterns.creation.abstractFactory.BreakfastDrinkFactory";
        Class<?> objectToGetMethods = Class.forName(testData);

        Set<Method> answerMethods = new HashSet<Method>();
        answerMethods.add(objectToGetMethods.getMethod("createCoffee", null));
        answerMethods.add(objectToGetMethods.getMethod("createTea", null));

        Assertions.assertThrows( IllegalArgumentException.class, () -> util.getPublicMethodsUsingFilter(objectToGetMethods, null));

    }

    /**
     * Verify an empty set is returned when the instance of the class passed in is null
     */
    @Test
    public void testGetPublicMethodsWhereObjectIsNull() throws Exception {

        // Create the object that contians the methods
        String testData = "org.charlesStockman.designPatterns.creation.abstractFactory.BreakfastDrinkFactory";
        Object objectToGetMethods = null;

        Set<Method> answerMethods = new HashSet<Method>();

        Set<Method> methods =  util.getPublicMethodsUsingFilter(null, null);
        Assertions.assertTrue(methods.size() == 0, "The set returned contains element and should be empty");
    }


    /**
     * Test the happy path for the execution of the method.
     */
    @Test
    public void TestExecuteMethodHappyPath() throws NullPointerException, Exception {

        // Create the object that contains the methods
        String testData = "org.charlesStockman.designPatterns.creation.abstractFactory.BreakfastDrinkFactory";
        Class<?> objectToGetMethods = Class.forName(testData);

        // Select a method
        Method method = objectToGetMethods.getMethod("createTea", null);

        // Invoke the Method
        Object object = ReflectionUtil.executeMethod(objectToGetMethods, method);

        System.out.println("The Object is an instance of " + object.getClass().getSimpleName());
        Assertions.assertEquals("Drink", object.getClass().getSimpleName());

    }

    /**
     * Test the unhappy path where errors or thrown for each null parameter
     */
    @Test
    public void TestExecuteMethodFailParameters() throws NullPointerException, Exception {

        // Invoke the Method
        Assertions.assertThrows(NullPointerException.class, () -> ReflectionUtil.executeMethod(null, null));

        try {
            ReflectionUtil.executeMethod(null, null);
        } catch( NullPointerException exception) {
            long lineCount = Arrays.stream(exception.getMessage().split("\n")).sequential().count();
            Assertions.assertTrue( lineCount == 2, "The number of lines should be two since 2 errors were encountered.");
        }
    }

    /**
     * Test the unhappy path for the execution of the method when the invoked method throws an exception
     */
    @Test
    public void TestExecuteMethodFailInvokeFunction() throws NullPointerException, Exception {

        // Create the object that contains the methods
        String testData = "org.charlesStockman.designPatterns.creation.abstractFactory.BreakfastDrinkFactory";
        Class<?> objectToGetMethods = Class.forName(testData);

        String testData2 = "org.charlesStockman.designPatterns.creation.abstractFactory.SodaFactory";
        Class<?> anotherToGetMethods = Class.forName(testData2);

        // Select a method
        Method method = objectToGetMethods.getMethod("createTea", null);

        // Invoke the Method
        try {
            Object object = ReflectionUtil.executeMethod(anotherToGetMethods, method);
        } catch (NullPointerException nullException) {
            Assertions.fail("A NullPointer Exception should have been thrown here since the parameters were not null");
        } catch (Exception exception ) {
            System.out.println(exception.getCause());
            Assertions.assertTrue( exception.getCause() != null , "An exception was thrown, but doesn't contain the cause of the exception");
            return;
        }

        Assertions.fail("No Exception was thrown or the cause was not stored in the exception");

    }

    /**
     * Test the unhappy path for retrieveMethodFromClass where both parameters are null ( input parameters is incorrect )
     */
    @Test
    public void testRetrieveMethodsWhereInputsAreNull() {

        ReflectionUtil util = new ReflectionUtil();

        try {
            util.retrieveMethod(null, null);
        } catch(Exception exception) {
            int lineCount = exception.getMessage().split("\n").length;
            Assertions.assertTrue( lineCount == 3, "With both parameters being null two errors must be returned on spearate lines");
            return;
        }

        Assertions.fail("The executable shouldhave thrown an error for null parameters, but did nto");
    }

    /**
     * Test the happy path where the return value is an empty list since the input method name does not match any of the functions in the <code>Class</code> Object
     */
    @Test
    public void testRetrieveMethodsWhereOutputIsEmptyMethodList() throws Exception{
        ReflectionUtil util = new ReflectionUtil();

        String testData = "org.charlesStockman.designPatterns.creation.abstractFactory.BreakfastDrinkFactory";
        Set<Method> methods = null;
        try {
            methods = util.retrieveMethod(Class.forName(testData), "length");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Assertions.assertTrue( methods.size() == 0, "Since not functions were matched the list should have been empty, but contained "+ methods.toString() );
    }

    /**
     * Test the happy path where the return value is a list that contains one value since the method name was matched.
     */
    @Test
    public void testRetrieveMethodWhereOutputContainOneValue() throws ClassNotFoundException, Exception {
        String methodName = "createCoffee";
        ReflectionUtil util = new ReflectionUtil();

        String testData = "org.charlesStockman.designPatterns.creation.abstractFactory.BreakfastDrinkFactory";
        Set<Method> methods = util.retrieveMethod(Class.forName(testData), methodName);
        Assertions.assertTrue( methods.size() == 1, "ONe element should have found the number of elements "+ methods.toString() );
        Assertions.assertTrue(methods.stream().filter( (Method method ) -> { return method.getName().matches(methodName); }).count() == 1, "The Method instance did not contain the name " + methodName);
    }

    /**
     * Test the happy path where the return value is a list that contains two values since both names were matched.
     *
     * Assumption : Each function is unique and no functions are overloaded.
     */
    @Test
    public void testRetrieveMethodWhereOutputContainMultipleValues() throws ClassNotFoundException, Exception {
        String methodName1 = "createCoffee";
        String methodName2 = "createTea";
        String testData = "org.charlesStockman.designPatterns.creation.abstractFactory.BreakfastDrinkFactory";

        String answer = "methodName1" + ":" + methodName2;
        ReflectionUtil util = new ReflectionUtil();

        Predicate<Method> filterExpr = (Method method) -> method.getName().matches(methodName1) || method.getName().matches(methodName2);

        Set<Method> methods = util.retrieveMethod(Class.forName(testData), methodName1, methodName2);
        Assertions.assertTrue( methods.size() == 2, "Since not functions were matched the list should have been empty, but contained "+ methods.toString() );
        Assertions.assertTrue( methods.stream().filter(filterExpr).count() == 2);
    }

}
