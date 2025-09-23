/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ComputerProgram;

/**
 *
 * @author LENOVO
 */
public class Calculator {
    private final double memory;
    
    public Calculator() {
        this.memory = 0;
    }
    public Calculator(double memory) {
        this.memory = memory;
    }

    public double doCalculation(double value, String operator) {
        switch (operator) {
            case "+" -> {
                return memory + value;
            }
            case "-" -> {
                return memory - value;
            }
            case "*" -> {
                return memory * value;
            }
            case "/" -> {
                if (value != 0) {
                    return memory / value;
                } else {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
            }
            default -> throw new IllegalArgumentException("Invalid operator");
        }
    }

    public double getMemory() {
        return memory;
    }



}
