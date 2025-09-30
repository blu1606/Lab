/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

import Utils.Utils;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
/**
 *
 * @author LENOVO
 */
public class StudentRepository {
    private ArrayList<Student> students;

    public StudentRepository() {
        students = new ArrayList<>();
    }

    public int getStudentCount() {
        return students.size();
    }

    public void addStudent() {
        String id = Utils.getValue("Enter student ID: ");
        String name = Utils.getValue("Enter student name: ");
        String semester = Utils.getValue("Enter semester: ");
        String courseName = Utils.getFormattedValue(
            "Enter course name (Java, C/C++, .Net): ",
            "Pls enter right course!!",
            "Java|C/C\\\\+\\\\+|\\\\.Net"
        );
        students.add(new Student(id, name, semester, courseName));
    }

    // sort by comparator
    Comparator<Student> studentComparator = (Student s1, Student s2) -> {
        int nameComparison = s1.getName().compareToIgnoreCase(s2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        return s1.getCourseName().compareToIgnoreCase(s2.getCourseName());
    };

    public void sortStudentsByName() {
        students.sort(studentComparator);
    }

    // search predicate
    public ArrayList<Student> search(Predicate<Student> condition) {
        ArrayList<Student> results = new ArrayList<>();
        for (Student student : students) {
            if (condition.test(student)) {
                results.add(student);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            System.out.println("Search Results:");
            for (Student student : results) {
                System.out.println(student);
            }
        }
        return results;
    }

    public void updateStudent(Student student) {
        String newName = Utils.getValue("Enter new name (leave blank to keep current): ");
        if (!newName.isEmpty()) {
            student.setName(newName);
        }
        String newCourse = Utils.getFormattedValue(
            "Enter new course name (Java, C/C++, .Net) (leave blank to keep current): ",
            "Pls enter right course!!",
            "Java|C/C\\\\+\\\\+|\\\\.Net|"
        );
        if (!newCourse.isEmpty()) {
            student.setCourseName(newCourse);
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }
    // Report: Student name | Course | Total of Course
    public void reportStudentCourseCount() {
        // Map: (studentName, courseName) -> count
        Map<String, Map<String, Integer>> reportMap = new HashMap<>();
        for (Student s : students) {
            String name = s.getName();
            String course = s.getCourseName();
            reportMap.putIfAbsent(name, new HashMap<>());
            Map<String, Integer> courseMap = reportMap.get(name);
            courseMap.put(course, courseMap.getOrDefault(course, 0) + 1);
        }
        System.out.println("Student name | Course | Total of Course");
        for (String name : reportMap.keySet()) {
            Map<String, Integer> courseMap = reportMap.get(name);
            for (String course : courseMap.keySet()) {
                System.out.printf("%s | %s | %d\n", name, course, courseMap.get(course));
            }
        }
    }
}
