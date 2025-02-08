package com.priyakdey.algoexpert.linkedlist;

/**
 * @author Priyak Dey
 */
public class RemoveDuplicates {

    // Take one pointer at a node and iterate till we find node.value,
    // then cut of the streak and keep node.

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList curr = linkedList;

        while (curr != null) {
            LinkedList node = curr;
            do {
                curr = curr.next;
            } while (curr != null && curr.value == node.value);

            node.next = curr;
        }

        return linkedList;
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
