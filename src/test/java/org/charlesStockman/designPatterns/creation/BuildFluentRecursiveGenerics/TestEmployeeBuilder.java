package org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Problem.EmployeeBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit Test the @Link { org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics }
 */
public class TestEmployeeBuilder {

    @Test
    public void testWitPositionAsNull() {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        Assertions.assertThrows( NullPointerException.class, () -> employeeBuilder.withPosition(null),
                "For the EmployeeBuilder the position supplied must not be null");
    }

    @Test
    public void testPositionAsEmptyString() {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        Assertions.assertThrows( IllegalArgumentException.class, () -> employeeBuilder.withPosition(new String("")),
                "For the EmployeeBuilder the position supplied must not be of length 0");
    }

    @Test
    public void TestWithPositionAsActualName() throws IllegalAccessException {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();

        String position = "Programmer";
        employeeBuilder.withPosition(position);

        Object dataInstance = FieldUtils.readDeclaredField(employeeBuilder, "employeeData", true);
        String resultPosition = (String)FieldUtils.readDeclaredField(dataInstance, "position", true);

        Assertions.assertEquals(resultPosition, position, String.format("The position entered : %s does not mach the position stored %s", position, resultPosition));
    }
}
