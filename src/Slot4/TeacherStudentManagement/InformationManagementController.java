/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package TeacherStudentManagement;

import Utils.Menu;
import Utils.Utils;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class InformationManagementController extends Menu {
    
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Person> allPersons;
    
    public InformationManagementController() {
        super("*** Information Management ***", 
              new String[]{"Teacher", "Student", "Person", "Exit"});
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        allPersons = new ArrayList<>();
    }
    
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 -> manageTeacher();
            case 2 -> manageStudent();
            case 3 -> managePerson();
        }
    }
    
    private void manageTeacher() {
        String[] teacherMenuOptions = {"Input", "Print", "Exit"};
        
        Menu teacherMenuObj = new Menu("*** Teacher Management ***", teacherMenuOptions) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> inputTeacher();
                    case 2 -> printTeachers();
                    default -> System.out.println("Invalid choice!");
                }
            }
        };
        
        teacherMenuObj.run();
    }
    
    private void manageStudent() {
        String[] studentMenuOptions = {"Input", "Print", "Exit"};
        
        Menu studentMenuObj = new Menu("*** Student Management ***", studentMenuOptions) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> inputStudent();
                    case 2 -> printStudents();
                    default -> System.out.println("Invalid choice!");
                }
            }
        };
        
        studentMenuObj.run();
    }
    
    private void managePerson() {
        String[] personMenuOptions = {"Search", "Print all", "Exit"};
        
        Menu personMenuObj = new Menu("*** Person Management ***", personMenuOptions) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> searchPerson();
                    case 2 -> printAllPersons();
                    default -> System.out.println("Invalid choice!");
                }
            }
        };
        
        personMenuObj.run();
    }
    
    // Teacher methods
    private void inputTeacher() {
        Teacher teacher = new Teacher();
        teacher.inputAll();
        teachers.add(teacher);
        allPersons.add(teacher);
    }
    
    private void printTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
            return;
        }
        
        System.out.println(Teacher.getHeader());
        for (int i = 0; i < teachers.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, teachers.get(i).toString());
        }
    }
    
    // Student methods
    private void inputStudent() {
        Student student = new Student();
        student.inputAll();
        students.add(student);
        allPersons.add(student);
    }
    
    private void printStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        
        System.out.println(Student.getHeader());
        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, students.get(i).toString());
        }
    }
    
    // Person methods
    private void searchPerson() {
        String searchName = Utils.getValue("Name: ");
        ArrayList<Person> results = new ArrayList<>();
        
        for (Person person : allPersons) {
            if (person.getFullName().toLowerCase().contains(searchName.toLowerCase())) {
                results.add(person);
            }
        }
        
        if (results.isEmpty()) {
            System.out.println("Result: not found");
        } else {
            System.out.println("Result:");
            System.out.println(Person.getHeader());
            for (int i = 0; i < results.size(); i++) {
                System.out.printf("%d - %s%n", i + 1, results.get(i).toString());
            }
        }
    }
    
    private void printAllPersons() {
        if (allPersons.isEmpty()) {
            System.out.println("No persons found.");
            return;
        }
        
        System.out.println(Person.getHeader());
        for (int i = 0; i < allPersons.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, allPersons.get(i).toString());
        }
    }
}