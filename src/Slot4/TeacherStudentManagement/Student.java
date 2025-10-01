/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package TeacherStudentManagement;

import java.time.LocalDate;

/**
 *
 * @author LENOVO
 */
public class Student {
    private String ID;
    private String fullName;
    private String phoneNumber;
    private LocalDate dob;
    private String major; 

    public Student() {
        this.ID = "";
        this.fullName = "";
        this.phoneNumber = "";
        this.dob = LocalDate.now();
        this.major = "";
    }
    
    public Student(String ID, String fullName, String phoneNumber, LocalDate dob, String major) {
        this.ID = ID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.major = major;
    }

    
}
