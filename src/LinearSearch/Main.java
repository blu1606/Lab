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
        int num;
        do {
            num = Utils.getIntValue("Enter number of Array: ");
        } while (num <= 0);
        
        Array arr = new Array(num);

        int searchValue = Utils.getIntValue("Enter search value: ");
        int res = arr.linearSearch(searchValue);

        System.out.println(arr);
        if (res == -1) {
            System.out.println("Not found!!!");
        } else System.out.println("Found "+searchValue+" at index: "+res);
    }
}
