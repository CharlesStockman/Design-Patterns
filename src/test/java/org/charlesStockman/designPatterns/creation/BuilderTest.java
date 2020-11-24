package org.charlesStockman.designPatterns.creation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test written to help the developer understand the adapter design pattern
 */
public class BuilderTest {

    private String className;
    private String variable1Type;
    private String variable1Name;
    private String variable2Type;
    private String variable2Name;

    @Before
    public void setup() {
        className = "TestClass";

        variable1Type = "String";
        variable1Name = "name";

        variable2Type = "Integer";
        variable2Name = "age";

    }

    /**
     * Test to verify the creation of an instance of class BuilderCode with a valid parameter
     */
    @Test
    public void AdapterTestCreationClassWithClassName() {
        String answer = String.format("public class %s { }", className) ;
        BuilderCode builderCode = new BuilderCode(className);
        Assert.assertEquals(answer, builderCode.build());
    }

    /**
     * Test to verify the creation of BuilderCode with a parameter name is null
     */
    @Test(expected = IllegalArgumentException.class)
    public void AdapterTestCreationWithClassNameNull() {
        className = null;
        BuilderCode builderCode = new BuilderCode(className);
        builderCode.build();
    }

    /**
     * Test to verify the creation of BuilderCode with a parameter is spaces
     */
    @Test(expected = IllegalArgumentException.class)
    public void AdapterTestCreationWithClassNameWhiteSpace() {
        className = "   ";
        BuilderCode builderCode2 = new BuilderCode(className);
        builderCode2.build();
    }

    /**
     * Test to verify the addField can accept and store a Class/Primitive.
     */
    @Test
    public void adapterTestAddField() {
        String answer = String.format("public class %s { private %s %s; }", className, variable1Type, variable1Name) ;
        BuilderCode builderCode = new BuilderCode(className);
        builderCode.addField(variable1Type, variable1Name);

        String result = builderCode.build();
        Assert.assertEquals(answer, result);
        Assert.assertTrue(result.contains(variable1Name));
    }

    /**
     * Test to verify the type field cannot be null when building the class
     */
    @Test(expected = IllegalArgumentException.class)
    public void AdapterBuildFieldWithClassFieldTypeNull() {
        variable1Type = null;
        BuilderCode builderCode = new BuilderCode(className);
        builderCode.addField(variable1Type, variable1Name);
        builderCode.build();
    }

    /**
     * Test to verify the type field cannot be null when building the class
     */
    @Test(expected = IllegalArgumentException.class)
    public void AdapterBuildFieldWithClassFieldNameNull() {
        variable1Name = null;
        BuilderCode builderCode = new BuilderCode(className);
        builderCode.addField(variable1Type, variable1Name);
        builderCode.build();
    }

    /**
     * Test to verify the type field cannot be null when building the class
     */
    @Test(expected = IllegalArgumentException.class)
    public void AdapterBuildFieldWithClassFieldTypeBlank() {
        variable1Type = "  ";
        BuilderCode builderCode = new BuilderCode(className);
        builderCode.addField(variable1Type, variable1Name);
        builderCode.build();
    }

    /**
     * Test to verify the type field cannot be null when building the class
     */
    @Test(expected = IllegalArgumentException.class)
    public void AdapterBuildFieldWithClassFieldNameBlank() {
        variable1Name = "    ";
        BuilderCode builderCode = new BuilderCode(className);
        builderCode.addField(variable1Type, variable1Name);
        builderCode.build();
    }

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
        Assert.assertEquals(result, answer);
    }
}
