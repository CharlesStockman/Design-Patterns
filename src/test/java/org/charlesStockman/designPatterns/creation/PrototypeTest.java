package org.charlesStockman.designPatterns.creation;

import org.charlesStockman.designPatterns.creation.other.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrototypeTest {

    /**
     * An Example showing the problem with a copy using the equals signs.  When an instance is copied using the
     * equals the instances inside have the reference copied.  When the user change instance inside it will
     * change for both copies.
     *
     * Example
     *
     *  1. Create a Person and add attribute age
     *  2. Create a second person2 by using the equal's sign and set the attribute age using person2 to value newAge
     *  3. Check
     *          Check the first person age is the newAge
     *          Check the second person age is the newAge
     *          Check that both person1, person2 contains the same value
     */
    @Test
    public void showCopyFailure() {
        String age = "30";
        String newAge = "50";

        // Create a person add an Age
        Person person = new Person(
                "Charles Stockman", Person.IdentificationType.SocialSecurity, "123456789");
        person.addAttributed(Person.Attributes_Key.AGE_KEY, age);

        Assertions.assertEquals( person.getAttribute(Person.Attributes_Key.AGE_KEY), age);

        // create a second person by using the equal's sign
        Person person2 = person;
        person2.addAttributed(Person.Attributes_Key.AGE_KEY, newAge);

        // Proof
        //    Verify that person and person2 have the same age individually
        //    Compare peron's age to person2 age
        Assertions.assertEquals(person.getAttribute(Person.Attributes_Key.AGE_KEY), newAge);
        Assertions.assertEquals(person2.getAttribute(Person.Attributes_Key.AGE_KEY), newAge);
        Assertions.assertEquals(person.getAttribute(Person.Attributes_Key.AGE_KEY),
                person2.getAttribute(Person.Attributes_Key.AGE_KEY));
    }

    /**
     * Test the copy constructor
     *
     * The disadvantage of the copy constructor is that they must be written for each class.  This does take
     * work and unit testing.
     *
     * The advantage of using a copy constructor is that you specify what need to be copied or if a new instance
     * needs to created for the reference. ( Come up with an example here )
     *
     * 1. Create a Person and add attribute age
     * 2. Create a second Person using the copy constructor
     * 3. Check
     *      Check the first person's age is the age
     *      Check the second person's age is the second age
     *      Check that both person1, person2 contains the same value
     */
    @Test
    public void testCopyConstructor() {
        String age = "30";
        String newAge = "50";

        // Create a person add an Age
        Person person = new Person(
                "Charles Stockman", Person.IdentificationType.SocialSecurity, "123456789");
        person.addAttributed(Person.Attributes_Key.AGE_KEY, age);

        Assertions.assertEquals( person.getAttribute(Person.Attributes_Key.AGE_KEY), age);

        // Create a second Person using the copy constructor
        Person person2 = new Person(person);
        person2.addAttributed(Person.Attributes_Key.AGE_KEY, newAge);

        // Proof
        //    Verify that person and person2 have the same age individually
        //    Compare peron's age to person2 age
        Assertions.assertEquals(person.getAttribute(Person.Attributes_Key.AGE_KEY), age);
        Assertions.assertEquals(person2.getAttribute(Person.Attributes_Key.AGE_KEY), newAge);
        Assertions.assertNotEquals(person.getAttribute(Person.Attributes_Key.AGE_KEY),
                person2.getAttribute(Person.Attributes_Key.AGE_KEY));

    }
}
