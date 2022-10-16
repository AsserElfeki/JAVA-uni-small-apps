/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.model;

/**
 * Own exception class for handling invalid user inputs.
 * <p>
 * It inherits from the <code>class Exception</code> so we can use all its functionality.
 * for 
 * @author asser.elfeki
 * @version 1.0
 */

public class InvalidCharacterException extends Exception {
    
    
    /**
     * Non-parameter constructor
     */
    public InvalidCharacterException(){
            
    }
    
    /**
     * Exception class constructor with one argument.
     * it calls its super class and sets its <code>message</code> field with a given message.
     * @param message the message of this instance of the exception.
     */
    public InvalidCharacterException(String message) {
        super(message);
    }
}
