/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinearSearch;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of Array: ");
        int num = Integer.parseInt(scanner.nextLine()); 
        Array arr = new Array(num);
        System.out.println("Enter search value: ");
        int searchValue = Integer.parseInt(scanner.nextLine()); 
        int res = arr.linearSearch(searchValue);
        System.out.println(arr);
        if (res == -1) {
            System.out.println("Not found!!!");
        } else System.out.println("Found "+searchValue+"at index: "+res);
    }
}
