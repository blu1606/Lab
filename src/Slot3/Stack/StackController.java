/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Stack;

import Utils.Menu;
import Utils.Utils;
/**
 *
 * @author LENOVO
 */
public class StackController extends Menu {
    Stack stack;
    static String[] operations = {
        "Push",
        "Pop",
        "Get",
        "Is Empty",
        "Display Stack"
    };
    public StackController() {
        super("Enter Stack Operation:", operations);
        stack = new Stack();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 -> {
                int value = Utils.getIntValue("Enter value to push: ");
                stack.push(value);
            }
            case 2 -> {
                stack.pop();
            }
            case 3 -> {
                System.out.println("Top value: " + stack.get());
            }
            case 4 -> {
                if (stack.isEmpty()) System.out.println("Stack is empty!");
                else System.out.println("Stack is not empty!");
            }
            case 5 -> {
                System.out.println("Stack contents: " + stack);
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }
}
