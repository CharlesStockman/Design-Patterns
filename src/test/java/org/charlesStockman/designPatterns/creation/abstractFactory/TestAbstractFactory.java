//package org.charlesStockman.designPatterns.creation.abstractFactory;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.lang.reflect.Method;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//import java.util.function.Supplier;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
///**
// *
// * At the beignning or learning a new set of code it will be alot of write the fucntion and the code
// */
//@Test
//public class TestAbstractFactory {
//
//    private AbstractFactory abstractFactory = new AbstractFactory();
//
//    private Map<String, Supplier<Drink>> data;
//
//    @BeforeEach
//    public void setup()  {
//        abstractFactory = new AbstractFactory();
//
//
//        Method getFactory = abstractFactory.getClass().getMethod("getFactory", null);
//        getFactory.setAccessible(true);
//    }
//
//    /**
//     * Test the private getFactory() -- Which the data structure containinbg all the data functions
//     */
//    public void testPrivateGetterFactory() {
//        Map<String, Supplier<Drink>> drinkFactory = data.getFactory();
//        assertTrue(factory.size() == 0, "The factory at this point should since lazy initialization is being used");
//
//        Assertions.assertThrows(UnsupportedOperationException.class, () -> data.put("coke", new CokeSupplier()));
//        Assertions.assertThrows(UnsupportedOperationException.class, () -> data.put("test", new PepsiSupplier()));
//
//        Set<Supplier<Drink>> drinks = new HashSet<>();
//        drinks.add(new CokeSupplier());
//        drinks.add(new PepsiSupplier());
//
//        Map<String, Supplier<Drink>> answerDrinkFactory = getFactory.invoke(data);
//
//        Assertions.assertSame( drinks, answerDrinkFactory );
//    }
//
//    /**
//     * This function will verify that if a null class is the abstract factory will work be empty dataStructure
//     */
//    @Test
//    public void testWhenCreationParametersIsNull () {
//
//        Assertions.abstractFactory.put(NullPointerException.class,
//                () -> data.addFactory(null),
//                "Since the parameter was null the function should have a null exception ");
//
//        Map<String, Supplier<Drink>> answerDrinkFactory = getFactory.invoke(data);
//        assertTrue(answerDrinkFactory.isEmpty() == true, "Since a null provider was provided an empty Map should have been returned ");
//    }
//
//    /**
//     * This function will verify that a class that has no factory function will return a empty data structure
//     */
//    @Test
//    public void testWhenCreationParameterHasNoFactoryFunctions() {
//        data.add(String.class);
//
//        Map<String, Supplier<Drink>> answerDrinkFactory = getFactory.invoke(data);
//        assertTrue( data.getFactory().length == 0,
//            "Since no factory methods were part of the input the data structure should be empty.");
//    }
//
//    /**
//     * This function will verify that a class has factory function will return an initialized dataSsrucutre
//     */
//    @Test
//    public void testWhenCreationParameterFactoryFunctions() {
//        data.add(SodaFactory);
//        Map<String, Supplier> result = data.getFactory();
//
//        Set<Supplier<Drink>> drinks = new HashSet<>();
//        drinks.add(new CokeSupplier());
//        drinks.add(new PepsiSupplier());
//
//        Map<String, Supplier<Drink>> answerDrinkFactory = getFactory.invoke(data);
//
//        Assertions.assertSame( drinks, answerDrinkFactory );
//    }
//
//    /**
//     * This function will verify that a class has factory function will return an initialized data structure
//     */
//    @Test
//    public void testWhenCreationParameterFactory() {
//        data.add(new SodaFactory());
//        Map<String, Supplier> result = data.getFactory();
//
//        Set<Supplier<Drink>> drinks = new HashSet<>();
//        drinks.add(new CokeSupplier());
//        drinks.add(new PepsiSupplier());
//
//        Map<String, Supplier<Drink>> answerDrinkFactory = getFactory.invoke(data);
//
//        Assertions.assertSame( drinks, answerDrinkFactory );
//    }
//
//    /**
//     * This function will verify that a class has factory function will return an initialized data strucutre
//     */
//    @Test
//    public void testWhenCreationParameterMultipleFactory() {
//        data.add(new SodaFactory(), new BreakfastDrinkFactory());
//        Map<String, Supplier> result = data.getFactory();
//
//        Set<Supplier<Drink>> drinks = new HashSet<>();
//        drinks.add(new CokeSupplier());
//        drinks.add(new PepsiSupplier());
//        drinks.add(new CoffeeSupplier());
//        drinks.add(new TeaSuppier());
//
//        Map<String, Supplier<Drink>> answerDrinkFactory = getFactory.invoke(data);
//
//        Assertions.assertSame( drinks, answerDrinkFactory );
//
//    }
//
//    /**
//     * Create instance to be used to verify the expected result
//     */
//    private class CokeSupplier implements Supplier<Drink> {
//        public Drink get() {
//            SodaFactory factory = new SodaFactory();
//            return (Drink)factory.createCoke();
//        }
//    }
//
//    /**
//     * Create instance to be used to verify the expected result
//     */
//    private class PepsiSupplier implements Supplier<Drink> {
//        public Drink get() {
//            SodaFactory factory = new SodaFactory();
//            return factory.createPepsi();
//        }
//    }
//
//    /**
//     * Create instance to be used to verify the expected result
//     */
//    private class CoffeeSupplier implements Supplier<Drink> {
//        public Drink get() {
//            BreakfastDrinkFactory factory = new BreakfastDrinkFactory();
//            return factory.createCoffee();
//        }
//    }
//
//    /**
//     * Create instance to be used to verify the expected result
//     */
//    private class TeaSupplier implements Supplier<Drink> {
//            public Drink get() {
//                BreakfastDrinkFactory factory = new BreakfastDrinkFactory();
//                return factory.createTea();
//            }
//        }
//    }
