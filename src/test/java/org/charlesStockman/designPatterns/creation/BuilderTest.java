package org.charlesStockman.designPatterns.creation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test written to help the developer understand the adapter design pattern
 */
public class BuilderTest {

    private String className;
    private String variable1Type;
    private String variable1Name;
    private String variable2Type;
    private String variable2Name;

    @BeforeEach
    public void setup() {
        className = "TestClass";

        variable1Type = "String";
        variable1Name = "name";

        variable2Type = "Integer";
        variable2Name = "age";

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // BuilderCode Constructor Tests with the className className
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Test to verify the creation of an instance of class BuilderCode with a valid parameter
     */
    @Test
    public void AdapterTestCreationClassWithClassName() {
        String answer = String.format("public class %s { }", className) ;
        BuilderCode builderCode = new BuilderCode(className);
        Assertions.assertEquals(answer, builderCode.build());
    }

    /**
     * Test to verify the creation of BuilderCode with a parameter name is null
     */
    @Test
    public void AdapterTestCreationWithClassNameNull() {
        BuilderCode builderCode = new BuilderCode(null);

        Assertions.assertThrows(IllegalArgumentException.class, builderCode::build);

    }

    /**
     * Test to verify the creation of BuilderCode with a parameter is spaces
     */
    @Test
    public void AdapterTestCreationWithClassNameWhiteSpace() {
        className = "   ";
        BuilderCode builderCode = new BuilderCode(className);

        Assertions.assertThrows(IllegalArgumentException.class, builderCode::build);

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // BuilderCode addField() with parameters variable1Type and variable1Type
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Test to verify the addField can accept and store a Class/Primitive.
     */
    @Test
    public void adapterTestAddField() {
        String answer = String.format("public class %s { private %s %s; }", className, variable1Type, variable1Name) ;
        BuilderCode builderCode = new BuilderCode(className);
        builderCode.addField(variable1Type, variable1Name);

        String result = builderCode.build();
        Assertions.assertEquals(answer, result);
        Assertions.assertTrue(result.contains(variable1Name));
    }

    /**
     * Test to verify the type field cannot be null when building the class
     */
    @Test
    public void AdapterBuildFieldWithClassFieldTypeNull() {
        BuilderCode builderCode = new BuilderCode(className);
        builderCode.addField(null, variable1Name);

        Assertions.assertThrows(IllegalArgumentException.class, builderCode::build);
    }

    /**
     * Test to verify the type field cannot be null when building the class
     */
    @Test
    public void AdapterBuildFieldWithClassFieldNameNull() {
        BuilderCode builderCode = new BuilderCode(className);
        builderCode.addField(variable1Type, null);

        Assertions.assertThrows(IllegalArgumentException.class, builderCode::build);
    }

    /**
     * Test to verify the type field cannot be null when building the class
     */
    @Test
    public void AdapterBuildFieldWithClassFieldTypeBlank() {
        variable1Type = "  ";
        BuilderCode builderCode = new BuilderCode(className);
        builderCode.addField(variable1Type, variable1Name);

        Assertions.assertThrows(IllegalArgumentException.class, builderCode::build);
    }

    /**
     * Test to verify the type field cannot be null when building the class
     */
    @Test
    public void AdapterBuildFieldWithClassFieldNameBlank() {
        variable1Name = "    ";
        BuilderCode builderCode = new BuilderCode(className);
        builderCode.addField(variable1Type, variable1Name);

        Assertions.assertThrows(IllegalArgumentException.class, builderCode::build);

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // verifies the build function works correctly
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Test to verify the type build produce correct code
     *
     * Assumption the test for making sure the classname, type names and field name have already been completed
     */
    @Test
    public void AdapterBuild() {
        String answer = String.format("public class %s { private %s %s; private %s %s; }",
                className, variable1Type, variable1Name, variable2Type, variable2Name) ;
        String result = new BuilderCode(className).addField(variable1Type, variable1Name).addField(variable2Type, variable2Name).build();
        Assertions.assertEquals(result, answer);
    }
}
