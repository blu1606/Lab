/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Stack;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Stack {
    private final ArrayList<Integer> stackValues;

    public Stack() {
        stackValues = new ArrayList<>();
    }

    public void push(int value) {
        System.out.println("Pushing " + value + " to the stack.");
        stackValues.add(value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = stackValues.remove(stackValues.size() - 1);
        System.out.println("Popping " + value + " from the stack.");
        return value;
    }

    public int get() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackValues.get(stackValues.size() - 1);
    }
    
    public boolean isEmpty() {
        return stackValues.isEmpty();
    }

    @Override
    public String toString() {
        return stackValues.toString();
    }
}
