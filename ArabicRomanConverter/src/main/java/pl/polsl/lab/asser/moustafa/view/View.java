/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.view;

import java.util.Scanner;

/**
 * A class that handles the UI in the console
 * It prompts the user to enter a numeral (in Arabic or Roman notations) and converts it and displays the numeral in the other notation
 * 
 * @author asser.elfeki
 */
public class View {
    
    private Scanner scanner;
    
    /**
     * default constructor. It initiates the Scanner object and calls the promptUser func.
     */
    public View(){
       scanner = new Scanner(System.in);
       promptUser();
    }

    /**
     * Prompts user to enter a number 
     */
    public void promptUser (){
        System.out.println("Enter a number then press Enter");
    }
    
    /**
     * Reads user's input from standard stream 
     * @return a String representing the entered numeral 
     */
    public String read() {
        return scanner.next();
    }
    
    /**
     * outputs the converted numeral to the standard output stream
     * @param convertedNum is the numeral after being processed and converted from one notation to the other. 
     */
    public void outputConvertedNumber(String convertedNum){
        System.out.println("the converted number is: " + convertedNum);
    }
}
