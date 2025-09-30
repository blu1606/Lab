/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package StudentManagement2;

import Utils.Menu;
import Utils.Utils;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class StudentController extends Menu {
    static String[] options = {
        "Create",
        "Find and Sort",
        "Update/ Delete",
        "Report"
    };
    private StudentManagement studentRepo;

    public StudentController() {
        super("WELCOME TO STUDENT MANAGEMENT", options);
        studentRepo = new StudentManagement();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 -> addStudent();
            case 2 -> findAndSort();
            case 3 -> updateOrDeleteMenu();
            case 4 -> studentRepo.reportStudent();
            default -> System.out.println("Invalid choice! Please try again.");
        }
    }

    private void addStudent() {
        System.out.println("-------- Add Student --------");
        String id = Utils.getValue("Enter Student ID: ");
        String name = Utils.getValue("Enter Student Name: ");
        String semester = Utils.getValue("Enter Semester: ");
        String courseName = Utils.getValue("Enter Course Name: ");
        Student student = new Student(id, name, semester, courseName);
        if (studentRepo.addStudent(student)) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Failed to add student.");
        }
    }

    private void findAndSort() {
        String name = Utils.getValue("Enter Student Name to search: ");
        ArrayList<Student> foundStudents = studentRepo.search(s -> s.getName().toLowerCase().contains(name.toLowerCase()));
        System.out.println("Found Students:");
        studentRepo.sortStudent();
        System.out.println("Students sorted by name:");
        for (Student student : foundStudents) {
            System.out.println(student);
        }
    }

    private void updateOrDeleteMenu() {
        String[] updateDeleteOptions = {"Update", "Delete", "Back to Main Menu"};
        Menu updateDeleteMenu = new Menu("Update/Delete Menu", updateDeleteOptions) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> updateStudent();
                    case 2 -> deleteStudent();
                    case 3 -> System.out.println("Returning to Main Menu...");
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            }
        };
        updateDeleteMenu.run();
    }

    private void updateStudent() {
        String id = Utils.getValue("Enter Student ID to update: ");
        String name = Utils.getValue("Enter new name: ");
        String semester = Utils.getValue("Enter new semester: ");
        String courseName = Utils.getValue("Enter new course name: ");
        ArrayList<Student> existingStudents = studentRepo.search(s -> s.getId().equals(id));
        if (existingStudents.isEmpty()) {
            System.out.println("Student not found.");
            return;
        }
        if (studentRepo.updateStudent(id, name, semester, courseName)) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Failed to update student.");
        }
    }

    private void deleteStudent() {
        String id = Utils.getValue("Enter Student ID to delete: ");
        ArrayList<Student> existingStudents = studentRepo.search(s -> s.getId().equals(id));
        if (existingStudents.isEmpty()) {
            System.out.println("Student not found.");
            return;
        }
        if (studentRepo.removeStudent(id)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Failed to delete student.");
        }
    }
}
