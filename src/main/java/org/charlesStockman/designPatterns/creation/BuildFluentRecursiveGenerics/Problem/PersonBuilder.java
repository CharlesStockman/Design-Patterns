package org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Problem;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.GenderEnum;
import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Pojo.Person;

/**
 * Creates an instance of the @{ Person } using the instance builder
 */
public class PersonBuilder {

    private Data data = new Data();

    /**
     * Store the name property for the creation of the Person Class.
     *
     * @param name  The name of the person, but it cannot be null or have blank spaces
     *
     * @return  An instance of PersonBuilder containing the value of the name
     */
    public PersonBuilder withName(@NonNull String name) throws IllegalArgumentException {
        if (StringUtils.isEmpty(name) ) throw new IllegalArgumentException("For Person Builder the name must not length 0");
        data.setName(name);
        return this;
    }

    /**
     * Stores the gender ( Male or Female ) for the creation of the Person Class
     *
     * @param gender -- An enumeration that has two choices ( Male, Female )
     *
     * @return An instance of PersonBuilder with the value of the Gender
     */
    public PersonBuilder withGender(@NonNull GenderEnum.Gender gender) {
        data.setGender(gender);
        return this;
    }

    /**
     * Based on the data provided by the functions ( withGender, withName ) start with create a @Link {Person} instance
     *
     * @return An instance of the class person
     */
    public Person build() {
        Person person = new Person( data.getName(), data.getGender());
        return person;
    }

    /**
     *  A cache to hold the data the suer enters.  Used to later when the instance is created.
     *
     * @author Charles Stockman
     */
    @lombok.Data
    protected class Data {

        // The name entered by the caller of withName()
        private String name;

        // The Gender ( Male or Female ) entered by the caller of with Gender()
        private GenderEnum.Gender gender;
    }
}
