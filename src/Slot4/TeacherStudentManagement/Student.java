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
public class Student extends Person {
    private int yearOfAdmission;
    private double entranceEnglishScore;

    // Constructor without parameter
    public Student() {
        super(); // Call parent constructor
        this.yearOfAdmission = 0;
        this.entranceEnglishScore = 0.0;
    }
    
    // Constructor with parameters
    public Student(String ID, String fullName, String phoneNumber, LocalDate dob, String major,
                   int yearOfAdmission, double entranceEnglishScore) {
        super(ID, fullName, phoneNumber, dob, major);
        this.yearOfAdmission = yearOfAdmission;
        this.entranceEnglishScore = entranceEnglishScore;
    }

    // Getters
    public int getYearOfAdmission() {
        return yearOfAdmission;
    }

    public double getEntranceEnglishScore() {
        return entranceEnglishScore;
    }

    // Setters
    public void setYearOfAdmission(int yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public void setEntranceEnglishScore(double entranceEnglishScore) {
        this.entranceEnglishScore = entranceEnglishScore;
    }

    @Override
    public void inputAll() {
        try {
            super.inputAll();
            
            // Get birth year and current year for admission year validation
            int birthYear = getDob().getYear();
            int currentYear = LocalDate.now().getYear();
            
            // Input Year of admission - between birth year and current year
            this.yearOfAdmission = Utils.getIntValueInRange(
                "Enter Year of admission (" + birthYear + " to " + currentYear + "): ",
                birthYear, currentYear + 1,
                "Data input is invalid"
            );
            
            // Input Entrance English score - from 0 to 100
            this.entranceEnglishScore = Utils.getDoubleValueInRange(
                "Enter Entrance English score (0 to 100): ",
                0.0, 100.0,
                "Data input is invalid"
            );
            
            System.out.println("All student data entered successfully!");
            
        } catch (Exception e) {
            System.out.println("Data input is invalid");
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %d - %s - %d - %.0f", 
                           getID(), getFullName(), getPhoneNumber(), getDob().getYear(), getMajor(),
                           yearOfAdmission, entranceEnglishScore);
    }
    
    public static String getHeader() {
        return "# - ID - Fullname - Phone number - Year of birth - Major - Year of admission - Entrance English score";
    }
}