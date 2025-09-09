/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LetterAndCharacterCount;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Lab {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content:");
        String inputString = scanner.nextLine();
        Words counter = new Words(inputString);
        System.out.println(counter.countWordFrequency());
        System.out.println(counter.countCharacterFrequency());
        scanner.close();
    }
    
}
