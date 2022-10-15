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
 * @version 1.1
 */
public class View {
    
    private Scanner scanner;
    
    /**
     * default constructor. It initiates the Scanner object and calls the promptUser func.
     */
    public View(){
       scanner = new Scanner(System.in);
    }

    /**
     * Prompts user to enter a number 
     */
    public void promptUser (){
        System.out.print("===========================" 
                + "\nEnter a number then press Enter: ");
    }
    
    /**
     * Reads user's input from standard stream 
     * @return a String representing the entered numeral 
     */
    public String read() {
        return scanner.nextLine();
    }
    
    /**
     * outputs the converted numeral to the standard output stream
     * @param convertedNum is the numeral after being processed and converted from one notation to the other. 
     */
    public void outputConvertedNumber(String convertedNum){
        System.out.println("\nthe converted number is: " + convertedNum);
    }
    
    public void logExceptionToConsole (String ExceptionMessage){
        System.err.println(ExceptionMessage);
    }
    
    public void logMessageToConsole (String message){
        System.out.println(message);        
    }
    
    public void printHelp(){
            System.out.println("DIFFERENT MODES OF PROGRAM OPERATION:\n"
            +"\n1- To convert from Arabic to Roman : enter parameter : '-a' then the number"
            +"\nexample: -a 150\n"
            +"\n2- To convert from Roman to Arabic : enter parameter : -r"
            +"\nexample: -R XXI\n"
            +"\n3- you can run the program without any parameters and it will later ask you to enter a number"
            +"\nand will figure out the notation and convert it automatically");
        }
}
