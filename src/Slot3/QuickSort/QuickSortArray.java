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
        
        if (low < high) {
            int pi = partition(low, high);
            sort(low, pi - 1);
            sort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        int mid = low + (high - low) / 2;
        int pivot = array[mid];
        while (low <= high) {
            while (array[low] < pivot) low++;
            while (array[high] > pivot) high--;
            if (low <= high) {
                swap(low, high);
                low++;
                high--;
            }
        }
        return low;
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
