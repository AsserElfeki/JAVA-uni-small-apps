
package pl.polsl.lab.asser.moustafa.model.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import pl.polsl.lab.asser.moustafa.model.ArabicNumberGenerator;

/**
 * Test class for the ArabicNumberGenerator class.
 * @author asser.elfeki
 */
public class ArabicNumberGeneratorTest {
    private static ArabicNumberGenerator instance;
    
    /**
     *
     */
    public ArabicNumberGeneratorTest(){       
    }
    
    /**
     *
     * @throws Exception
     */
    @BeforeAll
    public static void setUpClass() throws Exception {
        instance = new ArabicNumberGenerator();

    }

    /**
     * Test of generate method, of class ArabicNumberGenerator.
     * correct situation
     */
    @Test
    @DisplayName("Test if \"X\" Generates 10")
    public void X_ShouldGenerate10() {
        String romanNumeric = "X";
        int expResult = 10;
        int result = instance.generate(romanNumeric);
        assertEquals(expResult, result, "Output Arabic number does not match input Roman number");      
    }
    
     /**
     * Test of generate method, of class ArabicNumberGenerator.
     * correct situation
     */
    @Test
    @DisplayName("Test if \"IV\" Generates 4")
    public void V_ShouldGenerateFour() {
        String romanNumeric = "IV";
        int expResult = 4;
        int result = instance.generate(romanNumeric);
        assertEquals(expResult, result, "Output Arabic number does not match input Roman number");      
    }
    
     /**
     * Test of generate method, of class ArabicNumberGenerator.
     * correct situation
     */
    @Test
    @DisplayName("Test if \"CLXXXVI\" Generates 186")
    public void CLXXXVI_ShouldGenerate186() {
        String romanNumeric = "CLXXXVI";
        int expResult = 186;
        int result = instance.generate(romanNumeric);
        assertEquals(expResult, result, "Output Arabic number does not match input Roman number");      
    }
    
     /**
     * Test of generate method, of class ArabicNumberGenerator.
     * correct situation
     */
    @Test
    @DisplayName("Test if \"MMXXII\" Generates 2022")
    public void MMXXII_ShouldGenerate2022() {
        String romanNumeric = "MMXXII";
        int expResult = 2022;
        int result = instance.generate(romanNumeric);
        assertEquals(expResult, result, "Output Arabic number does not match input Roman number");      
    }
    
     /**
     * Test of generate method, of class ArabicNumberGenerator.
     * incorrect situation
     */
    @Test
    @DisplayName("Test if 100 does not Generate \"X\" ")
    public void X_ShouldNotGenerate100() {
        System.out.println("generate");
        String romanNumeric = "X";
        int expResult = 100;
        int result = instance.generate(romanNumeric);
        assertNotEquals(expResult, result, "Output Arabic number does not match input Roman number");      
    }
    
     /**
     * Test of generate method, of class ArabicNumberGenerator.
     * border situation happens when generate() is called with input "IIII"
     * which is an impossible situation because the validation methods make sure user follows the Subtractive principle
     * so "IIII" should be written as "IV". if the user inputs "IIII" it will not be accepted.
     */
    @Test
    @DisplayName("Test if \"IIII\" does Generate 4 ")
    public void IIII_CouldGenerate4() {
        System.out.println("generate");
        String romanNumeric = "IIII";
        int expResult = instance.generate("IV");
        int result = instance.generate(romanNumeric);
        assertEquals(expResult, result, "Output Roman number does not match input Arabic number");      
    }
}
