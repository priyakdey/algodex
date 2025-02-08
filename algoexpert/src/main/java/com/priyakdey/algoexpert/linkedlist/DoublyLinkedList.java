package com.priyakdey.algoexpert.linkedlist;

public class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
        if (node == head) return;

        if (node == tail) {
            Node prev = tail.prev;
            prev.next = null;
            tail = prev;
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        } else if (node.next == null && node.prev == null) {
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void setTail(Node node) {
        if (node == tail) return;

        if (node == head) {
            Node next = head.next;
            next.prev = null;
            head = next;
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else if (node.next == null && node.prev == null) {
            node.prev = tail;
            tail.next = node;
            tail = node;
        } else {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    public void insertBefore(Node node, Node nodeToInsert) {

    }

    public void insertAfter(Node node, Node nodeToInsert) {
        // Write your code here.
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        // Write your code here.
    }

    public void removeNodesWithValue(int value) {

    }

    public void remove(Node node) {
        if (node == head) {
            head = head.next;

        }
    }

    public boolean containsNodeWithValue(int value) {
        // Write your code here.
        return false;
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}