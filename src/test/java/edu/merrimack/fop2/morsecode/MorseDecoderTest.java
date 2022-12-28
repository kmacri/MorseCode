package edu.merrimack.fop2.morsecode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ed
 */
public class MorseDecoderTest {
    
    public MorseDecoderTest() {
    }

    
    @Test
    public void testCustomAlphabet() throws Exception {
        System.out.println("testCustomAlphabet");
        char[] letters = {'A', 'B', 'C', 'D'};
        String[] patterns = {".", "--", "...", "----"};
        MorseDecoder decoder = new MorseDecoder();
        decoder.setCustomAlphabet(letters, patterns);
        decoder.decodeLetter("...");
        assertEquals('C', decoder.decodeLetter("..."));
        assertEquals("CAB", decoder.decodePhrase("...|.|--"));
    }
    
    @Test
    public void testTraverseTreePreorder() throws Exception {
        System.out.println("testTraverseTreePreorder");
        MorseDecoder decoder = new MorseDecoder();
        assertEquals("$EISHVUFARLWPJTNDBXKCYMGZQO", decoder.traverseTreePreorder());        
        System.out.println(decoder.traverseTreePreorder());
    } 
    
    @Test
    public void testTraverseTreeInorder() throws Exception {
        System.out.println("testTraverseTreePreorder");
        MorseDecoder decoder = new MorseDecoder();
        assertEquals("HSVIFUELRAPWJ$BDXNCKYTZGQMO", decoder.traverseTreeInorder());        
        System.out.println(decoder.traverseTreeInorder());
    } 

        @Test
    public void testTraverseTreePostorder() throws Exception {
        System.out.println("testTraverseTreePreorder");
        MorseDecoder decoder = new MorseDecoder();
        assertEquals("HVSFUILRPJWAEBXDCYKNZQGOMT$", decoder.traverseTreePostorder());        
        System.out.println(decoder.traverseTreePostorder());
    } 

    @Test
    public void testDeterminePhrase() throws Exception {
        System.out.println("determinePhrase");
        String pattern = "...|---|...";
        MorseDecoder instance = new MorseDecoder();
        String expResult = "SOS";
        String result = instance.decodePhrase(pattern);
        assertEquals(expResult, result);
    }

    @Test
    public void testDetermineLetter() throws Exception {
        String pattern = "--";
        MorseDecoder instance = new MorseDecoder();
        char expResult = 'M';
        char result = instance.decodeLetter(pattern);
        assertEquals(expResult, result);
    }
    
}
