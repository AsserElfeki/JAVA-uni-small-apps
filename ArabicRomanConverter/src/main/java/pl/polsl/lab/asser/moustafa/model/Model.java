/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.model;

import java.util.regex.*;
import static pl.polsl.lab.asser.moustafa.model.RomanNumeralGenerator.*;

/**
 * handles the data and the methods used to process it
 * @author asser.elfeki
 * @version 1.1
 */
public class Model {
    
    
    /** the converted numeral (FINAL OUTPUT) (in both notations) is saved here*/
    private String convertedNumeral ; 
    
    /** true if the entered input is in a correct number in either notation*/
    boolean willBeConverted = false; 
    
    private final char[] ACCEPTED_RN = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    
    /**
     * Non-parameter constructor
     */
    public Model (){
    }
   
    
    /**
     * calls the isNumeric function and then calls the according validation function.
     */
    public void processInput(String input) throws InvalidCharacterException{
        //inputValue = input.toUpperCase();

        if (isAlphaNumeric(input)){
            
            if(isNumeric(input)){
                //inputNumeric = Integer.parseInt(inputValue);
                System.out.println("Your number is in Correct Arabic \"notation\" \n");
                validateArabicNotation(input);
            }
            else if (isRoman(input)){
                System.out.println("Your number contains only Roman characters");
//                convertToArabic();
                validateRomanNotation(input);
            }
            else throw new InvalidCharacterException("You entered an invalid number format"
                    + "\n might contain non-Roman letterals, or combiation of arabic and roman notations.. try again");
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
//        return inputValue.toUpperCase().matches("^(I[VX]|VI{0,3}|I{1,3})|((X[LC]|"
//                + "LX{0,3}|X{1,3})(I[VX]|V?I{0,3}))|"
//                + "((C[DM]|DC{0,3}|C{1,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3}))|"
//                + "(M+(C[DM]|D?C{0,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3}))$");
    }
    
    /**
     * checks if the input is numeric or not 
     * @return true if Numeric and false if not
     */
    public boolean isNumeric(String input) throws InvalidCharacterException{
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
        if (inputNumeric < 1 || inputNumeric > 3999){
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
        System.out.println("\n Number is Validated" 
                    +"\nConverting number now...");
        ArabicNumberGenerator ArGen = new ArabicNumberGenerator();
        convertedNumeral =  Integer.toString(ArGen.generate(input)) ;
    }
    
    /**
     * function that converts the entered Arabic numeric to Roman notation
     * it creates an object of class RomanNumeralGenerator that handles the number generating
     */
    public void convertToRoman (int inputNumeric){
        System.out.println("\n Number is Validated" 
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



