package org.charlesStockman.designPatterns.creation;

import java.util.ArrayList;
import java.util.List;

/**
 * Provide an implementation of the Builder Pattern
 *
 * Generates a String that contain a valid class with a class name and fields.
 */
public class CodeBuilder {

    private final String className;
    private final List<List> memberVariablesDescriptions;

    public static final int TYPE_INDEX = 0;
    public static final int NAME_INDEX = 1;

    /**
     * Create an instance of CodeBuilder
     *
     * @param   className  The class name.
     */
    public CodeBuilder(String className) {
        this.className = className;
        this.memberVariablesDescriptions = new ArrayList<>();
    }

    /**
     * Creates a valid Java class blueprint as a String
     *
     * @exception   IllegalArgumentException    The classname is either null or empty.
     */
    public String build() {
        StringBuilder classString = new StringBuilder();

        // Verify that the classname is not null or contain only whitespace
        if ( className == null || className.isBlank()) {
            throw new IllegalArgumentException("parameter classname is either null or contaiuns whitespace only");
        }

        for ( List<String> tuple : memberVariablesDescriptions) {
            String typeValue = tuple.get(TYPE_INDEX);
            String typeName  = tuple.get(NAME_INDEX);

            if ( typeValue == null || typeName == null || typeValue.isBlank() || typeName.isBlank() )
                throw new IllegalArgumentException("parameter for the type or field name cannot be null");
        }

        // Build the class
        classString.append("public class " + className);
        classString.append(" { ");
        for ( List<String> tuple : memberVariablesDescriptions)
            classString.append(String.format("private %s %s; ", tuple.get(TYPE_INDEX), tuple.get(NAME_INDEX)));
        classString.append("}");

        return classString.toString();
    }

    /**
     * Creates add a public member variable ( type and name ) to the builder
     *
     * @return The current object ( this ) return to facilitate chaining.
     */
    public CodeBuilder addField(String type, String name ) {

        ArrayList tuple = new ArrayList<String>();
        tuple.add(0, type);
        tuple.add(1, name);

        memberVariablesDescriptions.add(tuple);

        return this;
    }
}
