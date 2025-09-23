/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package QuickSort;

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
        int array[] = Utils.getArray("Enter element");
        QuickSortArray quickSort = new QuickSortArray(array);

        System.out.println("Unsorted array:" + quickSort);
        quickSort.sort(0, array.length - 1);
        System.out.println("Sorted array:" + quickSort);
    }

}
