/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ComputerProgram;

/**
 *
 * @author LENOVO
 */
public class BMI {
    private final double height;
    private final double weight;
    private double bmi; 

    public BMI() {
        this.height = 0;
        this.weight = 0;
    }
    public BMI(double height, double weight) {
        this.height = height;
        this.weight = weight;
        this.bmi = weight / (height * height);
    }

    public String getStatus() {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }

    public double getBmi() {
        return bmi;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
}
