package ComputerProgram;

import Utils.Menu;
import Utils.Utils;


public class CalculatorController extends Menu {
    private final CalculatorService service;
    
    public CalculatorController() {
        super("========= Calculator Program =========", 
              new String[]{"Normal Calculator", "BMI Calculator", "Exit"});
        service = new CalculatorService();
    }
    
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 -> normalCalculator();
            case 2 -> bmiCalculator();
            case 3 -> System.out.println("Goodbye!");
            default -> System.out.println("Invalid choice!");
        }
    }
    
    private void normalCalculator() {
        System.out.println("----- Normal Calculator -----");
        
        // Get first number 
        double memory = Utils.getDoubleValue("Enter number: ");
        
        while (true) {
            // Get operator 
            String operator = Utils.getFormattedValue("Enter Operator: ", "Please input (+, -, *, /, ^)", "^[+\\-*/^=]$");
            
            // Check if equals
            if (operator.equals("=")) {
                System.out.println("Result: " + memory);
                break;
            }
            
            // Get next number
            double nextNumber = Utils.getDoubleValue("Enter number: ");
            
            try {
                // Calculate and update memory
                memory = service.calculate(memory, operator, nextNumber);
                System.out.println("Memory: " + memory);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }
        }
    }
    
    /**
     * BMI calculator
     */
    private void bmiCalculator() {
        System.out.println("----- BMI Calculator -----");
        
        // Get weight
        double weight = getValidDoubleWithCustomError("Enter Weight(kg): ");
        
        // Get height  
        double height = getValidDoubleWithCustomError("Enter Height(cm): ");
        
        // Calculate BMI
        String result = service.calculateBMI(weight, height);
        String[] parts = result.split(" - ");
        System.out.println("BMI Number: " + parts[0]);
        System.out.println("BMI Status: " + parts[1]);
    }
    
    /**
     * Get valid double with custom error message for BMI
     */
    private double getValidDoubleWithCustomError(String prompt) {
        while (true) {
            try {
                String input = Utils.getValue(prompt);
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
            }
        }
    }
}