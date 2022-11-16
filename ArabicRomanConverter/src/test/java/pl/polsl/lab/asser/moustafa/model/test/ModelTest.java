/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.lab.asser.moustafa.model.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.lab.asser.moustafa.model.InvalidCharacterException;
import pl.polsl.lab.asser.moustafa.model.Model;
import pl.polsl.lab.asser.moustafa.view.AppWindow;

/**
 * Test class for the Model class.
 *
 * @author asser.elfeki
 */
public class ModelTest {

    private static Model modelInstance;
    public static AppWindow appWindowInstance;

    /**
     *
     */
    public ModelTest() {

    }

    /**
     *
     */
    @BeforeAll
    public static void setUpClass() {
        appWindowInstance = new AppWindow();
    }

    /**
     *
     */
    @BeforeEach
    public void setUp() {
        modelInstance = new Model(appWindowInstance);
    }

//    /**
//     * Test of processInput method, of class Model.
//     * correct situation : InvalidCharacterException is thrown
//     */
//    @DisplayName("test ProcessInput when InvalidCharacterException is thrown")
//    @Disabled
//    @Test 
//    public void testProcessInputExceptionThrown()  {
//        String input = "ac16";
//        assertThrows(InvalidCharacterException.class, () -> {
//            modelInstance.processInput(input);
//        });
//    }

//     /**
//     * Test of processInput method, of class Model.
//     * correct situation : InvalidCharacterException is NOT thrown
//     */
//    @DisplayName("")
//    @Disabled
//    @Test
//    public void testProcessInput()  {
//        String input = "X";
//        String output = "10";
//        try{
//            modelInstance.processInput(input);
//        }
//        catch (InvalidCharacterException ICE){
//            fail("Exception was thrown when it shouldn't have");
//        }
//        assertEquals(output, modelInstance.getOutput(), "Output was not generated");
//    }
    
    /**
     * Test of isAlphaNumeric method, of class Model.correct cases.
     * @param input 
     */
    @DisplayName("test isAlphaNumeric With Alpha Numeric Inputs")
    @ParameterizedTest
    @CsvSource({"ac13", "555", "asqsf", "xxx", "alphanumeric" })
    public void testIsAlphaNumericWithAlphaNumericInputs(String input){
        assertTrue(modelInstance.isAlphaNumeric(input), "Input was alphanumeric but method returned false");
    }
    
    /**
     * Test of isAlphaNumeric method, of class Model.
     * incorrect cases. 
     * @param input non alphanumeric strings passed to the method.
     */
    @DisplayName("test isAlphaNumeric With Non Alpha Numeric Inputs")
    @ParameterizedTest
    @CsvSource({"a c13 ", "55.45", "as-qsf", "xx//x", ".alphanumeric?" })
    public void testIsAlphaNumericWithNonAlphaNumericInput(String input){
        assertFalse(modelInstance.isAlphaNumeric(input), "Input was not alphanumeric but method returned true");
    }
    
    /**
     * Test of isRoman method, of class Model.
     * correct cases
     * @param input strings with only roman characters.
     */
    @DisplayName("test isRoman With Roman characters only in Inputs")
    @ParameterizedTest
    @CsvSource({"XXIV", "LCMXVI", "IIIIII", "II", "IV", "iv", "iIVLxcM" })
    public void testIsRomanWithRomanInput(String input) {
        assertTrue(modelInstance.isRoman(input), "Input contains Roman characters only but method returned false");
    }

      /**
     * Test of isRoman method, of class Model.
     * correct cases
     * @param input strings with only roman characters.
     */
    @DisplayName("test isRoman With Non-Roman characters in Inputs")
    @ParameterizedTest
    @CsvSource({"jisdf", "lsaf2", "II1IIII", "I1I", "I5V" })
    public void testIsRomanWithNonRomanInput(String input) {
        assertFalse(modelInstance.isRoman(input), "Input contains non-Roman characters but method returned true");
    }
    
    /**
     * Test of isNumeric method, of class Model.
     * correct cases
     * @param input strings with only numeric characters.
     */
    @DisplayName("test isNumeric With Numeric only input")
    @ParameterizedTest
    @ValueSource(strings = {"5", "6", "71824234231", "000"})
    public void testIsNumericWithNumericinput(String input) {
        assertTrue(modelInstance.isNumeric(input), "Input contained only numeric characters but method returned false");
    }

    /**
     * Test of isNumeric method, of class Model.
     * incorrect cases
     * @param input strings with non-numeric characters.
     */
    @DisplayName("test isNumeric With non-Numeric input")
    @ParameterizedTest
    @ValueSource(strings = {"5a", "6/", "718f24234231", " 0004","5.4" ,"5 3" , "", "  "})
    public void testIsNumericWithNonNumericinput(String input) {
        assertFalse(modelInstance.isNumeric(input), "Input contained non numeric characters but method returned true");
    }
    
    /**
     * Test of validateArabicNotation method, of class Model.
     * correct case
     * @param input string containing a number value from 1 to 3999
     * @param output string containing the converted number
     */
    @DisplayName("test ValidateArabicNotation With Valid Number")
    @ParameterizedTest
    @CsvSource({"1,I", "5,V", "10,X", "13,XIII", "3999,MMMCMXCIX"})
    public void testValidateArabicNotationWithValidNumber(String input, String output) {
        try{
            modelInstance.validateArabicNotation(input);
        }
        catch(IllegalArgumentException IAE){
            fail("Exception was thrown when it shouldn't have");
        }
        assertEquals(output, modelInstance.getOutput(), "something wrong");
    }
    
    /**
     * Test of validateArabicNotation method, of class Model.
     * incorrect case
     * @param input string containing a number value out of the range from 1 to 3999
     */
    @DisplayName("test ValidateArabicNotation With invalid Number")
    @ParameterizedTest
    @ValueSource(strings = {"0", "4000", "89236782364", "-15"})
    public void testValidateArabicNotationWithInvalidNumber(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            modelInstance.validateArabicNotation(input);
        });
    }

    /**
     * Test of validateRomanNotation method, of class Model.
     * correct case
     * @param input correct numeric values in Roman notation
     * @param output same numeric values in Arabic notation
     */
    @DisplayName("test testValidateRomanNotation With valid input")
    @ParameterizedTest
    @CsvSource({"I,1", "III,3", "IX,9", "MMMCMXCIX,3999", "DLXIV,564", "ii,2", "xi,11", "Mm,2000"})
    public void testValidateRomanNotationWithValidInput(String input, String output) {
       try{
           modelInstance.validateRomanNotation(input);
       }
       catch(IllegalArgumentException IAE){
           fail("Exception was thrown when it shouldn't have");
       }
       assertEquals(output, modelInstance.getOutput(), "something Wrong!");
    }
    
    /**
     * Test of validateRomanNotation method, of class Model.incorrect case
     * @param input correct numeric values in Roman notation
     */
    @DisplayName("test testValidateRomanNotation With invalid input")
    @ParameterizedTest
    @ValueSource(strings = {"IIII", "VIIII", "XXXX", "LXXXX", "CCCC", "DCCCC"})
    public void testValidateRomanNotationWithInvalidInput(String input) {
       assertThrows(IllegalArgumentException.class, ()->{
          modelInstance.validateRomanNotation(input);
       });
    }

}
