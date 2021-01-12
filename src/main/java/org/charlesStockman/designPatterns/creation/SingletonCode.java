package org.charlesStockman.designPatterns.creation;

import org.charlesStockman.designPatterns.creation.other.Person;

/**
 * Demonstrates the Singleton Pattern
 */
public class SingletonCode {

    // The name of the person
    private String name;

    // The id of the person
    private String id = "123456789";

    // The only instance of the person
    private static Person person =  null;


    /**
     * Create an instance of a Person
     *
     * @param name      The name of the person
     * @param id        The identification of the person
     */
    public SingletonCode(String name, String id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Create the only instance of the Person
     *
     * @return The only instance of the person
     */
    public Person getPersonData() {
        if ( person == null ) person = FactoryCode.createLegalAlien(name, id);
        return person;
    }
}
