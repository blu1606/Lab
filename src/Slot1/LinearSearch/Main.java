/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinearSearch;


import Utils.Utils;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
        Array arr = new Array(Utils.getPosIntValue("Enter number of Array: "));
        int res = arr.linearSearch(Utils.getIntValue("Enter search value: "));
        System.out.println(arr);
        if (res == -1) System.out.println("Not found!!!");
        else System.out.println("Found at index: "+res);
    }
}
