/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package part_two;

/**
 *
 * @author RC_Student_Lab
 */
public class Validation {
    // Check if username is vaild
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <=5;
    }
    
    // Check if password meets complexity requirements
    public boolean checkPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_+=-])(?=\\S+$).{8,}$");
    }
    
    // Check if cell phone number is valid
    public boolean checkCellPhoneNumber(String cell) {
        return cell.matches("^(\\+27|0)[6-8][0-9]{8}$");
    }
    
    // Check if login is successful
    public boolean checkLogin(String inputUser, String inputPass, String storedUser, String storedPass) {
        return inputUser.equals(storedUser) && inputPass.equals(storedPass);
    }
}
