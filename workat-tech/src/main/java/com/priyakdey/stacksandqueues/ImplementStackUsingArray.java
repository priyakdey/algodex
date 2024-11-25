package com.priyakdey.stacksandqueues;

/**
 * @author Priyak Dey
 */
public class ImplementStackUsingArray {

    private final int[] elements;
    private final int capacity;
    private int size;

    public ImplementStackUsingArray (int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int top() {
        return size > 0 ? elements[size - 1] : -1;
    }

    public void push(int element) {
        elements[size++] = element;
    }

    public void pop() {
        size--;
    }

}
