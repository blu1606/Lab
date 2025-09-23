/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package BubbleSort;

import Utils.Utils;

/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BubbleSortArray bubbleSort = new BubbleSortArray(Utils.getArray("Enter element"));
        System.out.println("Unsorted array:" + bubbleSort);
        bubbleSort.sort();
        System.out.println("Sorted array:" + bubbleSort);
    }

}
