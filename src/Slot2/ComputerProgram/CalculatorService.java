package ComputerProgram;

/**
 * Calculator service containing calculation logic
 */
public class CalculatorService {
    public double calculate(double a, String operator, double b) {
        switch (operator) {
            case "+" -> {
                return a + b;
            }
            case "-" -> {
                return a - b;
            }
            case "*" -> {
                return a * b;
            }
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            }
            case "^" -> {
                return Math.pow(a, b);
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    
    public String calculateBMI(double weight, double height) {
        // Convert height from cm to m
        double heightInMeters = height / 100.0;
        
        // Calculate BMI
        double bmi = weight / (heightInMeters * heightInMeters);
        
        // Determine BMI status
        String status;
        if (bmi < 19) {
            status = "UNDER_STANDARD";
        } else if (bmi <= 25) {
            status = "STANDARD";
        } else if (bmi <= 30) {
            status = "OVERWEIGHT";
        } else if (bmi <= 40) {
            status = "FAT";
        } else {
            status = "VERY_FAT";
        }
        
        return String.format("%.2f", bmi) + " - " + status;
    }
}