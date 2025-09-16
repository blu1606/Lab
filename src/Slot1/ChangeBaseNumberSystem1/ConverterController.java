/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ChangeBaseNumberSystem1;

import Utils.Menu;
import Utils.Utils;
/**
 *
 * @author LENOVO
 */
public class ConverterController extends Menu {
    static String options[] = {
        "Binary",
        "Decimal", 
        "Hexadecimal",
        "Exit"
    };
    
    private final ConverterService converterService;
        
    public ConverterController() {
        super("Choose base number input", options);
        this.converterService = new ConverterService();
    }
    
    @Override
    public void execute(int choice) {
        String inputNumber = Utils.getValue("Enter number to convert: ");
        String inputBase = options[choice - 1];
        Menu outputMenu = new Menu("Choose base number output: ", options) {
            @Override
            public void execute(int outputChoice) {
                String outputBase = options[outputChoice - 1];
                performConversion(inputNumber, choice, outputChoice, inputBase, outputBase);
            }
        };
        
        int outputChoice = outputMenu.getSelected();
        outputMenu.execute(outputChoice);
    }
    
    private void performConversion(String inputNumber, int inputBase, int outputBase, String inputBaseName, String outputBaseName) {
        try {
            long decimalValue = converterService.convertToDecimal(inputNumber, inputBase);
            String result = converterService.convertFromDecimal(decimalValue, outputBase);
            
            System.out.println("\n=== CONVERSION RESULT ===");
            System.out.println("Input: " + inputNumber + " (" + inputBaseName + ")");
            System.out.println("Output: " + result + " (" + outputBaseName + ")");
            System.out.println("========================\n");
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format for " + inputBaseName + " base!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
