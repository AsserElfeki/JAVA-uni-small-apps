/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Stream;
/**
 * Class for Arabic to Roman numerals conversion.
 * <p>
 * Stores lists of String that are variations of accepted Roman characters.
 * Handles generating a Roman number based on an input integer.
 *
 * @author asser.elfeki
 * @version 1.1
 */
public class RomanNumeralGenerator {

    /**
     * Enum type representing the Characters used in Roman notation.
     * Four different instances, for different values of each multiple of 10 up to Thousands
     */
    public enum RomanCharacters {
        THOUSANDS("", "M", "MM", "MMM"),
        HUNDREDS ("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"),
        TENS     ("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"),
        ONES     ("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX");

        /**
         * List containing the Roman Characters used in each unit. 
         * for example Hundreds contain "C", "CC", "CCC", "CD", ...etc
         */
        private List<String> romanLiterals; 
        
        /**
         * private constructor.
         * takes var args and unpacks them to instantiate the correct number of String fields in an instance
         * @param literals 
         */
        RomanCharacters(String... literals){
            Stream<String> stream;
            stream = Stream.of(literals);
            
            romanLiterals = new ArrayList <String> (literals.length );
            stream.forEach(s -> romanLiterals.add(s));
        }
        
        /**
         * Method for retrieving values from Roman literals Lists according to their index/value
         * @param index index of the literal in the list
         * @return String representing the desired roman numeral
         */
        private String get(int index){
            return this.romanLiterals.get(index);
        }
    }
    
    
    /**
     * Default non-parametric constructor.
     */
    public RomanNumeralGenerator() {
    }

    /**
     * Generates a roman Number based on a given integer.
     *
     * @param number is the Arabic number entered by user, after being validated
     * @return a string representing the converted number
     */
    public String generate(int number) {  
        return new StringBuilder()
                .append(RomanCharacters.THOUSANDS.get(number / 1000))
                .append(RomanCharacters.HUNDREDS.get(number % 1000 / 100))
                .append(RomanCharacters.TENS.get(number % 100 / 10))
                .append(RomanCharacters.ONES.get(number % 10))
                .toString();
    }

}
