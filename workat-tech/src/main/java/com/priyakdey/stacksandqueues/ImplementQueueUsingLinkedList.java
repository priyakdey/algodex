package com.priyakdey.stacksandqueues;

/**
 * @author Priyak Dey
 */
public class ImplementQueueUsingLinkedList {

    private final int capacity;

    private ListNode front;
    private ListNode back;
    private int size;

    ImplementQueueUsingLinkedList(int capacity) {
        this.capacity = capacity;
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    int front() {
        return size > 0 ? front.data : -1;
    }

    int back() {
        return size > 0 ? back.data : -1;
    }

    void push(int element) {
        ListNode node = new ListNode(element);
        if (size == 0) {
            front = node;
        } else {
            back.next = node;
        }
        back = node;
        size++;
    }

    void pop() {
        if (size == 1) {
            front = null;
            back = null;
        } else {
            front = front.next;
        }
        size--;
    }

    private static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

}
