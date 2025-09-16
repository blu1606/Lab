/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package areaCalculation;

/**
 *
 * @author ADMIN
 */
public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    
    // Constructor
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    // Getters
    public double getSideA() {
        return sideA;
    }
    
    public double getSideB() {
        return sideB;
    }
    
    public double getSideC() {
        return sideC;
    }
    
    // Setters
    public void setSideA(double sideA) {
        this.sideA = sideA;
    }
    
    public void setSideB(double sideB) {
        this.sideB = sideB;
    }
    
    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
    
    // Check if triangle is valid (triangle inequality theorem)
    public boolean isValid() {
        return (sideA + sideB > sideC) && 
               (sideA + sideC > sideB) && 
               (sideB + sideC > sideA);
    }
    
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
    
    @Override
    public double getArea() {
        // Using Heron's formula
        if (!isValid()) {
            return 0; // Invalid triangle
        }
        
        double s = getPerimeter() / 2; // semi-perimeter
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    
    @Override
    public void printResult() {
        System.out.println("Triangle with sides: " + sideA + ", " + sideB + ", " + sideC);
        if (isValid()) {
            super.printResult();
        } else {
            System.out.println("Invalid triangle! Cannot calculate area and perimeter.");
        }
    }
}