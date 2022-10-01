package org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics;

import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Pojo.Employee;
import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Problem.EmployeeBuilder;
import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Solution.EmployeeBuilderRecursiveGenerics;

public class BuilderFluentRecursiveGenerics {

    public static void main(String... args ) {

        // Problem : withName returns an instance of PersonBuilder that does not have access to the functions in EmployeeBuilder
        // The code cannot even compile
        //EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        //employeeBuilder.withName("Charles Stockman").withPosition("Attain").build();

        // Solution Recursive Generics
        // The main idea is that the functions returning an instance from 
        EmployeeBuilderRecursiveGenerics employeeBuilder = new EmployeeBuilderRecursiveGenerics();
        Employee employee = employeeBuilder.withName("Chalres Stockman").withPosition("Software Engineer").withGender(GenderEnum.Gender.Male).build();
        System.out.println("Employee = " + employee.toString());

    }
}

