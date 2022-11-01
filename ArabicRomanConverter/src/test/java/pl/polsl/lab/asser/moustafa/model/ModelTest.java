/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author asser.elfeki
 */
public class ModelTest {
    
    public ModelTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of processInput method, of class Model.
     */
    @Test
    public void testProcessInput() throws Exception {
        System.out.println("processInput");
        String input = "";
        Model instance = null;
        instance.processInput(input);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlphaNumeric method, of class Model.
     */
    @Test
    public void testIsAlphaNumeric() {
        System.out.println("isAlphaNumeric");
        String input = "";
        Model instance = null;
        boolean expResult = false;
        boolean result = instance.isAlphaNumeric(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRoman method, of class Model.
     */
    @Test
    public void testIsRoman() {
        System.out.println("isRoman");
        String input = "";
        Model instance = null;
        boolean expResult = false;
        boolean result = instance.isRoman(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNumeric method, of class Model.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric");
        String input = "";
        Model instance = null;
        boolean expResult = false;
        boolean result = instance.isNumeric(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateArabicNotation method, of class Model.
     */
    @Test
    public void testValidateArabicNotation() {
        System.out.println("validateArabicNotation");
        String input = "";
        Model instance = null;
        instance.validateArabicNotation(input);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateRomanNotation method, of class Model.
     */
    @Test
    public void testValidateRomanNotation() {
        System.out.println("validateRomanNotation");
        String input = "";
        Model instance = null;
        instance.validateRomanNotation(input);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

  
    
}
