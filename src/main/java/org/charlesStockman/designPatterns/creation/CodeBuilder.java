package org.charlesStockman.designPatterns.creation;

/**
 * Provide an implementation of the Builder Pattern
 *
 * Generates a String that contain a valid class with a class name and fields.
 */
public class CodeBuilder {

    private final String className;

    /**
     * Create an instance of CodeBuilder
     *
     * @param   className  The class name.
     */
    public CodeBuilder(String className) {
        this.className = className;
    }

    /**
     * Creates a valid Java class as a String
     */
    public String build() {
        StringBuilder classString = new StringBuilder();
        if ( className.isEmpty() == false )
            classString.append("public class " + className);

        return classString.toString();
    }
}
