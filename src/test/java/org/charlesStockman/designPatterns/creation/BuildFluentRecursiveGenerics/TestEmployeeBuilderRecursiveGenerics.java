package org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Pojo.Employee;
import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Solution.EmployeeBuilderRecursiveGenerics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit Test the @Link { org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics }
 */
public class TestEmployeeBuilderRecursiveGenerics {

    @Test
    public void testWitPostionAsNull() {
        EmployeeBuilderRecursiveGenerics employeeBuilder = new EmployeeBuilderRecursiveGenerics();
        Assertions.assertThrows( NullPointerException.class, () -> employeeBuilder.withPosition(null),
                "For the EmployeeBuilder the position supplied must not be null");
    }

    @Test
    public void testWithNameAsEmptyString() {
        EmployeeBuilderRecursiveGenerics employeeBuilder = new EmployeeBuilderRecursiveGenerics();
        Assertions.assertThrows( IllegalArgumentException.class, () -> employeeBuilder.withPosition(new String("")),
                "For the EmployeeBuilder the position supplied must not be of length 0");
    }

    @Test
    public void TestWithNameAsActualName() throws IllegalAccessException {
        EmployeeBuilderRecursiveGenerics employeeBuilder = new EmployeeBuilderRecursiveGenerics();

        String position = "Programmer";
        employeeBuilder.withPosition(position);

        Object dataInstance = FieldUtils.readDeclaredField(employeeBuilder, "employeeData", true);
        String resultName = (String)FieldUtils.readDeclaredField(dataInstance, "position", true);

        Assertions.assertEquals(resultName, position);
    }

    @Test
    public void testBuild() {
        EmployeeBuilderRecursiveGenerics employeeBuilder = new EmployeeBuilderRecursiveGenerics();

        String name = "Charles Stockman";
        GenderEnum.Gender gender = GenderEnum.Gender.Male;
        String profession = "Software Engineer";

        employeeBuilder.withName(name);
        employeeBuilder.withGender(gender);
        employeeBuilder.withPosition(profession);

        Employee employee = employeeBuilder.build();

        Assertions.assertEquals(name, employee.getName(), String.format("The name entered : %s does not mach the position stored %s", name, employee.getName()));
        Assertions.assertEquals(name, employee.getName(), String.format("The gender entered : %s does not mach the gender stored %s", gender, employee.getGender()));
        Assertions.assertEquals(name, employee.getName(), String.format("The position entered : %s does not mach the position stored %s", profession, employee.getPosition()));

    }
}
