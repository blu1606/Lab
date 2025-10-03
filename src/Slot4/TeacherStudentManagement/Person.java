/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package TeacherStudentManagement;

import Utils.Utils;
import java.time.LocalDate;

/**
 *
 * @author LENOVO
 */
public class Person {
    private String ID;
    private String fullName;
    private String phoneNumber;
    private LocalDate dob;
    private String major; 

    public Person() {
        this.ID = "";
        this.fullName = "";
        this.phoneNumber = "";
        this.dob = LocalDate.now();
        this.major = "";
    }
    
    public Person(String ID, String fullName, String phoneNumber, LocalDate dob, String major) {
        this.ID = ID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.major = major;
    }

    // Getters
    public String getID() {
        return ID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getMajor() {
        return major;
    }

    // Setters
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // InputAll method with validation using Utils
    public void inputAll() {
        // Input ID - 6 digits
        this.ID = Utils.getFormattedValue(
            "Enter ID (6 digits): ",
            "Error: ID must be exactly 6 digits!",
            "\\d{6}"
        );
        
        // Input Full Name - alphabet and blanks only
        this.fullName = Utils.getFormattedValue(
            "Enter Full Name (alphabet and spaces only): ",
            "Error: Full name must contain only alphabets and spaces!",
            "[a-zA-Z\\s]+"
        );
        
        // Input Phone Number - 12 digits
        this.phoneNumber = Utils.getFormattedValue(
            "Enter Phone Number (12 digits): ",
            "Error: Phone number must be exactly 12 digits!",
            "\\d{12}"
        );
        
        // Input Date of Birth - using Utils function with year validation
        this.dob = Utils.getDateValueWithYearCheck("Enter Date of Birth (dd/MM/yyyy): ");
        
        // Input Major - no more than 30 characters
        this.major = Utils.getFormattedValue(
            "Enter Major (max 30 characters): ",
            "Error: Major must not be empty and must be no more than 30 characters!",
            ".{1,30}"
        );
        
        System.out.println("All data entered successfully!");
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %d - %s", 
                           ID, fullName, phoneNumber, dob.getYear(), major);
    }
    
    public static String getHeader() {
        return "# - ID - Fullname - Phone number - Year of birth - Major";
    }
}
