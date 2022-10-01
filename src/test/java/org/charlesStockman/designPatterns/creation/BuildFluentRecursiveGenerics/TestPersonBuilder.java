package org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics;

import org.apache.commons.lang3.reflect.FieldUtils;

import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Pojo.Person;
import org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics.Problem.PersonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit Test the @Link { org.charlesStockman.designPatterns.creation.BuildFluentRecursiveGenerics }
 */
public class TestPersonBuilder {

    @Test
    public void testWithNameAsNull() {
        PersonBuilder personBuilder = new PersonBuilder();
        Assertions.assertThrows( NullPointerException.class, () -> personBuilder.withName(null),
                "For the PersonBuilder the name supplied must not be null");
    }

    @Test
    public void testWithNameAsEmptyString() {
        PersonBuilder personBuilder = new PersonBuilder();
        Assertions.assertThrows( IllegalArgumentException.class, () -> personBuilder.withName(new String("")),
                "For the PersonBuilder the name supplied must not be of length 0");
    }

    @Test
    public void TestWithNameAsActualName() throws IllegalAccessException {
        PersonBuilder personBuilder = new PersonBuilder();

        String name = "charles Stockman";
        personBuilder.withName(name);

        Object dataInstance = FieldUtils.readDeclaredField(personBuilder, "data", true);
        String resultName = (String)FieldUtils.readDeclaredField(dataInstance, "name", true);

        Assertions.assertEquals(resultName, name);
    }

    @Test
    public void TestWithGenderAsNull() {
        PersonBuilder personBuilder = new PersonBuilder();
        Assertions.assertThrows(NullPointerException.class, () -> personBuilder.withGender(null),
                "For the PersonBuilder the gender must not be null");
    }

    @Test
    public void TestWithGenderActualGender() throws IllegalAccessException {

        GenderEnum.Gender gender = GenderEnum.Gender.Male;

        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.withGender(gender);

        Object dataInstance = FieldUtils.readDeclaredField(personBuilder, "data", true);
        GenderEnum.Gender resultGender = (GenderEnum.Gender)FieldUtils.readDeclaredField(dataInstance, "gender", true);

        Assertions.assertEquals( resultGender, gender);
    }


    @Test
    public void TestBuildFunction() throws IllegalAccessException {
        String name = "Charles Stockman";
        GenderEnum.Gender gender = GenderEnum.Gender.Male;

        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.withName(name);
        personBuilder.withGender(gender);

        Person person = personBuilder.build();

        Assertions.assertEquals(person.getName(), name,
                String.format("PersonBuilder created a person with the name %s instead of %s", person.getName(), name));
        Assertions.assertEquals(person.getGender(), gender,
                String.format("PersonBuilder created a person with the gender of %s instead of %s", person.getGender().name(), person.getGender().name()));

    }
}
