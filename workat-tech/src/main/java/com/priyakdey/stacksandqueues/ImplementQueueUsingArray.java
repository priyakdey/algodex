package com.priyakdey.stacksandqueues;

/**
 * @author Priyak Dey
 */
public class ImplementQueueUsingArray {

    private final int[] elements;
    private final int capacity;
    private int size;

    ImplementQueueUsingArray (int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
        this.size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    int front() {
        return size > 0 ? elements[0] : -1;
    }

    int back() {
        return size > 0 ? elements[size - 1] : -1;
    }

    void push(int element) {
        elements[size++] = element;
    }

    void pop() {
        for (int i = 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
    }

}
