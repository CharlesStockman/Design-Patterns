package org.charlesStockman.designPatterns.creation;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Provide an implementation of the Builder Pattern
 *
 * Generates a String that contain a valid class with a class name and fields.
 */
public class BuilderCode {

    private final String className;
    private final List<List> memberVariablesDescriptions;

    public static final int TYPE_INDEX = 0;
    public static final int NAME_INDEX = 1;

    /**
     * Create an instance of BuilderCode
     *
     * @param   className  The class name.
     */
    public BuilderCode(String className) {
        this.className = className;
        this.memberVariablesDescriptions = new ArrayList<>();
    }

    /**
     * Creates a valid Java class blueprint as a String
     *
     * Handle checking of all data before the string is built.  This includes the class name and the name and type
     * of each field.
     *
     * @exception   IllegalArgumentException    The classname is either null or empty.
     */
    public String build() {
        StringBuilder classString = new StringBuilder();

        // Verify that the classname is not null or contain only whitespace
        if ( StringUtils.isBlank(className)) {
            throw new IllegalArgumentException("parameter classname is either null or contains whitespace only");
        }

        for ( List<String> tuple : memberVariablesDescriptions) {
            String typeValue = tuple.get(TYPE_INDEX);
            String typeName  = tuple.get(NAME_INDEX);

            if ( StringUtils.isBlank(typeName) || StringUtils.isBlank(typeValue) )
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
    public BuilderCode addField(String type, String name ) {

        ArrayList tuple = new ArrayList<String>();
        tuple.add(0, type);
        tuple.add(1, name);

        memberVariablesDescriptions.add(tuple);

        return this;
    }
}
