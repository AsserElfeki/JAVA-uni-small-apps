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
    
    /**
     * Constructor for the class. Saves the input value and calls the processing func.
     * @param input represents the input entered by the user
     */
    public Model (String input){
        inputValue = input;
        processInput();
    }
    
    /**
     * calls the isNumeric function and then calls the according validation function.
     */
    public void processInput(){

        if (isNumeric()){
            inputNumeric = Integer.parseInt(inputValue);
            System.out.println("Your number is in Arabic notation");
            validateArabicNotation();
        }
        else {
            System.out.println("Your number is in Roman notation");
            validateRomanNotation();
        }
    }
    
    /**
     * checks if the input is numeric or not 
     * @return true if Numeric and false if not
     */
    public boolean isNumeric(){
        if (inputValue == null || inputValue == "") {
        return false;
        }   
    
        for (int i=0; i < inputValue.length(); i++) {
        char c = inputValue.charAt(i);
        if (c < '0' || c > '9') 
            return false;
        }
    return true;
    } 
    
    /**
     * Checks if the entered Arabic numeral is in the range between 1 and 3999
     */
    public void validateArabicNotation(){
        if (inputNumeric < 1 || inputNumeric > 3999){
            System.out.println("entered Arabic number is out of range");
            inputNumeric = 0; 
            processInput();
        }
        else {
            willBeConverted = true;
            convertToRoman();
        }
    }
    
    /**
     * Checks if the entered Roman numeral is in the range between I and MMMCMXCIX
     */
    public void validateRomanNotation(){
        //System.out.println("reached Roman Validator");
        boolean match = inputValue.matches("^(I[VX]|VI{0,3}|I{1,3})|((X[LC]|"
                + "LX{0,3}|X{1,3})(I[VX]|V?I{0,3}))|"
                + "((C[DM]|DC{0,3}|C{1,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3}))|"
                + "(M+(C[DM]|D?C{0,3})(X[LC]|L?X{0,3})(I[VX]|V?I{0,3}))$");
        
        if (match){
            convertToArabic();
            willBeConverted = true;

        }
        else {
            System.out.println("bad RN");
        }
    }
    
    
    /**
     * function that converts the entered ROman numeric to Arabic notation
     * it creates an object of class ArabicNumberGenerator that handles the number generating
     */
    public void convertToArabic() {
        System.out.println("reached convert to arabic, entered RN: " + inputValue);
        ArabicNumberGenerator ArGen = new ArabicNumberGenerator();
        convertedNumeral =  Integer.toString(ArGen.generate(inputValue)) ;
    }
    
    /**
     * function that converts the entered Arabic numeric to Roman notation
     * it creates an object of class RomanNumeralGenerator that handles the number generating
     */
    public void convertToRoman (){
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



