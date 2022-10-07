/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.model;

/**
 * Class for Arabic to Roman numerals conversion
 * 
 * @author asser.elfeki
 */
public class RomanNumeralGenerator {
    //blank at the beginning so the index of the first RN is 1 not 0
    /** array of strings representing the "THOUSANDS" --> blank , 1000, 2000, 3000 */
    private static final String[] RN_M = {"", "M", "MM", "MMM"};
    
    /** array of strings representing the "HUNDREDS" --> blank , 100, 200, 300, ... , 900 */
    private static final String[] RN_C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    
    /** array of strings representing the "TENS" --> blank , 10, 20, 30, ... , 90 */
    private static final String[] RN_X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    
    /** array of strings representing the "ONES" --> blank , 1, 2, 3, ... , 9 */
    private static final String[] RN_I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    /**
     * 
     * @param number
     * @return 
     */
    public String generate(int number) {
        return new StringBuilder()
                .append(RN_M[number / 1000])
                .append(RN_C[number % 1000 / 100])
                .append(RN_X[number % 100 / 10])
                .append(RN_I[number % 10])
                .toString();
    }
}