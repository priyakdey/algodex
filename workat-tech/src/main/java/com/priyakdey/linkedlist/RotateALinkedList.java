package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 */
public class RotateALinkedList {

    ListNode rotateListByK(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int length = findLength(head);
        k = k % length;

        if (k == 0) return head;

        ListNode curr = head;
        int i = 0;
        while (i < length - k - 1) {
            curr = curr.next;
            i++;
        }

        ListNode temp = head;
        head = curr.next;
        ListNode next = curr.next;
        curr.next = null;

        while (next.next != null) {
            next = next.next;
        }
        next.next = temp;
        return head;
    }

    int findLength(ListNode head) {
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        return length;
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
