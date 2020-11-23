package org.charlesStockman.designPatterns.creation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test written to help the developer understand the adapter design pattern
 */
public class AdapterTest {

    private String className;

    @Before
    public void setup() {
        className = "TestClass";
    }

    /**
     * Test to verify the creation of a instance of class CodeBuilder with a valid parameter
     */
    @Test
    public void AdapterTestClassWithClassName() {
        String answer = "public class " + className;
        CodeBuilder codeBuilder = new CodeBuilder(className);
        Assert.assertEquals(answer, codeBuilder.build());
    }


}
