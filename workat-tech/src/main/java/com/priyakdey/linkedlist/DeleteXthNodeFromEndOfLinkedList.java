package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 */
public class DeleteXthNodeFromEndOfLinkedList {

    ListNode removeXthNodeFromEnd(ListNode head, int x) {
        ListNode offset = head;

        while (offset != null && x > 1) {
            offset = offset.next;
            x--;
        }

        assert offset != null;

        ListNode curr = head, prev = null;

        while (offset.next != null) {
            prev = curr;
            curr = curr.next;
            offset = offset.next;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = curr.next;
        }

        return head;
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
