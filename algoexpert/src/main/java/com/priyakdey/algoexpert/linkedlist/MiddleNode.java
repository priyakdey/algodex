package com.priyakdey.algoexpert.linkedlist;

/**
 * @author Priyak Dey
 */
public class MiddleNode {

    // Take a fast pointer and a slow pointer.

    public LinkedList middleNode(LinkedList linkedList) {
        LinkedList curr = linkedList, mid = linkedList;
        while (curr != null && curr.next != null) {
            mid = mid.next;
            curr = curr.next.next;
        }

        return mid;
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }



}
