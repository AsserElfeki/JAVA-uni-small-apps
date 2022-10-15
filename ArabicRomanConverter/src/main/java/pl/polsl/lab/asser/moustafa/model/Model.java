/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.model;

import pl.polsl.lab.asser.moustafa.view.View;

/**
 * handles the data and the methods used to process it
 * @author asser.elfeki
 * @version 1.1
 */
public class Model {
    
    private View view; 
    
    /** the converted numeral (FINAL OUTPUT) (in both notations) is saved here*/
    private String convertedNumeral ; 
    
    /** true if the entered input is in a correct number in either notation*/
    boolean willBeConverted = false; 
    
    private final char[] ACCEPTED_RN = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    
    /**
     * Non-parameter constructor
     */
    public Model (View view){
        this.view = view;
    }
   
    
    /**
     * calls the isNumeric function and then calls the according validation function.
     */
    public void processInput(String input) throws InvalidCharacterException{

        if (isAlphaNumeric(input)){
            
            if(isNumeric(input)){
                view.logMessageToConsole("Your number is in Correct Arabic \"notation\" \n");
                validateArabicNotation(input);
            }
            else if (isRoman(input)){
                view.logMessageToConsole("Your number contains only Roman characters");
                validateRomanNotation(input);
            }
            else throw new InvalidCharacterException("You entered an invalid number format"
                    + "\nmight contain non-Roman letterals, or combiation of arabic and roman notations.. try again");
        }
        
        
        else {
            throw new InvalidCharacterException("\nThe number you entered contains unnaccepted characters"
                    + "\nAccepted characters are only:"
                    + "\n* Only POSITIVE numbers from 1 to 3999 (for numbers in Arabc notation)"
                    + "\n* Characters 'I', 'V', 'X', 'L', 'C', 'D', 'M'. "
                    + "(lower case accepted - for Roman notation)\n");
        }
    }
    
    
    
    public boolean isAlphaNumeric(String input){
        return input.matches("^[a-zA-Z0-9]+$");
    }
    
    /**
     * function that checks if the entered input is a valid roman numeric, using regex.
     * @return true if it is valid, false otherwise.
     */
    public boolean isRoman(String input){  
        
        return input.toUpperCase().matches("^[IVXLCDM]+");
    }
    
    /**
     * checks if the input is numeric or not 
     * @return true if Numeric and false if not
     */
    public boolean isNumeric(String input) {
        if (input == null || input == ""){
            return false;
        }  
           
        else if (!input.matches("^[0-9]+$")){
            return false;
        }
        
        else 
            return true;
    } 
    
    /**
     * Checks if the entered Arabic numeral is in the range between 1 and 3999
     */
    public void validateArabicNotation(String input) throws IllegalArgumentException{
        int inputNumeric = Integer.parseInt(input);
        if (inputNumeric < 1 || inputNumeric > 3_999){
            throw new IllegalArgumentException("Validating number (" + inputNumeric + ") failed: number must be between 1 and 3999");
        }
        else {
            willBeConverted = true;
            convertToRoman(inputNumeric);
        }
    }
    
    public void validateRomanNotation (String input) throws IllegalArgumentException {
        boolean match = input.toUpperCase().matches("^(I[VX]|VI{0,3}|I{1,3})|((X[LC]|"
                + "LX{0,3}|X{1,3})(I[VX]|V?I{0,3}))|"
                + "((C[DM]|DC{0,3}|C{1,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3}))|"
                + "(M+(C[DM]|D?C{0,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3}))$");
        
        if (match){
            willBeConverted = true;
            convertToArabic(input.toUpperCase());

        }
        else {
            throw new IllegalArgumentException("\nWrong Roman Numeric Format");
        }
    }
    
    /**
     * function that converts the entered ROman numeric to Arabic notation
     * it creates an object of class ArabicNumberGenerator that handles the number generating
     */
    public void convertToArabic(String input) {
        view.logMessageToConsole("\n Number is Validated" 
                    +"\nConverting number now...");
        ArabicNumberGenerator ArGen = new ArabicNumberGenerator();
        convertedNumeral =  Integer.toString(ArGen.generate(input)) ;
    }
    
    /**
     * function that converts the entered Arabic numeric to Roman notation
     * it creates an object of class RomanNumeralGenerator that handles the number generating
     */
    public void convertToRoman (int inputNumeric){
        view.logMessageToConsole("\n Number is Validated" 
                    +"\nConverting number now...");
        RomanNumeralGenerator RnGen = new RomanNumeralGenerator();
        convertedNumeral = RnGen.generate(inputNumeric);
    }
    
    /**
     * getter for the output
     * @return the converted number in any notation as a string
     */
    public String getOutput(){
        return convertedNumeral;
    }
    
    
    /**
     * getter for the boolean that is used as a flag
     * @return boolean that represents if the input is valid or not
     */
    public boolean inputCanBeProcessed (){
        return willBeConverted;
    }
}
