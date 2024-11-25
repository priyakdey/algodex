package com.priyakdey.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {

    int[] getNextGreaterElement(int[] A) {
        Deque<Pair> stack = new ArrayDeque<>();
        int[] nextGreater = new int[A.length];
        Arrays.fill(nextGreater, -1);

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && stack.peek().value < A[i]) {
                Pair pair = stack.pop();
                nextGreater[pair.index] = A[i];
            }
            stack.push(new Pair(A[i], i));
        }

        return nextGreater;
    }

    private record Pair(int value, int index) {
    }

}