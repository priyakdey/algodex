package com.priyakdey.algoexpert.linkedlist;

/**
 * @author Priyak Dey
 */
public class Zip {

    public LinkedList zipLinkedList(LinkedList linkedList) {
        
        return null;
    }
    


    private LinkedList reverse(LinkedList linkedList) {
        LinkedList curr = linkedList, prev = null;

        while (curr != null) {
            LinkedList next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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
