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
     * Creates a valid Java class blueprint as a String
     *
     * @exception   IllegalArgumentException    The classname is either null or empty.
     */
    public String build() {
        StringBuilder classString = new StringBuilder();

        // Verify that the classname is not null or contain only whitespace
        if ( className == null || className.isEmpty() ) {
            throw new IllegalArgumentException("parameter classname is either null or contaiuns whitespace only");
        }

        // Build the class
        if ( className.isEmpty() == false ) {
            classString.append("public class " + className);
            classString.append(" { ");
        }

        classString.append("}");

        return classString.toString();
    }
}
