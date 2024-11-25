package com.priyakdey.stacksandqueues;

/**
 * @author Priyak Dey
 */
public class ImplementStackUsingLinkedList {

    private final int capacity;

    private ListNode head;
    private ListNode tail;  // top
    private int size;

    public ImplementStackUsingLinkedList(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int top() {
        return size > 0 ? tail.data : -1;
    }

    public void push(int element) {
        ListNode node = new ListNode(element);
        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void pop() {
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            ListNode curr = head;
            while (curr.next != tail) {
                curr = curr.next;
            }
            curr.next = null;
            tail = curr;
        }
        size--;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

}
