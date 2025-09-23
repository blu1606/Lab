package ComputerProgram;

import Utils.Menu;
import Utils.Utils;


public class CalculatorController extends Menu {
    
    public CalculatorController() {
        super("========= Calculator Program =========", 
              new String[]{"Normal Calculator", "BMI Calculator", "Exit"});
    }
    
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 -> normalCalculator();
            case 2 -> bmiCalculator();
            default -> System.out.println("Invalid choice!");
        }
    }
    
    private void normalCalculator() {
        System.out.println("----- Normal Calculator -----");
        
        Calculator calc = new Calculator(Utils.getDoubleValue("Enter number: "));
        while (true) {
            // Get operator 
            String operator = Utils.getFormattedValue("Enter Operator: ", 
                            "Please input (+, -, *, /, ^)", "^[+\\-*/^=]$");
            
            // Check if equals
            if (operator.equals("=")) {
                System.out.println("Result: " + calc.getMemory());
                break;
            }
            
            // Get next number
            double nextNumber = Utils.getDoubleValue("Enter number: ");
            calc.doCalculation(nextNumber, operator);
            System.out.println("Memory: " + calc.getMemory());
        }
    }
    
    /**
     * BMI calculator
     */
    private void bmiCalculator() {
        System.out.println("----- BMI Calculator -----");

        double weight = Utils.getDoubleValueWithErr("Enter Weight(kg): ", "Invalid input. Please enter a valid weight.");
        double height = Utils.getDoubleValueWithErr("Enter Height(m): ", "Invalid input. Please enter a valid height.");

        BMI bmi = new BMI(weight, height);
        System.out.println("BMI Number: " + bmi.getBmi());
        System.out.println("BMI Status: " + bmi.getStatus());
    }
}