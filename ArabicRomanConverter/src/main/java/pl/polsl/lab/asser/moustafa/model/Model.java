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
    
    /** the input from the user is set here (in case user inputted ROMAN number)*/
    private String inputValue;
    
    /** the input from the user is set here (in case user inputted Arabic number)*/
    private int inputNumeric;
    
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
     * Initialization function 
     * It uses a string to set the input value. 
     * Then calls the processInput() function to start the flow.
     * @param input represents the user input
     */
    public void init(String input){
        inputValue = input;
        //processInput();
    }
    
    /**
     * calls the isNumeric function and then calls the according validation function.
     */
    public void processInput(String input) throws InvalidCharacterException{
        inputValue = input.toUpperCase();

        if (isRoman()){
            System.out.println("Your number is in Correct Roman notation");
            willBeConverted = true;
            convertToArabic();
        }
        else if(isNumeric()){
            inputNumeric = Integer.parseInt(inputValue);
            System.out.println("Your number is in Correct Arabic \"notation\" \n");
            validateArabicNotation();
        }
        else {
            throw new InvalidCharacterException("\nThe number you entered contains unnaccepted characters"
                + "\nAccepted characters are only:"
                + "\n* Only POSITIVE numbers from 1 to 3999 (for numbers in Arabc notation)"
                + "\n* Characters 'I', 'V', 'X', 'L', 'C', 'D', 'M'. "
                + "(lower case accepted - for Roman notation)\n");
        }
    }
    
    /**
     * function that checks if the entered input is a valid roman numeric, using regex.
     * @return true if it is valid, false otherwise.
     */
    public boolean isRoman(){  
        return inputValue.toUpperCase().matches("^(I[VX]|VI{0,3}|I{1,3})|((X[LC]|"
                + "LX{0,3}|X{1,3})(I[VX]|V?I{0,3}))|"
                + "((C[DM]|DC{0,3}|C{1,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3}))|"
                + "(M+(C[DM]|D?C{0,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3}))$");
    }
    
    /**
     * checks if the input is numeric or not 
     * @return true if Numeric and false if not
     */
    public boolean isNumeric() throws InvalidCharacterException{
        if (inputValue == null || inputValue == ""){
            return false;
        }  
           
        else if (!inputValue.matches("^[0-9]+$")){
            return false;
        }
        
        else 
            return true;
    } 
    
    /**
     * Checks if the entered Arabic numeral is in the range between 1 and 3999
     */
    public void validateArabicNotation() throws IllegalArgumentException{
        if (inputNumeric < 1 || inputNumeric > 3999){
            //throw out of bounds
            throw new IllegalArgumentException("Validating number (" + inputNumeric + ") failed: number must be between 1 and 3999");
            //System.out.println("entered Arabic number is out of range");
        }
        else {
            willBeConverted = true;
            convertToRoman();
        }
    }
    
    
    /**
     * function that converts the entered ROman numeric to Arabic notation
     * it creates an object of class ArabicNumberGenerator that handles the number generating
     */
    public void convertToArabic() {
        System.out.println("\n Number is Validated" 
                    +"\nConverting number now...");
        ArabicNumberGenerator ArGen = new ArabicNumberGenerator();
        convertedNumeral =  Integer.toString(ArGen.generate(inputValue)) ;
    }
    
    /**
     * function that converts the entered Arabic numeric to Roman notation
     * it creates an object of class RomanNumeralGenerator that handles the number generating
     */
    public void convertToRoman (){
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
    
    public void reset(){
        this.inputNumeric = null;
    }
}



/*
TODO : 
1- fix recurring validation message 
2- ROMAN format exception handling 
3- maybe own class for AN range? 
*/