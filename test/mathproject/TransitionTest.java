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
public class TransitionTest {
    
    public TransitionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getEstadosInicio method, of class Transition.
     */
    @Test
    public void testGetEstadosInicio() {
        System.out.println("getEstadosInicio");
        Transition instance = new Transition();
        List<Estado> expResult = null;
        List<Estado> result = instance.getEstadosInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadosInicio method, of class Transition.
     */
    @Test
    public void testSetEstadosInicio() {
        System.out.println("setEstadosInicio");
        List<Estado> estado = null;
        Transition instance = new Transition();
        instance.setEstadosInicio(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSimbolo method, of class Transition.
     */
    @Test
    public void testGetSimbolo() {
        System.out.println("getSimbolo");
        Transition instance = new Transition();
        char expResult = ' ';
        char result = instance.getSimbolo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSimbolo method, of class Transition.
     */
    @Test
    public void testSetSimbolo() {
        System.out.println("setSimbolo");
        char simbolo = ' ';
        Transition instance = new Transition();
        instance.setSimbolo(simbolo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadosLlegada method, of class Transition.
     */
    @Test
    public void testGetEstadosLlegada() {
        System.out.println("getEstadosLlegada");
        Transition instance = new Transition();
        List<Estado> expResult = null;
        List<Estado> result = instance.getEstadosLlegada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadosLlegada method, of class Transition.
     */
    @Test
    public void testSetEstadosLlegada() {
        System.out.println("setEstadosLlegada");
        List<Estado> estadosLlegada = null;
        Transition instance = new Transition();
        instance.setEstadosLlegada(estadosLlegada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEstadoInicio method, of class Transition.
     */
    @Test
    public void testAddEstadoInicio() {
        System.out.println("addEstadoInicio");
        String estadoInicio = "";
        Transition instance = new Transition();
        instance.addEstadoInicio(estadoInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEstadoLlegada method, of class Transition.
     */
    @Test
    public void testAddEstadoLlegada() {
        System.out.println("addEstadoLlegada");
        String estadoLlegada = "";
        Transition instance = new Transition();
        instance.addEstadoLlegada(estadoLlegada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printTransition method, of class Transition.
     */
    @Test
    public void testPrintTransition() {
        System.out.println("printTransition");
        Transition instance = new Transition();
        instance.printTransition();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
