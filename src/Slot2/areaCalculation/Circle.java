/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package areaCalculation;

/**
 *
 * @author ADMIN
 */
public class Circle extends Shape {
    private double radius;
    
    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // Getter
    public double getRadius() {
        return radius;
    }
    
    // Setter
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public void printResult() {
        System.out.println("Circle with radius = " + radius);
        super.printResult();
    }
}