/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package part_two;

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
public class MessageNGTest {
    
    public MessageNGTest() {
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
     * Test of generateMessageID method, of class Message.
     */
    @Test
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");
        String expResult = "";
        String result = Message.generateMessageID();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        String messageID = "";
        boolean expResult = false;
        boolean result = Message.checkMessageID(messageID);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String recipient = "";
        boolean expResult = false;
        boolean result = Message.checkRecipientCell(recipient);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageLength method, of class Message.
     */
    @Test
    public void testCheckMessageLength() {
        System.out.println("checkMessageLength");
        String message = "";
        boolean expResult = false;
        boolean result = Message.checkMessageLength(message);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("");
        String messageID = "";
        int msgNumber = 0;
        String message = "";
        String expResult = "";
        String result = Message.createMessageHash(messageID, msgNumber, message);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class Message.
     */
    @Test
    public void testSendMessage() {
        System.out.println("");
        String messageID = "";
        int msgNumber = 0;
        String recipient = "";
        String message = "";
        boolean storeToFile = false;
        Message.sendMessage(messageID, msgNumber, recipient, message, storeToFile);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessages method, of class Message.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int expResult = 0;
        int result = Message.returnTotalMessages();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessageToFile method, of class Message.
     */
    @Test
    public void testStoreMessageToFile() {
        System.out.println("storeMessageToFile");
        String message = "hello";
        Message.storeMessageToFile(message);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessages method, of class Message.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        Message.printMessages();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
