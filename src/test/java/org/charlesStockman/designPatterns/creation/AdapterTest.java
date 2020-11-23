package org.charlesStockman.designPatterns.creation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test written to help the developer understand the adapter design pattern
 */
public class AdapterTest {

    private String className;
    private String variable1Type;
    private String variable1Name;

    @Before
    public void setup() {
        className = "TestClass";

        variable1Type = "String";
        variable1Name = "name";
    }

    /**
     * Test to verify the creation of an instance of class CodeBuilder with a valid parameter
     */
    @Test
    public void AdapterTestCreationClassWithClassName() {
        String answer = String.format("public class %s { }", className) ;
        CodeBuilder codeBuilder = new CodeBuilder(className);
        Assert.assertEquals(answer, codeBuilder.build());
    }

    /**
     * Test to verify the creation of CodeBuilder with a parameter name is null
     */
    @Test(expected = IllegalArgumentException.class)
    public void AdapterTestCreationWithClassNameNull() {
        className = null;
        CodeBuilder codeBuilder = new CodeBuilder(className);
        codeBuilder.build();
    }

    /**
     * Test to verify the creation of CodeBuilder with a parameter is spaces
     */
    @Test(expected = IllegalArgumentException.class)
    public void AdapterTestCreationWithClassNameWhiteSpace() {
        className = "   ";
        CodeBuilder codeBuilder2 = new CodeBuilder(className);
        codeBuilder2.build();
    }

    /**
     * Test to verify the addField can accept and store a Class/Primitive.
     */
    @Test
    public void adapterTestAddField() {
        String answer = String.format("public class %s { private %s %s; }", className, variable1Type, variable1Name) ;
        CodeBuilder codeBuilder = new CodeBuilder(className);
        codeBuilder.addField(variable1Type, variable1Name);

        String result = codeBuilder.build();
        Assert.assertEquals(answer, result);
        Assert.assertTrue(result.contains(variable1Name));
    }

    /**
     * Test to verify the type field cannot be null when building the class
     */
    @Test(expected = IllegalArgumentException.class)
    public void AdapterBuildFieldWithClassFieldTypeNull() {
        variable1Type = null;
        CodeBuilder codeBuilder = new CodeBuilder(className);
        codeBuilder.addField(variable1Type, variable1Name);
        codeBuilder.build();
    }

    /**
     * Test to verify the type field cannot be null when building the class
     */
    @Test(expected = IllegalArgumentException.class)
    public void AdapterBuildFieldWithClassFieldNameNull() {
        variable1Name = null;
        CodeBuilder codeBuilder = new CodeBuilder(className);
        codeBuilder.addField(variable1Type, variable1Name);
        codeBuilder.build();
    }

    /**
     * Test to verify the type field cannot be null when building the class
     */
    @Test(expected = IllegalArgumentException.class)
    public void AdapterBuildFieldWithClassFieldTypeBlank() {
        variable1Type = "  ";
        CodeBuilder codeBuilder = new CodeBuilder(className);
        codeBuilder.addField(variable1Type, variable1Name);
        codeBuilder.build();
    }

    /**
     * Test to verify the type field cannot be null when building the class
     */
    @Test(expected = IllegalArgumentException.class)
    public void AdapterBuildFieldWithClassFieldNameBlank() {
        variable1Name = "    ";
        CodeBuilder codeBuilder = new CodeBuilder(className);
        codeBuilder.addField(variable1Type, variable1Name);
        codeBuilder.build();
    }




}
