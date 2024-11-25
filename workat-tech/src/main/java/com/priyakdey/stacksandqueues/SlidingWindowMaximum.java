package com.priyakdey.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class SlidingWindowMaximum {

    @SuppressWarnings("ConstantConditions")
    int[] maxSlidingWindow(int[] A, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < A[i]) {
                deque.pollLast();
            }
            deque.offerLast(A[i]);
        }

        int[] maxes = new int[A.length - k + 1];
        maxes[0] = deque.peekFirst();

        for (int i = k; i < A.length; i++) {
            if (deque.peekFirst() == A[i - k]) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && deque.peekLast() < A[i]) {
                deque.pollLast();
            }
            deque.offerLast(A[i]);
            maxes[i - k + 1] = deque.peekFirst();
        }

        return maxes;
    }
}
