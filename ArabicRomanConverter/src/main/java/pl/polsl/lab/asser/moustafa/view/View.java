/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.view;

import java.util.Scanner;

/**
 *
 * @author asser.elfeki
 */
public class View {
    
    private int enteredArabic; 
    private String enteredRoman;
    
    
    public static void read(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number ");
        String login = scanner.next();
        System.out.println("Hello " + login);
    }
}
