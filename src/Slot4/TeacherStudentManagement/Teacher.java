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
public class Teacher extends Person {
    private int yearInProfession;
    private String contractType;
    private double salaryCoefficient;

    public Teacher() {
        super(); 
        this.yearInProfession = 0;
        this.contractType = "";
        this.salaryCoefficient = 0.0;
    }
    
    public Teacher(String ID, String fullName, String phoneNumber, LocalDate dob, String major,
                   int yearInProfession, String contractType, double salaryCoefficient) {
        super(ID, fullName, phoneNumber, dob, major);
        this.yearInProfession = yearInProfession;
        this.contractType = contractType;
        this.salaryCoefficient = salaryCoefficient;
    }

    // Getters
    public int getYearInProfession() {
        return yearInProfession;
    }

    public String getContractType() {
        return contractType;
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    // Setters
    public void setYearInProfession(int yearInProfession) {
        this.yearInProfession = yearInProfession;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    // Calculate age from date of birth
    private int calculateAge() {
        return LocalDate.now().getYear() - getDob().getYear();
    }

    // InputAll method with validation using Utils
    @Override
    public void inputAll() {
        try {
            super.inputAll();
            
            // Calculate age for profession year validation
            int age = calculateAge();
            
            // Input Year in profession - number from 0 to lower than age
            this.yearInProfession = Utils.getIntValueInRange(
                "Enter Year in profession (0 to " + (age - 1) + "): ",
                0, age,
                "Data input is invalid"
            );
            
            // Input Contract type - 'Long' or 'Short' value
            this.contractType = Utils.getFormattedValue(
                "Enter Contract type (Long/Short): ",
                "Data input is invalid",
                "(?i)(Long|Short)"
            );
            
            // Input Salary coefficient - number from 0
            this.salaryCoefficient = Utils.getDoubleValueWithMin(
                "Enter Salary coefficient (>= 0): ",
                0.0,
                "Data input is invalid"
            );
            
            System.out.println("All teacher data entered successfully!");
            
        } catch (Exception e) {
            System.out.println("Data input is invalid");
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %d - %s - %d - %s - %.1f", 
                           getID(), getFullName(), getPhoneNumber(), getDob().getYear(), getMajor(),
                           yearInProfession, contractType, salaryCoefficient);
    }
    
    public static String getHeader() {
        return "# - ID - Fullname - Phone number - Year of birth - Major - Year in the profession - Contract type - Salary coefficient";
    }
}