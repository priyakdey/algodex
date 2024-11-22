package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 */
public class FindXthNodeFromEndOfLinkedList {

    ListNode xthNodeFromEnd(ListNode head, int x) {
        ListNode offset = head;

        while (offset != null && x > 1) {
            offset = offset.next;
            x--;
        }

        assert offset != null;

        ListNode curr = head;

        while (offset.next != null) {
            curr = curr.next;
            offset = offset.next;
        }

        return curr;
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
