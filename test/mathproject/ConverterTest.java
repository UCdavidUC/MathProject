/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathproject;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class ConverterTest {
    
    public ConverterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of convertToNFA method, of class Converter.
     */
    @Test
    public void testConvertToNFA() {
        System.out.println("convertToNFA");
        Automata nfal = null;
        Converter instance = new ConverterImpl();
        Automata expResult = null;
        Automata result = instance.convertToNFA(nfal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertToDFA method, of class Converter.
     */
    @Test
    public void testConvertToDFA() {
        System.out.println("convertToDFA");
        Automata nfa = null;
        Converter instance = new ConverterImpl();
        Automata expResult = null;
        Automata result = instance.convertToDFA(nfa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ConverterImpl extends Converter {
    }
    
}
