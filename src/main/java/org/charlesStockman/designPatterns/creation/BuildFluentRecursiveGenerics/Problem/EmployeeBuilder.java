package org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Problem;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

/**
 * Creates an instance of @link { Employee } using the builder pattern.
 */
public class EmployeeBuilder extends PersonBuilder {

    @lombok.Data
    protected class EmployeeData {

        private String position;
    }

    // A cache to hold the data the suer enters.  Used to later when the instance is created.
    EmployeeData employeeData = new EmployeeData();

    /**
     * Stores the position for the creation of the Person Class
     *
     * @param position -- What the employee does at work.
     *
     * @return An instance of EmployeeBuilder with the value of the position
     */
    public EmployeeBuilder withPosition(@NonNull String position) {
        if (StringUtils.isEmpty(position) ) throw new IllegalArgumentException("For Person Builder the name must not length 0");
        employeeData.setPosition(position);
        return this;
    }
}
