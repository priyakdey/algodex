package com.priyakdey.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Priyak Dey
 */
public class ImplementQueueUsingStacks {

    private final Deque<Integer> stack;
    private final Deque<Integer> swapper;

    private final int capacity;

    private int size;

    ImplementQueueUsingStacks (int capacity) {
        this.capacity = capacity;
        this.stack = new ArrayDeque<>(capacity);
        this.swapper = new ArrayDeque<>(capacity);
        this.size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    int front() {
        if (size == 0) return -1;

        while (stack.size() > 1) {
            swapper.push(stack.pop());
        }

        int top = stack.peek();

        while (!swapper.isEmpty()) {
            stack.push((swapper.pop()));
        }

        return top;
    }

    int back() {
        return size > 0 ? stack.peek() : -1;
    }

    void push(int element) {
        stack.push(element);
        size++;
    }

    void pop() {
        while (!stack.isEmpty()) {
            swapper.push(stack.pop());
        }

        swapper.pop();

        while (!swapper.isEmpty()) {
            stack.push(swapper.pop());
        }
        size--;
    }

}
