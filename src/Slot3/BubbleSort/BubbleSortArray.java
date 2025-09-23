/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BubbleSort;

import java.util.Arrays;

/**
 *
 * @author LENOVO
 */
public class BubbleSortArray {
    private final int[] array;
    public BubbleSortArray(int[] array) {
        this.array = array;
    }

    public void sort() {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public int[] getSortedArray() {
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    
}
