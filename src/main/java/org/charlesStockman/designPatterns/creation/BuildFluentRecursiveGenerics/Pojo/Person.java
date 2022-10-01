package org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.GenderEnum;

/**
 * A class to model a person for the Recursive Generic Examples
 */
@Data
@NoArgsConstructor
public class Person {

    // One of the labels for the identification of a person
    private String name;

    // Is the person male or female
    private GenderEnum.Gender gender;

    /**
     * Creates an instance of Person Instance with the name and gender
     *
     * @param name      The name of the person cannot be null or empty
     * @param gender    The gender of the person cannot be null
     */
    public Person(String name, GenderEnum.Gender gender ) {
        this.name = name;
        this.gender = gender;
    }
}
