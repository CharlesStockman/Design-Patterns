package org.charlesStockman.designPatterns.creation;

import org.charlesStockman.designPatterns.creation.other.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test the code that creates a Singleton
 */
public class SingletonTest {

    @Test
    /**
     * Return 2 instance
     *     If they have the same reference value and their data is the same then the SingletonCode works as expected
     */
    public void isSingleton() {

       String name = "Charles Stockman";
       String id   = "123456789";

       // Create the Singleton instance
       SingletonCode singletonCode = new SingletonCode(name, id);

       // Retrieve two references from the singleton
       Person person1 = singletonCode.getPersonData();
       Person person2 = singletonCode.getPersonData();

       // If the singleton Code is a singleton then the person1 and person2 will have same reference
       Assertions.assertSame(person1, person2);

       // As an additional check the data is correct.
       Assertions.assertSame(person1.getName(), name);
       Assertions.assertSame(person1.getSpecificId(), id);
       Assertions.assertSame(person2.getName(), name);
       Assertions.assertSame(person2.getSpecificId(), id);


    }
}
