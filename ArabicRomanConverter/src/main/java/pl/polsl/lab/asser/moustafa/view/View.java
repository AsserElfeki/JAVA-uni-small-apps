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
    
    private Scanner scanner;
    
    public View(){
       scanner = new Scanner(System.in);
       promptUser();
    }

    public void promptUser (){
        System.out.println("Enter a number then press Enter");
    }
    
    public String read() {
        return scanner.next();
    }
    
    public void outputConvertedNumber(String convertedNum){
        System.out.println("the converted number is: " + convertedNum);
    }
}
