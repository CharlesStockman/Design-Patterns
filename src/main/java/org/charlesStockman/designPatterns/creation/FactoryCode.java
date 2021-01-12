package org.charlesStockman.designPatterns.creation;

import org.charlesStockman.designPatterns.creation.other.Person;

public class FactoryCode {

    /**
     * Creates an illegal Person
     *
     * @param name      The name of the person
     *
     * @return An instance of <code>Person</code>
     *
     * @throws IllegalArgumentException if the name is not valid
     */
    public static Person createIllegal(String name) throws IllegalArgumentException {
        Person person = new Person(name);
        person.initialize();
        return person;
    }

    /**
     * Creates an Legal Alien
     *
     * @param name              The name of the Person
     * @param specificId        The specific for the person.
     *
     * @throws IllegalArgumentException if the name or specific id is not valid.
     */
    public static Person createLegalAlien(String name, String specificId ) {
        Person person = new Person(name, Person.IdentificationType.AlienRegistration, specificId);
        person.initialize();
        return person;
    }

    /**
     * Creates a citizen
     *
     * @param name              The name of the Person
     * @param specificId        The specific for the person.
     *
     * @throws IllegalArgumentException if the name or specific id is not valid.
     */
    public static Person createCitizen(String name, String specificId ) {
        Person person = new Person(name, Person.IdentificationType.SocialSecurity, specificId);
        person.initialize();
        return person;
    }
}
