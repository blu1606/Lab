/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package BinarySearch;

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
        BinarySearchArray binarySearch = new BinarySearchArray(Utils.getArray("Enter element"));
        int res = binarySearch.getSearchValue(Utils.getPosIntValue("Enter the value to search: "));
        System.out.println("Sorted array:" + binarySearch);
        if (res == -1) System.out.println("Value not found!");
        else System.out.println("Value found at index: " + res);
    }

}
