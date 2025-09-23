/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BinarySearch;

import java.util.Arrays;

/**
 *
 * @author LENOVO
 */
public class BinarySearchArray {
    private final int[] array;

    public BinarySearchArray(int[] array) {
        this.array = array;
    }

    public int getSearchValue(int value) {
        Arrays.sort(array);
        return binarySearch(value);
    }

    private int binarySearch(int value) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == value) return mid;
            if (array[mid] < value) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }


    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    
}
