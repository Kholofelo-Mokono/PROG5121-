/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package part_two;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_Lab
 */
public class Part_Two {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validation validation = new Validation();
        
        // Registration: Get user's name and surname
        String firstName = JOptionPane.showInputDialog("Enter your first name: ");
        String lastName = JOptionPane.showInputDialog("Enter your last name: "); 
        
        // Registration: Get username  
        String username = JOptionPane.showInputDialog("Create a username (must contain '_' and be less or equal to 5 characters long:");
        if (validation.checkUsername(username)) {
            JOptionPane.showMessageDialog(null, "Username is successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that it contains an '_' and is no more that five characters in length.");
        }
        
        // Registration: Get password
        String password = JOptionPane.showInputDialog("Create a password (8 or more characters, 1 captial, 1 number, 1 special character):");
        if (validation.checkPassword(password)) {
            JOptionPane.showMessageDialog(null, "Password is successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that it contains at least 8 characters, a capital letter, a number and a special character.");
        }
        
        // Registration: Get cell phone number
        String cellPhone = JOptionPane.showInputDialog("Enter your cell phone number (must start with '+27' and be 10 digitis long):");
        if (validation.checkCellPhoneNumber(cellPhone)) {
            JOptionPane.showMessageDialog(null, "Cell phone number is successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Cell phone number is not correctly formatted or does not contain international code.");
        }
        
        // Login  
        String loginUser = JOptionPane.showInputDialog("Login - Enter your username:");
        String loginPass  = JOptionPane.showInputDialog("Login - enter your password:");
        
        if (validation.checkLogin(loginUser, loginPass, username, password)) {
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + ", " + " it is nice to see you again.");
        } else {
            JOptionPane.showMessageDialog(null, "Username or password is incorrect, please try again.");
        }
        
        // Welcome Message
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");
        
        // Login
        String userName = JOptionPane.showInputDialog("Enter your username to login.");
        String Password = JOptionPane.showInputDialog("Enter your password to login.");
        
        // Ask how many messages to send
        int maxMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages would you like to enter?"));
        int messagesEntered = 0;
        boolean storeToFile = true;// true = store messages in JSON-like file

        // Ask for recipient number 
        String recipient;
        do {
            recipient = JOptionPane.showInputDialog("Enter recipient number (must start with +27, max 12 characters):");
            if(!Message.checkRecipientCell(recipient)) {
                JOptionPane.showMessageDialog(null, "Invalid recipient number. Please try again.");
            }
        } while(!Message.checkRecipientCell(recipient));

        // Main menu loop
        do {
            String[] menuOptions = {"Send Message", "Show Recently Sent Messages", "Quit"};
            int menuChoice = JOptionPane.showOptionDialog(null, "Choose an option:", "QuickChat Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menuOptions, menuOptions[0]);

            switch(menuChoice) {
                case 0: // Send Message
                    if(messagesEntered >= maxMessages) {
                        JOptionPane.showMessageDialog(null, "You have reached the maximum number of messages.");
                        break;
                    }

                    // Enter message with dynamic numbering
                    String message;
                    do {
                        message = JOptionPane.showInputDialog("Enter message " + (messagesEntered + 1) + " of " + maxMessages + " (max 250 characters.):");
                        if(!Message.checkMessageLength(message)) {
                            JOptionPane.showMessageDialog(null, "Message too short or long. Please enter less than 250 characters.");
                        }
                    } while(!Message.checkMessageLength(message));

                    // Send message
                    String messageID = Message.generateMessageID();
                    Message.sendMessage(messageID, messagesEntered + 1, recipient, message, storeToFile);
                    messagesEntered++;
                    break;
                    
                    // Show Recently Sent Messages (which is coming soon.)
                    case 1: 
                       JOptionPane.showMessageDialog(null, "Coming Soon");
                       break;

                    // Show Quit option
                    case 2: 
                       JOptionPane.showMessageDialog(null, "Exiting QuickChat. Total messages sent: " + Message.returnTotalMessages());
                       System.exit(0);
                       break;

                    default:
                       JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
            }
        } while(true); // Show the menu until the user quits
    }
}
   

