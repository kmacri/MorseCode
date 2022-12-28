package edu.merrimack.fop2.morsecode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Project #5
 *  
 * @author Ed Grzyb
 */
public class MorseEncoderTest {
    
    public MorseEncoderTest() {
    }

    @Test
    public void testEncodeLetter() {
        System.out.println("encodeLetter");
        char letter = 'S';
        MorseEncoder instance = new MorseEncoder();
        String expResult = "...";
        String result = instance.encodeLetter(letter);
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testEncodePhrase() throws Exception {
        System.out.println("encodePhrase");
        String phrase = "SOS";
        MorseEncoder instance = new MorseEncoder();
        String expResult = "...|---|...";
        String result = instance.encodePhrase(phrase);
        assertEquals(expResult, result);        
    }    
    
}
