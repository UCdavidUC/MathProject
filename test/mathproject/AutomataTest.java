/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathproject;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class AutomataTest {
    
    public AutomataTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getEstados method, of class Automata.
     */
    @Test
    public void testGetEstados() {
        System.out.println("getEstados");
        Automata instance = new Automata();
        List<Estado> expResult = null;
        List<Estado> result = instance.getEstados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstados method, of class Automata.
     */
    @Test
    public void testSetEstados() {
        System.out.println("setEstados");
        List<Estado> estados = null;
        Automata instance = new Automata();
        instance.setEstados(estados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSimbolos method, of class Automata.
     */
    @Test
    public void testGetSimbolos() {
        System.out.println("getSimbolos");
        Automata instance = new Automata();
        List<Simbolo> expResult = null;
        List<Simbolo> result = instance.getSimbolos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSimbolos method, of class Automata.
     */
    @Test
    public void testSetSimbolos() {
        System.out.println("setSimbolos");
        List<Simbolo> simbolos = null;
        Automata instance = new Automata();
        instance.setSimbolos(simbolos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadoInicio method, of class Automata.
     */
    @Test
    public void testGetEstadoInicio() {
        System.out.println("getEstadoInicio");
        Automata instance = new Automata();
        Estado expResult = null;
        Estado result = instance.getEstadoInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoInicio method, of class Automata.
     */
    @Test
    public void testSetEstadoInicio() {
        System.out.println("setEstadoInicio");
        Estado estadoInicio = null;
        Automata instance = new Automata();
        instance.setEstadoInicio(estadoInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadosFinales method, of class Automata.
     */
    @Test
    public void testGetEstadosFinales() {
        System.out.println("getEstadosFinales");
        Automata instance = new Automata();
        List<Estado> expResult = null;
        List<Estado> result = instance.getEstadosFinales();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadosFinales method, of class Automata.
     */
    @Test
    public void testSetEstadosFinales() {
        System.out.println("setEstadosFinales");
        List<Estado> estadosFinales = null;
        Automata instance = new Automata();
        instance.setEstadosFinales(estadosFinales);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransiciones method, of class Automata.
     */
    @Test
    public void testGetTransiciones() {
        System.out.println("getTransiciones");
        Automata instance = new Automata();
        List<Transition> expResult = null;
        List<Transition> result = instance.getTransiciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTransiciones method, of class Automata.
     */
    @Test
    public void testSetTransiciones() {
        System.out.println("setTransiciones");
        List<Transition> transiciones = null;
        Automata instance = new Automata();
        instance.setTransiciones(transiciones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNFAL method, of class Automata.
     */
    @Test
    public void testIsNFAL() {
        System.out.println("isNFAL");
        Automata instance = new Automata();
        boolean expResult = false;
        boolean result = instance.isNFAL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDFA method, of class Automata.
     */
    @Test
    public void testIsDFA() {
        System.out.println("isDFA");
        Automata instance = new Automata();
        boolean expResult = false;
        boolean result = instance.isDFA();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of execute method, of class Automata.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Automata instance = new Automata();
        instance.execute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateNFA method, of class Automata.
     */
    @Test
    public void testCalculateNFA() {
        System.out.println("calculateNFA");
        Automata instance = new Automata();
        Automata expResult = null;
        Automata result = instance.calculateNFA();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateDFA method, of class Automata.
     */
    @Test
    public void testCalculateDFA() {
        System.out.println("calculateDFA");
        Automata instance = new Automata();
        Automata expResult = null;
        Automata result = instance.calculateDFA();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateMinimized method, of class Automata.
     */
    @Test
    public void testCalculateMinimized() {
        System.out.println("calculateMinimized");
        Automata instance = new Automata();
        Automata expResult = null;
        Automata result = instance.calculateMinimized();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printAutomate method, of class Automata.
     */
    @Test
    public void testPrintAutomate() {
        System.out.println("printAutomate");
        String title = "";
        Automata instance = new Automata();
        instance.printAutomate(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lclosure method, of class Automata.
     */
    @Test
    public void testLclosure() {
        System.out.println("lclosure");
        Transition transicion = null;
        Automata instance = new Automata();
        List<Estado> expResult = null;
        List<Estado> result = instance.lclosure(transicion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
