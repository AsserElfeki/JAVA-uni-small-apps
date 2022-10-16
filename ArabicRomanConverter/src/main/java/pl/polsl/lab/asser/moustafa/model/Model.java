/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.model;

import pl.polsl.lab.asser.moustafa.view.View;

/**
 * Model handles the data processing and storing and has all the methods used to
 * process it.
 * <p>
 * Has methods to validate all types of inputs and then process it. Uses
 * <code>Class View</code> object to log messages to the console. Encapsulates
 * objects of <code>class RomanNumeralGenerator</code> and
 * <code>class ArabicNumberGenerator</code> which are used in the conversion
 * step after all validations are done.
 *
 * @author asser.elfeki
 * @version 1.1
 */
public class Model {

    private View view;

    /**
     * the converted numeral (FINAL OUTPUT) (in both notations) is saved here
     */
    private String convertedNumeral;

    /**
     * One-parameter constructor used to set the field <code>view</code> of type
     * <code>class View</code> to the same view object that was created in the
     * controller.
     * @param view the view object passed from the controller
     */
    public Model(View view) {
        this.view = view;
    }

    /**
     * Starts the processing operation of the input given by the user in the
     * scenario of no given arguments in the command line.
     *
     * calls the isNumeric function and then calls the according validation
     * function.
     *
     * @param input is the user's input in a string form.
     * @throws InvalidCharacterException in 2 cases:
     * <ul>
     * <li>input is alphanumeric but is neither in Arabic or Roman notation.
     * <li>input is not alphanumeric.
     * </ul>
     */
    public void processInput(String input) throws InvalidCharacterException {

        if (isAlphaNumeric(input)) {

            if (isNumeric(input)) {
                view.logMessageToConsole("Your number is in Correct Arabic \"notation\" \n");
                validateArabicNotation(input);
            } else if (isRoman(input)) {
                view.logMessageToConsole("Your number contains only Roman characters");
                validateRomanNotation(input);
            } else {
                throw new InvalidCharacterException("You entered an invalid number format"
                        + "\nmight contain non-Roman letterals, or combiation of arabic and roman notations.. try again");
            }
        } else {
            throw new InvalidCharacterException("\nThe number you entered contains unnaccepted characters"
                    + "\nAccepted characters are only:"
                    + "\n* Only POSITIVE numbers from 1 to 3999 (for numbers in Arabc notation)"
                    + "\n* Characters 'I', 'V', 'X', 'L', 'C', 'D', 'M'. "
                    + "(lower case accepted - for Roman notation)\n");
        }
    }

    /**
     * Uses regex to match the input to only letters and numbers.
     * @param input User's input.
     * @return true if there is a match, false otherwise.
     */
    public boolean isAlphaNumeric(String input) {
        return input.matches("^[a-zA-Z0-9]+$");
    }

    /**
     * Checks if the entered input is a valid roman numeric, using
     * regex.
     * @param input User's input.
     * @return true if it is valid, false otherwise.
     */
    public boolean isRoman(String input) {

        return input.toUpperCase().matches("^[IVXLCDM]+");
    }

    /**
     * checks if the input is numeric or not
     * @param input User's input.
     * @return true if Numeric and false if not
     */
    public boolean isNumeric(String input) {
        if (input == null || input == "") {
            return false;
        } else if (!input.matches("^[0-9]+$")) {
            return false;
        } else {
            return true;
        }
    }

    
    /**
     * When the user enters a number in Arabic notation, it validates whether or not it lies in the accepted range
     * which is from 1 to 3999
     * @param input User's input.
     * @throws IllegalArgumentException if the number is out of range.
     */
    public void validateArabicNotation(String input) throws IllegalArgumentException {
        int inputNumeric = Integer.parseInt(input);
        if (inputNumeric < 1 || inputNumeric > 3_999) {
            throw new IllegalArgumentException("Validating number (" + inputNumeric + ") failed: number must be between 1 and 3999");
        } else {
            convertToRoman(inputNumeric);
        }
    }

    /**
     * When the user enters a number in Roman notation, it validates whether or not the input is in the correct format using a regex,
     * and confirms that the input follows the subtractive notation used in Roman numbers.
     * <p>
     * for example 4 in Roman notation is IV and not IIII
     * <p>
     * It sets 
     * @param input User's input
     * @throws IllegalArgumentException when the input does not match the regex, which means it's not in correct roman numeric format.
     */
    public void validateRomanNotation(String input) throws IllegalArgumentException {
        boolean match = input.toUpperCase().matches("^(I[VX]|VI{0,3}|I{1,3})|((X[LC]|"
                + "LX{0,3}|X{1,3})(I[VX]|V?I{0,3}))|"
                + "((C[DM]|DC{0,3}|C{1,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3}))|"
                + "(M+(C[DM]|D?C{0,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3}))$");

        if (match) {
            convertToArabic(input.toUpperCase());

        } else {
            throw new IllegalArgumentException("\nWrong Roman Numeric Format");
        }
    }

    /**
     * Converts the entered Roman numeric to Arabic notation.
     * <p>
     * it creates an object of class ArabicNumberGenerator that handles the number
     * generating
     * @param input User's input
     */
    public void convertToArabic(String input) {
        view.logMessageToConsole("\n Number is Validated"
                + "\nConverting number now...");
        ArabicNumberGenerator ArGen = new ArabicNumberGenerator();
        convertedNumeral = Integer.toString(ArGen.generate(input));
    }

    /**
     * Converts the entered Arabic numeric to Roman notation.
     * <p>
     * it creates an object of class RomanNumeralGenerator that handles the number
     * generating
     * @param inputNumeric User's input parsed to integer.
     */
    public void convertToRoman(int inputNumeric) {
        view.logMessageToConsole("\n Number is Validated"
                + "\nConverting number now...");
        RomanNumeralGenerator RnGen = new RomanNumeralGenerator();
        convertedNumeral = RnGen.generate(inputNumeric);
    }

    /**
     * Getter for the processed input.
     * Used also as a flag in the Controller, as long as it's an empty String 
     * the program keeps running and prompting the user again to enter a valid input
     * @return the converted number in any notation as a string
     */
    public String getOutput() {
        return convertedNumeral;
    }

    
}
