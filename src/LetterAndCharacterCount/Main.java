/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LetterAndCharacterCount;

import Utils.Utils;

/**
 *
 * @author LENOVO
 */
public class Main {

    public static void main(String[] args) {
        String inputString = Utils.getValue("Enter your content: ");
        Words counter = new Words(inputString);
        System.out.println(counter.countWordFrequency());
        System.out.println(counter.countCharacterFrequency());
    }
    
}
