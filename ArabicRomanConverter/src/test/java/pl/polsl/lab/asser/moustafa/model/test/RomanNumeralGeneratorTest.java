/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.model.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import pl.polsl.lab.asser.moustafa.model.RomanNumeralGenerator;

/**
 * Test class for the RomanNumeralGenerator class.
 * @author asser.elfeki
 */
public class RomanNumeralGeneratorTest {
    
    private static RomanNumeralGenerator instance;

    /**
     *
     */
    public RomanNumeralGeneratorTest() {
    }
    
    /**
     *
     */
    @BeforeAll
    public static void setUpClass() {
        instance = new RomanNumeralGenerator();
    }

    /**
     * Test of generate method, of class RomanNumeralGenerator.
     * correct situation
     */
    @Test
    public void fiveShouldGenerateV() {
        int number = 5;
        String expResult = "V";
        String result = instance.generate(number);
        assertEquals(expResult, result, "Output Roman numeric does not match the input Arabic Numeral");        
    }
    
     /**
     * Test of generate method, of class RomanNumeralGenerator.
     * border situation
     */
    @Test
    @DisplayName("49 should generate \"XLIX\"")
    public void fourtyNineShouldGenerateXLIX() {
        int number = 49;
        String expResult = "XLIX";
        String result = instance.generate(number);
        assertEquals(expResult, result, "Output Roman numeric does not match the input Arabic Numeral");        
    }
    
    /**
     * Test of generate method, of class RomanNumeralGenerator.
     * incorrect situation
     */
    @Test
    @DisplayName("4 should NOT generate \"IIII\"")
    public void fourShouldNotGenerateIV() {
        int number = 4;
        String expResult = "IIII";
        String result = instance.generate(number);
        assertNotEquals(expResult, result, "Output Roman numeric does not match the input Arabic Numeral");        
    }
}
