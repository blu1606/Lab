/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrixCalculation;

/**
 *
 * @author ADMIN
 */
public class Matrix {
    private int row;
    private int column;
    private int[][] matrix;
    
    // Constructor
    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.matrix = new int[row][column];
    }
    
    // Getters
    public int getRow() {
        return row;
    }
    
    public int getColumn() {
        return column;
    }
    
    public int[][] getMatrix() {
        return matrix;
    }
    
    // Set value at specific position
    public void setValue(int i, int j, int value) {
        matrix[i][j] = value;
    }
    
    // Get value at specific position
    public int getValue(int i, int j) {
        return matrix[i][j];
    }
    
    // Addition matrix
    public Matrix additionMatrix(Matrix matrix2) {
        if (this.row != matrix2.row || this.column != matrix2.column) {
            return null; // Cannot add matrices with different dimensions
        }
        
        Matrix result = new Matrix(this.row, this.column);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                result.setValue(i, j, this.matrix[i][j] + matrix2.matrix[i][j]);
            }
        }
        return result;
    }
    
    // Subtraction matrix
    public Matrix subtractionMatrix(Matrix matrix2) {
        if (this.row != matrix2.row || this.column != matrix2.column) {
            return null; // Cannot subtract matrices with different dimensions
        }
        
        Matrix result = new Matrix(this.row, this.column);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                result.setValue(i, j, this.matrix[i][j] - matrix2.matrix[i][j]);
            }
        }
        return result;
    }
    
    // Multiplication matrix
    public Matrix multiplicationMatrix(Matrix matrix2) {
        if (this.column != matrix2.row) {
            return null; // Cannot multiply matrices: column of first matrix must equal row of second matrix
        }
        
        Matrix result = new Matrix(this.row, matrix2.column);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < matrix2.column; j++) {
                int sum = 0;
                for (int k = 0; k < this.column; k++) {
                    sum += this.matrix[i][k] * matrix2.matrix[k][j];
                }
                result.setValue(i, j, sum);
            }
        }
        return result;
    }
    
    // Display matrix
    public void display() {
        for (int i = 0; i < row; i++) {
            System.out.print("[");
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j]);
                if (j < column - 1) {
                    System.out.print("][");
                }
            }
            System.out.println("]");
        }
    }
    
    // Check if matrices can be added/subtracted
    public boolean canAddSubtract(Matrix matrix2) {
        return this.row == matrix2.row && this.column == matrix2.column;
    }
    
    // Check if matrices can be multiplied
    public boolean canMultiply(Matrix matrix2) {
        return this.column == matrix2.row;
    }
}