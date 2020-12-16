package org.charlesStockman.designPatterns.creation.other;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
@EqualsAndHashCode
/**
 * Describes a person
 */
public class Person {

    /**
     * This enumeration describes attributes of the person, such as hair, eye color an more
     */
    public enum Attributes_Key {
        AGE_KEY,
        HAIR_COLOR_KEY,
        EYE_COLOR_KEY
    }

    /**
     * The enumeration describes the type of identification.  A citizen will have
     * a social security number and an alien will have a alien identification number
     */
    public enum IdentificationType {
        SocialSecurity,
        AlienRegistration;

        /**
         * Provides a standard format for each type
         *
         * Social Security - convert a string umber to \d\d\d-\d\d-\d\d\d\d
         * Alien Registration - Add a "A" as the first character
         */
        public String format(String data) {

            String result = "";

            switch(this) {
                case SocialSecurity:
                    result = String.format("%s-%s-%s", data.substring(0,3), data.substring(3,5), data.substring(5,9));
                    break;
                case AlienRegistration:
                    result = "A" + data;
                    break;
            }

            return result;
        }
    };

    private int id = 0;

    /**
     * The person's Name
     */
    @Getter
    private String name;

    /**
     * Type of identification based on whether the person is a US Citizen
     */
    @Getter
    private IdentificationType identificationType;

    /**
     * The specific identification
     */
    @Getter
    private String specificId;

    /**
     * Is the person a citizen or a foreigner
     */
    @Getter
    private boolean isCitizen;

    /**
     * Is the person illegally in the United States
     */
    @Getter
    private boolean isLegal;

    /**
     * A set of physical attributes
     */
    private Map<Attributes_Key, String> physicalAttributes;


    /**
     * Creates an instance of an Person that is not a citizen
     *
     * @param name -- The person's name
     */
    public Person(String name) {
        this.id = -1;
        this.name = name;
        this.isLegal = false;
        this.isCitizen = false;
    }

    /**
     * Creates an  instance of a Alien with an Identification
     *
     * @param name                  The name of the person
     * @param type                  Which identification is being used ( Social Security or Alien )
     * @praam identificationId      The id unique to the person.
     */
    public Person(String name, IdentificationType type, String IdentificationId) {
        this(name);
        this.identificationType = type;
        this.specificId = IdentificationId;

        isLegal = true;
        isCitizen = ( type == IdentificationType.AlienRegistration ) ? false : true;
    }

    /**
     * Initializes the class to avoid an exception being called in a constructor.  Call this class after creating the constructor
     *
     * @exception IllegalArgumentException      The data was not valid
     */
    public void initialize() throws IllegalArgumentException {
        validateName(this.getName());
        if ( identificationType != null ) validateIdentification(getSpecificId());
    }

    /**
     * Allows the developer to add physical attributes about the person
     *
     * @exception IllegalArgumentException The value is null or blank
     *
     * @param key           The key used to find the value
     * @param value         The value
     */
    public void addAttributed(Attributes_Key key, String value) {

        if ( physicalAttributes == null ) {
            physicalAttributes = new HashMap<>();
        }

        if ( value == null || value.trim().length() == 0) {
            throw new IllegalArgumentException("Cannot insert a value that is null or made up of spaces ");
        }

        physicalAttributes.put(key, value);

    }

    public String getAttribute(Attributes_Key key) {
        String value =  physicalAttributes.getOrDefault(key, "None");
        return value;
    }

    /**
     * Verify that the name value entered is legal.
     */
    public Boolean validateName(String data) {

        Boolean result = true;
        if ( data == null || data.trim().length() == 0 ) {
            throw new IllegalArgumentException("data ( Name ) cannot be null or contain only spaces");
        }

        return result;

    }
    /**
     * Verify that the identification value enter is legal.
     *
     * <b>When an instance is created then call this function directly after to validate the data. </b>
     *
     * 1. Cannot be an empty string
     * 2. Must contain only 0-9 in string
     * 3. The number of character is nine only.
     *
     * @param data          The identification String
     * @return (t) The data string is not empty and contains only numbers
     *
     * @exception IllegalArgumentException The string null, empty or contains characters other than nine numbers
     */
    public Boolean validateIdentification(String data) {

        int SIZE_OF_NUMBER = 9;

        if (  data.trim().length() == 0) {
            throw new IllegalArgumentException("data ( Identification )variable cannot be empty or null");
        }

        if ( data.matches("\\d+") == false ) {
            throw new IllegalArgumentException("data ( Identification ) variable contains more characters that are not digits ");
        }

        if (data.length() != 9 ) {
            throw new IllegalArgumentException("datai ( Identification ) variable does not contain exactly nine characters");
        }

        return true;
    }
}
