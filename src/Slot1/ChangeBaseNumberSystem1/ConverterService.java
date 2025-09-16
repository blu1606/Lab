/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ChangeBaseNumberSystem1;

/**
 *
 * @author LENOVO
 */
public class ConverterService {
    
    public long convertToDecimal(String number, int base) {
        switch (base) {
            case 1 -> {
                // Binary
                return binaryToDecimal(number);
            }
            case 2 -> {
                // Decimal
                return decimalToDecimal(number);
            }
            case 3 -> {
                // Hexadecimal
                return hexToDecimal(number);
            }
            default -> throw new IllegalArgumentException("Unsupported base");
        }
    }
    
    public String convertFromDecimal(long decimal, int base) {
        switch (base) {
            case 1 -> {
                // Binary
                return decimalToBinary(decimal);
            }
            case 2 -> {
                // Decimal
                return decimalToDecimalString(decimal);
            }
            case 3 -> {
                // Hexadecimal
                return decimalToHex(decimal);
            }
            default -> throw new IllegalArgumentException("Unsupported base");
        }
    }
    
    private long binaryToDecimal(String binary) {
        long decimal = 0;
        long power = 0;
        
        for (int i = binary.length() - 1; i >= 0; i--) {
            char digit = binary.charAt(i);
            if (digit != '0' && digit != '1') {
                throw new NumberFormatException("Invalid binary digit: " + digit);
            }
            
            if (digit == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }
    
    private long decimalToDecimal(String decimal) {
        long result = 0;
        
        for (int i = 0; i < decimal.length(); i++) {
            char digit = decimal.charAt(i);
            if (digit < '0' || digit > '9') {
                throw new NumberFormatException("Invalid decimal digit: " + digit);
            }
            result = result * 10 + (digit - '0');
        }
        return result;
    }
    
    private long hexToDecimal(String hex) {
        long decimal = 0;
        long power = 0;
        
        for (int i = hex.length() - 1; i >= 0; i--) {
            char digit = Character.toUpperCase(hex.charAt(i));
            int digitValue;
            
            if (digit >= '0' && digit <= '9') {
                digitValue = digit - '0';
            } else if (digit >= 'A' && digit <= 'F') {
                digitValue = digit - 'A' + 10;
            } else {
                throw new NumberFormatException("Invalid hexadecimal digit: " + digit);
            }
            
            decimal += digitValue * Math.pow(16, power);
            power++;
        }
        return decimal;
    }
    
    private String decimalToBinary(long decimal) {
        if (decimal == 0) return "0";
        
        StringBuilder binary = new StringBuilder();
        
        while (decimal > 0) {
            binary.append(decimal % 2);
            decimal /= 2;
        }
        
        return binary.reverse().toString();
    }
    
    private String decimalToDecimalString(long decimal) {
        return String.valueOf(decimal);
    }
    
    private String decimalToHex(long decimal) {
        if (decimal == 0) return "0";
        
        StringBuilder hex = new StringBuilder();
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        
        while (decimal > 0) {
            hex.append(hexChars[(int)(decimal % 16)]);
            decimal /= 16;
        }
        
        return hex.reverse().toString();
    }
}
