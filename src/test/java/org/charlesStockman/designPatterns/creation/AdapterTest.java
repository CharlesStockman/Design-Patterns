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

        String variable1Type = "String";
        String variable11Name = "name";
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

        className = null;
        CodeBuilder codeBuilder2 = new CodeBuilder(className);
        codeBuilder2.build();
    }

    /**
     * Test to verify the addField can accept and store a Class/Primitive and the variable name and allow the developer
     * to chain functions
     */
    @Test
    public void adapterTestAddField() {
        String answer = String.format("public class %s { public %s %s; }", className, variable1Type, variable1Name) ;
        CodeBuilder codeBuilder = new CodeBuilder(className);
        String result = codeBuilder.build();

        Assert.assertEquals(answer, result);

    }
}
