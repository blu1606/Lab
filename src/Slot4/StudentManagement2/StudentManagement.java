/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package StudentManagement2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 *
 * @author LENOVO
 */
public class StudentManagement {
    private List<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    public ArrayList<Student> search(Predicate<Student> condition) {
        ArrayList<Student> results = new ArrayList<>();
        for (Student student : students) {
            if (condition.test(student)) {
                results.add(student);
            }
        }
        return results;
    }
    
    public boolean addStudent(Student student) {
        ArrayList<Student> existingStudents = search(s -> s.getId().equals(student.getId()) && s.getSemester().equals(student.getSemester()) && s.getCourseName().equals(student.getCourseName()));
        if (!existingStudents.isEmpty()) {
            System.out.println("Student with ID " + student.getId() + " already exists.");
            return false;
        }
        return students.add(student);
    }

    public boolean removeStudent(String id) {
        return students.removeIf(student -> student.getId().equals(id));
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    

    public boolean updateStudent(String id, String name, String semester, String courseName) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(name);
                student.setSemester(semester);
                student.setCourseName(courseName);
                return true;
            }
        }
        return false;
    }

    public void sortStudent() {
        students.sort(Comparator.comparing(Student::getName));
        showStudents();
    }

    public void reportStudent() {
        Map<String, Integer> report = new HashMap<>();
        for (Student student : students) {
            String key = student.getId() + " | " + student.getName() + " | " + student.getCourseName();
            report.put(key, report.getOrDefault(key, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            System.out.println(entry.getKey() + " | Number of semesters: " + entry.getValue());
        }
    }
}
