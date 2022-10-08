/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.model;

import java.util.*;

/**
 *Class for Roman to Arabic numerals conversion
 * @author asser.elfeki
 * @version 1.1
 */
public class ArabicNumberGenerator {
    
    /** Map to retrieve numerical values for each accepted Roman Numeric character*/
    private Map<Character, Integer> values;
    /**
     * Constructor of the class 
     * it creates the values for the values map
     */
    public ArabicNumberGenerator() {  
        values = new HashMap<Character,Integer>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
    }
    
 
    /**
     * function that generates an Arabic numeral bases on a given validated Roman numeric
     * @param romanNumeric represents the Roman numeric entered by user 
     * @return an integer representing the converted number in Arabic notation
     */
    int generate(String romanNumeric)
    {
        int res = 0;
 
        for (int i = 0; i < romanNumeric.length(); i++) {
            int s1 = values.get((char)romanNumeric.charAt(i));
 
            // Getting value of next symbol to apply substractive principle
            if (i + 1 < romanNumeric.length()) {
                int s2 = values.get(romanNumeric.charAt(i + 1));
 
                if (s1 >= s2) {
                    res = res + s1;
                }
                else {
                    res = res + s2 - s1;
                    i++;
                }
            }
            else {
                res = res + s1;
            }
        }
 
        return res;
    }
    
}
