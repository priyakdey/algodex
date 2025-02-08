package com.priyakdey.algoexpert.linkedlist;

/**
 * @author Priyak Dey
 */
public class Rearrange {

    // create 3 linkedlist, less than, equal and greater than. Then checking
    // which list has data, just fill them up.

    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        LinkedList lt = new LinkedList(k - 1);
        LinkedList eq = new LinkedList(k);
        LinkedList gt = new LinkedList(k + 1);

        LinkedList curr1 = lt, curr2 = eq, curr3 = gt;
        LinkedList curr = head;

        while (curr != null) {
            if (curr.value < k) {
                curr1.next = curr;
                curr1 = curr1.next;
            } else if (curr.value == k) {
                curr2.next = curr;
                curr2 = curr2.next;
            } else {
                curr3.next = curr;
                curr3 = curr3.next;
            }

            curr = curr.next;
        }

        if (lt.next != null) {
            head = lt.next;
            if (eq.next != null) {
                curr1.next = eq.next;
                curr2.next = gt.next;
            } else {
                curr1.next = gt.next;
            }
        } else if (eq.next != null) {
            head = eq.next;
            curr2.next = gt.next;
        } else {
            head = gt.next;
        }

        curr3.next = null;
        return head;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

}
