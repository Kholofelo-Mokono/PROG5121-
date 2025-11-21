/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package part_three;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_Lab
 */
public class MessageReport {
     // Parallel arrays – REQUIRED for rubric
    public static String[] messageIDs = new String[100];
    public static String[] hashes = new String[100];
    public static String[] recipients = new String[100];
    public static String[] messages = new String[100];
    public static int count = 0; // number of loaded messages

    // Load messages from file
    public static void loadMessagesFromFile() {
        count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("messages.json"));
            String line;

            while ((line = br.readLine()) != null && count < 100) {

                // Extract fields manually (1st year style)
                String id = getValue(line, "MessageID");
                String hash = getValue(line, "MessageHash");
                String rec = getValue(line, "Recipient");
                String msg = getValue(line, "Message");

                messageIDs[count] = id;
                hashes[count] = hash;
                recipients[count] = rec;
                messages[count] = msg;

                count++;
            }

            br.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No messages found to load.");
        }
    }

    // Extract value from a JSON-like line
    public static String getValue(String line, String key) {
        try {
            int start = line.indexOf(key) + key.length() + 4;
            int end = line.indexOf("\"", start);
            return line.substring(start, end);
        } catch (Exception e) {
            return "";
        }
    }

    // Shows full message report
    public static void showReport() {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No messages found.");
            return;
        }

        String report = "";
        for (int i = 0; i < count; i++) {
            report += "Message " + (i + 1) + ":\n";
            report += "ID: " + messageIDs[i] + "\n";
            report += "Hash: " + hashes[i] + "\n";
            report += "Recipient: " + recipients[i] + "\n";
            report += "Message: " + messages[i] + "\n\n";
        }

        JOptionPane.showMessageDialog(null, report);
    }
}
