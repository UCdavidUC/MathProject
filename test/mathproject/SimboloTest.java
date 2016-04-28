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
public class SimboloTest {
    
    public SimboloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getSimbolo method, of class Simbolo.
     */
    @Test
    public void testGetSimbolo() {
        System.out.println("getSimbolo");
        Simbolo instance = new Simbolo();
        char expResult = ' ';
        char result = instance.getSimbolo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSimbolo method, of class Simbolo.
     */
    @Test
    public void testSetSimbolo() {
        System.out.println("setSimbolo");
        char simbolo = ' ';
        Simbolo instance = new Simbolo();
        instance.setSimbolo(simbolo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printSimbolo method, of class Simbolo.
     */
    @Test
    public void testPrintSimbolo() {
        System.out.println("printSimbolo");
        Simbolo instance = new Simbolo();
        instance.printSimbolo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
