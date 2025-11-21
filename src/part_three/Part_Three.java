/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package part_three;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_Lab
 */
public class Part_Three {

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
        
        // PART 3 load report
        MessageReport.loadMessagesFromFile();
        
        boolean quit = false;
        while (!quit) {

            String menu =
                    "QuickChat Menu\n" +
                    "1. Send Message\n" +
                    "2. Show Recent Messages\n" +
                    "3. Show Total Messages Sent\n" +
                    "4. Analyze a Message\n" +
                    "5. Array Operations\n" +
                    "6. Quit\n\n" +
                    "Enter option number:";

            int option = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (option) {

                // Option 1 (sending messages)
                case 1:
                    sendMessageFlow();
                    break;

                // Option 2 (showing recent messages)
                case 2:
                    Message.showRecentMessages();
                    break;

                //  Option 3 (showing the total sent messages)
                case 3:
                    JOptionPane.showMessageDialog(
                            null,
                            "Total Messages Sent: " + Message.returnTotalMessages()
                    );
                    break;

                // Option 4 (analyzing the messages by searching, delete by hash and showing of reports)
                case 4:
                    analyzeMenu();
                    break;

                // Option 5 (show array operations and reload messages report
                case 5:
                    JOptionPane.showMessageDialog(null, "Reloading message report...");
                    Message.showReport();
                    break;

                // Option 6 (quit or exit point)
                case 6:
                    quit = true;
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        }
    }

    // Send message flow that is used in option 1
    public static void sendMessageFlow() {

        String recipient;
        do {
            recipient = JOptionPane.showInputDialog("Enter recipient number (+27 or 0xxxxxxxxx):");
            if (!Message.checkRecipientCell(recipient)) {
                JOptionPane.showMessageDialog(null, "Invalid recipient number.");
            }
        } while (!Message.checkRecipientCell(recipient));

        String content;
        do {
            content = JOptionPane.showInputDialog("Enter message (max 250 characters):");
            if (!Message.checkMessageLength(content)) {
                JOptionPane.showMessageDialog(null, "Message too long.");
            }
        } while (!Message.checkMessageLength(content));

        String messageID = Message.generateMessageID();
        String hash = Message.createMessageHash(messageID, Message.messageCount + 1, content);

        String fullMessage =
                "{\n" +
                " MessageID: " + messageID + "\n" +
                " MessageHash: " + hash + "\n" +
                " Recipient: " + recipient + "\n" +
                " Message: " + content + "\n" +
                "}";

        String[] choices = {"Send", "Store Only", "Cancel"};
        int choice = JOptionPane.showOptionDialog(null, fullMessage,
                "Send or Store?",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, choices, choices[0]);

        if (choice == 0 || choice == 1) {
            Message.sentMessages.add(fullMessage);
            if (choice == 0) Message.messageCount++;
            Message.storeMessageToFile(fullMessage);

            JOptionPane.showMessageDialog(null,
                    choice == 0 ? "Message Sent!" : "Message Stored!");
        } else {
            JOptionPane.showMessageDialog(null, "Message cancelled.");
        }
    }

    // Analyze menu that is usedin option 4
    public static void analyzeMenu() {

        String menu =
                "Analyze Message Menu\n" +
                "1. Search by Recipient\n" +
                "2. Delete Message by Hash\n" +
                "3. Display Message Report\n" +
                "4. Back";

        int option = Integer.parseInt(JOptionPane.showInputDialog(menu));

        switch (option) {
            case 1:
                String number = JOptionPane.showInputDialog("Enter number to search:");
                Message.searchByRecipient(number);
                break;

            case 2:
                String hash = JOptionPane.showInputDialog("Enter message hash to delete:");
                Message.deleteByHash(hash);
                break;

            case 3:
                Message.showReport();
                break;

            case 4:
                return;

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice.");
        }
        

//        // Main menu loop
//        do {
//            String[] menuOptions = {"Send Message", "Show Recently Sent Messages", "Quit"};
//            int menuChoice = JOptionPane.showOptionDialog(null, "Choose an option:", "QuickChat Menu",
//                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menuOptions, menuOptions[0]);
//
//            switch(menuChoice) {
//                case 0: // Send Message
//                    if(messagesEntered >= maxMessages) {
//                        JOptionPane.showMessageDialog(null, "You have reached the maximum number of messages.");
//                        break;
//                    }
//
//                    // Enter message with dynamic numbering
//                    String message;
//                    do {
//                        message = JOptionPane.showInputDialog("Enter message " + (messagesEntered + 1) + " of " + maxMessages + " (max 250 characters.):");
//                        if(!Message.checkMessageLength(message)) {
//                            JOptionPane.showMessageDialog(null, "Message too short or long. Please enter less than 250 characters.");
//                        }
//                    } while(!Message.checkMessageLength(message));
//
//                    // Send message
//                    String messageID = Message.generateMessageID();
//                    Message.sendMessage(messageID, messagesEntered + 1, recipient, message, storeToFile);
//                    messagesEntered++;
//                    break;
//                    
//                    // Show Recently Sent Messages (which is coming soon.)
//                    case 1: 
//                       JOptionPane.showMessageDialog(null, "Coming Soon");
//                       break;
//
//                    // Show Quit option
//                    case 2: 
//                       JOptionPane.showMessageDialog(null, "Exiting QuickChat. Total messages sent: " + Message.returnTotalMessages());
//                       System.exit(0);
//                       break;
//
//                    default:
//                       JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
//            }
//        } while(true); // Show the menu until the user quits
    
    }
}
