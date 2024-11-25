package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 */
public class InsertionSortLinkedList {

    ListNode insertionSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = head, curr = head.next;

        while (curr != null) {
            ListNode next = curr.next;

            ListNode p = dummy, c = dummy.next;

            while (c != curr && c.data < curr.data) {
                p = c;
                c = c.next;
            }

            if (c != curr) {
                p.next = curr;
                curr.next = c;
                prev.next = next;
                prev = next;
                if (next != null) {
                    curr = next.next;
                } else {
                    curr = null;
                }

            } else {
                prev.next = curr;
                curr = next;
            }
        }

        return dummy.next;
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
