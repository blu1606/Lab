

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

import Utils.Menu;
import Utils.Utils;

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
    private StudentRepository studentRepo;

    public StudentController() {
        super("WELCOME TO STUDENT MANAGEMENT", options);
        studentRepo = new StudentRepository();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 -> studentRepo.addStudent();
            case 2 -> findAndSort();
            case 3 -> updateOrDeleteMenu();
            case 4 -> studentRepo.reportStudentCourseCount();
            default -> System.out.println("Invalid choice! Please try again.");
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

    private void findAndSort() {
        String name = Utils.getValue("Enter Student Name to search: ");
        ArrayList<Person> foundStudents = studentRepo.search(s -> s.getName().toLowerCase().contains(name.toLowerCase()));
        if (foundStudents.isEmpty()) {
            System.out.println("No students found with the name containing: " + name);
            return;
        }
        System.out.println("Found Students:");
        studentRepo.sortStudentsByName();
        System.out.println("Students sorted by name:");
        for (Person student : foundStudents) {
            System.out.println(student);
        }
    }

    private void updateStudent() {
        String id = Utils.getValue("Enter Student ID to update: ");
        ArrayList<Person> students = studentRepo.search(s -> s.getId().equals(id));
        if (students.size() == 1) {
            studentRepo.updateStudent(students.get(0));
        } else {
            System.out.println("Student not found or ambiguous search.");
        }
    }

    private void deleteStudent() {
        String id = Utils.getValue("Enter Student ID to delete: ");
        ArrayList<Person> students = studentRepo.search(s -> s.getId().equals(id));
        if (students.size() == 1) {
            studentRepo.removeStudent(students.get(0));
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found or ambiguous search.");
        }
    }
}

        
