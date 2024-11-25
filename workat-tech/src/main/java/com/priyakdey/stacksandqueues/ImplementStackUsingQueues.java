package com.priyakdey.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class ImplementStackUsingQueues {

    private final Deque<Integer> queue;
    private final Deque<Integer> swapper;

    private final int capacity;

    private int size;

    public ImplementStackUsingQueues(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayDeque<>(capacity);
        this.swapper = new ArrayDeque<>(capacity);
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int top() {
        if (size == 0) return -1;

        while (queue.size() > 1) {
            swapper.offer(queue.poll());
        }

        int top = queue.peek();

        swapper.offer(queue.poll());

        while (!swapper.isEmpty()) {
            queue.offer(swapper.poll());
        }

        return top;
    }

    public void push(int element) {
        queue.offer(element);
        size++;
    }

    public void pop() {
        if (size == 0) return;

        while (queue.size() > 1) {
            swapper.offer(queue.poll());
        }

        queue.poll();

        while (!swapper.isEmpty()) {
            queue.offer(swapper.poll());
        }

        size--;
    }
}
