/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package areaCalculation;

/**
 *
 * @author ADMIN
 */
public class Rectangle extends Shape {
    private double width;
    private double length;
    
    // Constructor
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    
    // Getters
    public double getWidth() {
        return width;
    }
    
    public double getLength() {
        return length;
    }
    
    // Setters
    public void setWidth(double width) {
        this.width = width;
    }
    
    public void setLength(double length) {
        this.length = length;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }
    
    @Override
    public double getArea() {
        return width * length;
    }
    
    @Override
    public void printResult() {
        System.out.println("Rectangle with width = " + width + ", length = " + length);
        super.printResult();
    }
}