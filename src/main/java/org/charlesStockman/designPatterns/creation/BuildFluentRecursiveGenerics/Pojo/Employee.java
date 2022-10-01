package org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Models an employee for the Recursive Generic Examples
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person {

    // What does the person do at the company
    private String Position;
}
