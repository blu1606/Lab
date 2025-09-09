/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinearSearch;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author LENOVO
 */
public class Array {
    private int size;
    private int arr[];
    Random random = new Random();

    public Array(int size) {
        arr = new int[size];
        generateRandomArray(size);
    }
    
    
    public final void generateRandomArray(int size) {
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 2);
        }
    }

    public int[] getArr() {
        return arr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
    
    public int linearSearch(int value) {
        for (int i = 0; i < arr.length; ++i) 
            if (arr[i] == value) return i;
        return -1; // not found!!!
    }

    @Override
    public String toString() {
        return "The array: [" + Arrays.toString(arr) + "]";
    }
    
    
}
