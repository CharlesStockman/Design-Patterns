package org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Solution;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Pojo.Employee;

/**
 * Enhances the Person instance with information about employment
 */
public class EmployeeBuilderRecursiveGenerics extends PersonBuilderRecursiveGenerics<EmployeeBuilderRecursiveGenerics> {

    @lombok.Data
    protected class EmployeeData extends Data {
        private String position;
    }

    EmployeeData employeeData = new EmployeeData();

    /**
     * Stores the position for the creation of the Person Class
     *
     * @param position -- What the employee does at work.
     *
     * @return An instance of EmployeeBuilder with the value of the position
     */
    public EmployeeBuilderRecursiveGenerics withPosition(@NonNull String position) {
        if (StringUtils.isEmpty(position) ) throw new IllegalArgumentException("For Person Builder the name must not length 0");
        employeeData.setPosition(position);
        return this;
    }

    /**
     * Allow the correct class instance to be returned from the descendent classes
     */
    @Override
    protected EmployeeBuilderRecursiveGenerics self() {
        return this;
    }

    /**
     * Creates an Employee instance
     *
     * @param employee -- The class modelling the Employee which will be filled in by setters
     *
     */
    protected void createEmployeeInstance(Employee employee) {
        this.createPersonInstance(employee);
        employee.setPosition(employeeData.getPosition());
    }

    /**
     * Creates a instance of the Employee.
     * @return
     */
    @Override
    public Employee build() {
        Employee employee = new Employee();
        this.createPersonInstance(employee);
        employee.setPosition(employeeData.getPosition());
        return employee;
    }

}
