package com.priyakdey.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private final Deque<Pair> stack = new ArrayDeque<>();

    void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Pair(x, x));
        } else {
            int min = getMin();
            stack.push(new Pair(x, Math.min(x, min)));
        }
    }

    void pop() {
        stack.pop();
    }

    int top() {
        return stack.peek().value;
    }

    int getMin() {
        return stack.peek().min;
    }

    private record Pair(int value, int min) {
    }
}