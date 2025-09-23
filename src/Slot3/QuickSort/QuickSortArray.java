/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package QuickSort;

import java.util.Arrays;

/**
 *
 * @author LENOVO
 */
public class QuickSortArray {
    private final int[] array;

    public QuickSortArray(int[] array) {
        this.array = array;
    }

    public void sort(int low, int high) {
        int mid = low + (high - low) / 2;
        if (low < high) {
            int pi = partition(low, high, mid);
            sort(low, pi - 1);
            sort(pi + 1, high);
        }
    }

    private int partition(int low, int high, int mid) {
        int pivot = array[mid];
        swap(mid, high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] getSortedArray() {
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    
}
