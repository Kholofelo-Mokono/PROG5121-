/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package part_two;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_Lab
 */
public class Message {
    // total sent messages 
    static int messageCount = 0; 
    static ArrayList<String> sentMessages = new ArrayList<>();

    // Enter 10-digit message ID
    public static String generateMessageID() {
        Random rand = new Random();
        long num = (long)(rand.nextDouble() * 1_000_000_0000L); 
        return String.format("%010d", num);
    }

    // Check message ID length
    public static boolean checkMessageID(String messageID) {
        return messageID.length() <= 10;
    }

    // Check recipient number
    public static boolean checkRecipientCell(String recipient) {
        return recipient.startsWith("+27") && recipient.length() <= 12;
    }

    // Check message length
    public static boolean checkMessageLength(String message) {
        return message.length() <= 250;
    }

    // Create message hash
    public static String createMessageHash(String messageID, int msgNumber, String message) {
        String[] words = message.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String hash = messageID.substring(0, 2) + ":" + msgNumber + ":" + firstWord + lastWord;
        return hash.toUpperCase();
    }

    // Send, store, or disregard message
    public static void sendMessage(String messageID, int msgNumber, String recipient, String message, boolean storeToFile) {
        String messageHash = createMessageHash(messageID, msgNumber, message);

        // Full message details
        String fullMessage = "{\n" +
                "  \"MessageID\": \"" + messageID + "\",\n" +
                "  \"MessageHash\": \"" + messageHash + "\",\n" +
                "  \"Recipient\": \"" + recipient + "\",\n" +
                "  \"Message\": \"" + message + "\"\n" +
                "}";

        // Prompt user for action
        String[] options = {"Send Message", "Disregard Message", "Store Message"};
        int choice = JOptionPane.showOptionDialog(null, fullMessage,
                "Choose an action", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        switch (choice) {
            // Send Message
            case 0: 
                JOptionPane.showMessageDialog(null, "Message successfully sent.");
                sentMessages.add(fullMessage);
                messageCount++;
                if (storeToFile) storeMessageToFile(fullMessage);
                break;
             
             // Disregard Message  
            case 1: 
                JOptionPane.showMessageDialog(null, "Press 0 to delete message.");
                break;
                
            // Store Message
            case 2: 
                JOptionPane.showMessageDialog(null, "Message successfully stored.");
                sentMessages.add(fullMessage);
                if (storeToFile) storeMessageToFile(fullMessage);
                break;
            default:
                JOptionPane.showMessageDialog(null, "No valid option selected.");
        }
    }

    // Return total messages sent
    public static int returnTotalMessages() {
        return messageCount;
    }

    // Store message to JSON-like text file
    public static void storeMessageToFile(String message) {
        try {
            FileWriter writer = new FileWriter("messages.json", true);
            writer.write(message + "\n");
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving message to file.");
        }
    }

    // Print all messages (coming soon)
    public static void printMessages() {
        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages have been sent yet.");
        } else {
            String allMessages = "";
            for (String msg : sentMessages) {
                allMessages += msg + "\n\n";
            }
            JOptionPane.showMessageDialog(null, allMessages);
        }
    }
}
