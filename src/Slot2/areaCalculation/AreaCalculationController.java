/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package areaCalculation;

import Utils.Utils;

/**
 *
 * @author ADMIN
 */
public class AreaCalculationController {
    
    public void calculateAllShapes() {
        System.out.println("=====Calculator Shape Program=====");
        
        // Input for Rectangle
        double width = Utils.getPosDouble("Please input side width of Rectangle: ");
        double length = Utils.getPosDouble("Please input length of Rectangle: ");
        
        // Input for Circle
        double radius = Utils.getPosDouble("Please input radius of Circle: ");
        
        // Input for Triangle
        double sideA = Utils.getPosDouble("Please input side A of Triangle: ");
        double sideB = Utils.getPosDouble("Please input side B of Triangle: ");
        double sideC = Utils.getPosDouble("Please input side C of Triangle: ");
        
        // Create objects
        Rectangle rectangle = new Rectangle(width, length);
        Circle circle = new Circle(radius);
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        
        // Display results
        System.out.println("-----Rectangle-----");
        System.out.printf("Width: %.1f%n", width);
        System.out.printf("Length: %.1f%n", length);
        System.out.printf("Area: %.1f%n", rectangle.getArea());
        System.out.printf("Perimeter: %.1f%n", rectangle.getPerimeter());
        
        System.out.println("-----Circle-----");
        System.out.printf("Radius: %.1f%n", radius);
        System.out.printf("Area:%.15f%n", circle.getArea());
        System.out.printf("Perimeter:%.15f%n", circle.getPerimeter());
        
        System.out.println("-----Triangle-----");
        System.out.printf("Side A: %.1f%n", sideA);
        System.out.printf("Side B: %.1f%n", sideB);
        System.out.printf("Side C: %.1f%n", sideC);
        if (triangle.isValid()) {
            System.out.printf("Area:%.2f%n", triangle.getArea());
            System.out.printf("Perimeter:%.1f%n", triangle.getPerimeter());
        } else {
            System.out.println("Invalid triangle! Cannot calculate area and perimeter.");
        }
    }
}