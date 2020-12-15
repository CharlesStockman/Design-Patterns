package org.charlesStockman.designPatterns.creation;

import org.charlesStockman.designPatterns.creation.other.Person;

public class FactoryCode {

    /**
     * Creates an illegal Person
     *
     * @param name      The name of the person
     *
     * @return An instance of <code>Person</code>
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
     * @param IdType            The Type of the Id ( ex. Social Security )
     * @param specificId        The specific for the person.
     */



}
