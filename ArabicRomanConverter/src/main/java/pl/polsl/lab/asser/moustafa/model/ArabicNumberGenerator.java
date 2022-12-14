/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class for Roman to Arabic numerals conversion.
 * <p>
 * Stores a map containing the numeric values for each Roman Numeric character.
 *
 * @author asser.elfeki
 * @version 1.1
 */
public class ArabicNumberGenerator {

    /**
     * Map to retrieve numerical values for each accepted Roman Numeric character
     */
    private final Map<Character, Integer> values;

    /**
     * Default non-parametric Constructor of the class.
     * it creates the values for the values map
     */
    public ArabicNumberGenerator() {
        values = new HashMap<>();
        
        List<Character> literals = List.of('I', 'V', 'X', 'L', 'C', 'D', 'M');
        List<Integer> numerics = List.of(1,5,10,50,100,500,1000); 
        
      
        for(var num : numerics){
            values.put(literals.get(numerics.indexOf(num)), num);
        }
    }

    
   
    /**
     * Generates an Arabic numeral bases on a given validated
     * Roman numeric.
     * @param romanNumeric represents the Roman numeric entered by user
     * @return an integer representing the converted number in Arabic notation
     */
    public int generate(String romanNumeric) {      
        int res = 0;
     
        for (int i = 0; i < romanNumeric.length(); i++) {
            int s1 = values.get((char) romanNumeric.charAt(i));

            // Getting value of next symbol to apply substractive principle
            if (i + 1 < romanNumeric.length()) {
                int s2 = values.get((char)romanNumeric.charAt(i + 1));

                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
            }
        }

        return res;
    }

}
