/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package areaCalculation;

/**
 *
 * @author ADMIN
 */
public abstract class Shape {
    
    // Abstract methods that must be implemented by subclasses
    public abstract double getPerimeter();
    
    public abstract double getArea();
    
    // Common method to print result for all shapes
    public void printResult() {
        System.out.printf("Perimeter: %.2f%n", getPerimeter());
        System.out.printf("Area: %.2f%n", getArea());
    }
}