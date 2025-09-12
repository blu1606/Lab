package SolveEquation;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing logic for solving equations and analyzing numbers
 * Combines equation solving and number analysis functionality
 */
public class EquationSolver {
    
    /**
     * Solve linear equation: ax + b = 0
     * @param a coefficient a
     * @param b coefficient b  
     * @return null if no solution, empty List if infinite solutions, List containing solution if unique solution exists
     */
    public List<Float> calculateEquation(float a, float b) {
        List<Float> result = new ArrayList<>();
        
        if (a == 0) {
            if (b == 0) {
                // 0x + 0 = 0 => infinite solutions
                return result; // return empty List
            } else {
                // 0x + b = 0 with b != 0 => no solution
                return null;
            }
        } else {
            // ax + b = 0 => x = -b/a
            float x = -b / a;
            result.add(x);
            return result;
        }
    }
    
    /**
     * Solve quadratic equation: ax² + bx + c = 0
     * @param a coefficient a
     * @param b coefficient b
     * @param c coefficient c
     * @return null if no solution, List containing solution(s)
     */
    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> result = new ArrayList<>();
        
        // If a = 0, this is actually a linear equation
        if (a == 0) {
            return calculateEquation(b, c);
        }
        
        // Calculate delta
        float delta = b * b - 4 * a * c;
        
        if (delta < 0) {
            // No real solution
            return null;
        } else if (delta == 0) {
            // Double root
            float x = -b / (2 * a);
            result.add(x);
        } else {
            // Two distinct roots
            float sqrtDelta = (float) Math.sqrt(delta);
            float x1 = (-b + sqrtDelta) / (2 * a);
            float x2 = (-b - sqrtDelta) / (2 * a);
            result.add(x1);
            result.add(x2);
        }
        
        return result;
    }
    
    /**
     * Analyze coefficients for mathematical properties
     * @param numbers list of coefficients to analyze
     */
    public void analyzeNumbers(List<Float> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            System.out.println("No numbers to analyze.");
            return;
        }
        
        System.out.println("\n=== COEFFICIENT ANALYSIS ===");
        System.out.print("Coefficients: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) System.out.print(", ");
        }
        System.out.println();
        
        // Find and display even numbers
        System.out.print("Even: ");
        boolean hasEven = false;
        for (Float num : numbers) {
            if (isInteger(num) && num.intValue() % 2 == 0) {
                if (hasEven) System.out.print(", ");
                System.out.print(num.intValue());
                hasEven = true;
            }
        }
        if (!hasEven) System.out.print("None");
        System.out.println();
        
        // Find and display odd numbers
        System.out.print("Odd: ");
        boolean hasOdd = false;
        for (Float num : numbers) {
            if (isInteger(num) && num.intValue() % 2 != 0) {
                if (hasOdd) System.out.print(", ");
                System.out.print(num.intValue());
                hasOdd = true;
            }
        }
        if (!hasOdd) System.out.print("None");
        System.out.println();
        
        // Find and display perfect squares
        System.out.print("Perfect squares: ");
        boolean hasPerfectSquare = false;
        for (Float num : numbers) {
            if (isPerfectSquare(num)) {
                if (hasPerfectSquare) System.out.print(", ");
                System.out.print(num.intValue());
                hasPerfectSquare = true;
            }
        }
        if (!hasPerfectSquare) System.out.print("None");
        System.out.println("\n========================\n");
    }
    
    /**
     * Check if a number is an integer
     */
    private boolean isInteger(Float number) {
        return number != null && number.equals((float) Math.floor(number));
    }
    
    /**
     * Check if a number is a perfect square
     */
    private boolean isPerfectSquare(Float number) {
        if (number < 0 || !isInteger(number)) return false;
        float sqrt = (float) Math.sqrt(number);
        return sqrt == Math.floor(sqrt);
    }
}
