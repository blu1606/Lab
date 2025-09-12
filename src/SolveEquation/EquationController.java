package SolveEquation;

import Utils.Menu;
import Utils.Utils;
import java.util.List;

/**
 * Simplified controller managing the main program flow
 */
public class EquationController extends Menu {
    private final EquationSolver solver;
    
    public EquationController() {
        super("=== EQUATION SOLVER PROGRAM ===", 
              new String[]{
                  "Solve Linear Equation (ax + b = 0)",
                  "Solve Quadratic Equation (ax² + bx + c = 0)", 
                  "Exit"
              });
        solver = new EquationSolver();
    }
    
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 -> solveEquation(true);  // Linear equation
            case 2 -> solveEquation(false); // Quadratic equation
            case 3 -> System.out.println("Thank you for using the program!");
            default -> System.out.println("Invalid choice!");
        }
    }
    
    /**
     * General equation solving method
     * @param isLinear true for linear equation, false for quadratic
     */
    private void solveEquation(boolean isLinear) {
        System.out.println(isLinear ? 
            "\n=== LINEAR EQUATION: ax + b = 0 ===" : 
            "\n=== QUADRATIC EQUATION: ax² + bx + c = 0 ===");
        
        // Input coefficients
        float a = (float) Utils.getDoubleValue("Enter coefficient a: ");
        float b = (float) Utils.getDoubleValue("Enter coefficient b: ");
        float c = isLinear ? 0 : (float) Utils.getDoubleValue("Enter coefficient c: ");
        
        // Solve equation
        List<Float> solutions = isLinear ? 
            solver.calculateEquation(a, b) : 
            solver.calculateQuadraticEquation(a, b, c);
        
        // Display equation and results
        System.out.println("Equation: " + formatEquation(a, b, c, isLinear));
        displaySolutions(solutions);
        
        // Analyze coefficients
        solver.analyzeNumbers(isLinear ? List.of(a, b) : List.of(a, b, c));
        
        System.out.println("Press Enter to continue...");
        Utils.getValue("");
    }
    
    /**
     * Display equation solutions
     */
    private void displaySolutions(List<Float> solutions) {
        System.out.println("\n=== RESULT ===");
        if (solutions == null) {
            System.out.println("No solution!");
        } else if (solutions.isEmpty()) {
            System.out.println("Infinite solutions!");
        } else if (solutions.size() == 1) {
            System.out.println("Unique solution: x = " + solutions.get(0));
        } else {
            System.out.println("Two solutions:");
            System.out.println("x₁ = " + solutions.get(0));
            System.out.println("x₂ = " + solutions.get(1));
        }
        System.out.println("=============");
    }
    
    /**
     * Simple equation formatting
     */
    private String formatEquation(float a, float b, float c, boolean isLinear) {
        return isLinear ? 
            String.format("%.1fx + %.1f = 0", a, b) :
            String.format("%.1fx² + %.1fx + %.1f = 0", a, b, c);
    }
}
