/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrixCalculation;

import Utils.Menu;
import Utils.Utils;

/**
 *
 * @author ADMIN
 */
public class MatrixCalculationController extends Menu {
    
    public MatrixCalculationController() {
        super("=======Calculator program=======", 
              new String[]{"Addition Matrix", "Subtraction Matrix", "Multiplication Matrix", "Quit"});
    }
    
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 -> performAddition();
            case 2 -> performSubtraction();
            case 3 -> performMultiplication();
            default -> System.out.println("Invalid choice! Please try again.");
        }
    }
    
    private Matrix inputMatrix(int matrixNumber, String operation) {
        if (matrixNumber == 1) {
            System.out.println("-------- " + operation + " --------");
        }
        
        int row = Utils.getPosIntValue("Enter Row Matrix " + matrixNumber + ": ");
        int column = Utils.getPosIntValue("Enter Column Matrix " + matrixNumber + ": ");
        
        Matrix matrix = new Matrix(row, column);
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int value = Utils.getIntValue("Enter Matrix" + matrixNumber + "[" + (i+1) + "][" + (j+1) + "]: ");
                matrix.setValue(i, j, value);
            }
        }
        
        return matrix;
    }
    
    private void displayResult(Matrix matrix1, String operator, Matrix matrix2, Matrix result) {
        System.out.println("-------- Result --------");
        
        // Display matrix1
        matrix1.display();
        
        // Display operator
        System.out.println(operator);
        
        // Display matrix2  
        matrix2.display();
        
        // Display equals and result
        System.out.println("=");
        result.display();
        System.out.println();
    }
    
    private void performAddition() {
        Matrix matrix1 = inputMatrix(1, "Addition");
        Matrix matrix2 = inputMatrix(2, "Addition");
        
        if (!matrix1.canAddSubtract(matrix2)) {
            System.out.println("Error: Matrices must have the same dimensions for addition!");
            return;
        }
        
        Matrix result = matrix1.additionMatrix(matrix2);
        displayResult(matrix1, "+", matrix2, result);
    }
    
    private void performSubtraction() {
        Matrix matrix1 = inputMatrix(1, "Subtraction");
        Matrix matrix2 = inputMatrix(2, "Subtraction");
        
        if (!matrix1.canAddSubtract(matrix2)) {
            System.out.println("Error: Matrices must have the same dimensions for subtraction!");
            return;
        }
        
        Matrix result = matrix1.subtractionMatrix(matrix2);
        displayResult(matrix1, "-", matrix2, result);
    }
    
    private void performMultiplication() {
        Matrix matrix1 = inputMatrix(1, "Multiplication");
        Matrix matrix2 = inputMatrix(2, "Multiplication");
        
        if (!matrix1.canMultiply(matrix2)) {
            System.out.println("Error: Number of columns in first matrix must equal number of rows in second matrix for multiplication!");
            return;
        }
        
        Matrix result = matrix1.multiplicationMatrix(matrix2);
        displayResult(matrix1, "*", matrix2, result);
    }
}