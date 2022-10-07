/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.model;

/**
 * handles the data and the methods used to process it
 * @author asser.elfeki
 */
public class Model {
    
    /** the input from the user is set here*/
    private String inputValue;
    
    /**if the input is in Arabic notation, it is saved here*/
    private int inputNumeric;
    
    /** the converted numeral is saved here*/
    private String convertedNumeral; 
    
    private boolean isArabic = true;
    
    
    public Model (String input){
        this.inputValue = input;
        processInput();
    }
    
    
    public void processInput(){
        if (isNumeric()){
            inputNumeric = Integer.parseInt(inputValue);
            validateArabicNotation();
        }
        else 
            validateRomanNotation();
    }
    /**
     * 
     * @param input
     * @return 
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
     * @param arabicNumeral represents the entered numeral in Arabic notation
     */
    public void validateArabicNotation(){
        if (inputNumeric < 1 || inputNumeric > 3999)
            System.out.println("number out of range");
        else {
            System.out.println("ok good");
        }
    }
    
    /**
     * Checks if the entered Roman numeral is in the range between I and MMMCMXCIX
     * @param RomanNumeral represents the entered numeral in Roman notation
     */
    public void validateRomanNotation(){
        System.out.println("reached Roman Validator");
    }
    
    public void saveEnteredValue (){
        
    //save it accordingly 
    }
    
    /**
     * 
     * @param Str 
     */
    public void convertToArabic(String Str) {
        
    }
    
    /**
     * 
     * @param num 
     */
    public void convertToRoman (int num){
        
    }
    
    /**
     * 
     * @return 
     */
    public String getOutput(){
        return this.convertedNumeral;
    }
    
    
    
    
    /*
    method to check 
    method to convert 
    getters 
    setters to pass the input 
    */
}



// data and methods 