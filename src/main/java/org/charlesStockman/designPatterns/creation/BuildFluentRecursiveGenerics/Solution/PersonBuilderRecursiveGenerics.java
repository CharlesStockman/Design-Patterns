package org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Solution;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.GenderEnum;
import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Pojo.Person;

/**
 * To show how to create a builder that inherits from another builder
 */
public class PersonBuilderRecursiveGenerics<SELF extends PersonBuilderRecursiveGenerics<SELF>> {

    private Data data = new Data();

    /**
     * STore the name property for the creation of the Person Class.
     *
     * @param name  The name of the person, but it cannot be null or have blank spaces
     *
     * @return  An instance of PersonBuilder containing the value of the name
     */
    public SELF withName(@NonNull String name) throws IllegalArgumentException {
        if (StringUtils.isEmpty(name) ) throw new IllegalArgumentException("For Person Builder the name must not length 0");
        data.setName(name);
        return self();
    }

    /**
     * Stores the gender ( Male or Female ) for the creation of the Person Class
     *
     * @param gender -- An enumeration that has two choices ( Male, Female )
     *
     * @return An instance of PersonBuilder with the value of the Gender
     */
    public SELF withGender(@NonNull GenderEnum.Gender gender) {
        data.setGender(gender);
        return self();
    }

    /**
     * Creates a person instance
     *
     * @param person -- The class modelling the Person which will be filled in by setters
     *
     */
    protected void createPersonInstance(Person person) {
        person.setName(data.getName());
        person.setGender(data.getGender());
    }

    /**
     * Based on the provided by the functions start with create a @Link {Person} instance
     *
     * @return An instance of the class person
     */
    public Person build() {
        Person person = new Person();
        createPersonInstance(person);
        return person;
    }

    /**
     * Allow the correct class instance to be returned from the descendent classes
     */
    protected SELF self() { return (SELF)this; }

    /**
     * A class that contains the data until the developer is ready to create the class based on the data
     *
     * @author Charles Stockman
     */
    @lombok.Data
    protected class Data {
        private String name;
        private GenderEnum.Gender gender;
    }
}
