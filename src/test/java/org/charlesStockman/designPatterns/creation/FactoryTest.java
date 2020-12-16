package org.charlesStockman.designPatterns.creation;

import org.charlesStockman.designPatterns.creation.other.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test the FactoryCode class
 */
public class FactoryTest {

    @Test
    public void testSignatureClass() {
        boolean result;

        try {
            Class.forName("org.charlesStockman.designPatterns.creation.FactoryCode");
            result  = true;
        } catch ( ClassNotFoundException exception) {
            result = false;
        }

        Assertions.assertTrue(result);
    }

    /**
     * Create an illegal Person in the country.
     */
    @Test
    public void createAnIllegal() {
        String name = "Charles Stockman";
        Person person = FactoryCode.createIllegal(name);

        Assertions.assertNotNull(person);
        Assertions.assertEquals(person.getName(), name);
        Assertions.assertFalse(person.isCitizen());
        Assertions.assertFalse(person.isLegal());
    }

    /**
     * Create an Legal Alien in the country
     */
    @Test
    public void createLegalAlien() {
        String name                         = "Charles Stockman";
        Person.IdentificationType idType    = Person.IdentificationType.AlienRegistration;
        String specificId                   = "123456789";

        Person person = FactoryCode.createLegalAlien(name, idType, specificId);

        Assertions.assertNotNull(person);
        Assertions.assertEquals(person.getName(), name);
        Assertions.assertNotNull(person);
        Assertions.assertEquals(person.getName(), name);
        Assertions.assertEquals(idType, person.getIdentificationType());
        Assertions.assertEquals(specificId, person.getSpecificId());
        Assertions.assertFalse(person.isCitizen());
        Assertions.assertTrue(person.isLegal());
    }

    /**
     * Create a person who is a citizen
     */
    @Test
    public void createCitizen() {

        String name                         = "Charles Stockman";
        Person.IdentificationType idType    = Person.IdentificationType.SocialSecurity;
        String specificId                   = "123456789";

        Person person = FactoryCode.createLegalAlien(name, idType, specificId);

        Assertions.assertNotNull(person);
        Assertions.assertEquals(person.getName(), name);
        Assertions.assertNotNull(person);
        Assertions.assertEquals(person.getName(), name);
        Assertions.assertEquals(idType, person.getIdentificationType());
        Assertions.assertEquals(specificId, person.getSpecificId());
        Assertions.assertTrue(person.isCitizen());
        Assertions.assertTrue(person.isLegal());
    }

}