/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package part_three;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author RC_Student_Lab
 */
public class MessageReportNGTest {
    
    public MessageReportNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of loadMessagesFromFile method, of class MessageReport.
     */
    @Test
    public void testLoadMessagesFromFile() {
        System.out.println("loadMessagesFromFile");
        MessageReport.loadMessagesFromFile();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class MessageReport.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        String line = "false";
        String key = "";
        String expResult = "";
        String result = MessageReport.getValue(line, key);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of showReport method, of class MessageReport.
     */
    @Test
    public void testShowReport() {
        System.out.println("showReport");
        MessageReport.showReport();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
