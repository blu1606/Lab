/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class Student {
    private String id;
    private String name;
    private String semester;
    private String courseName;

    public Student(String id, String name, String semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getName() {
        return name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String setSemester(String semester) {
        return this.semester = semester;
    }
    public String setId(String id) {
        return this.id = id;
    }
    public String getSemester() {
        return semester;
    }
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Course: " + courseName;
    }
}
