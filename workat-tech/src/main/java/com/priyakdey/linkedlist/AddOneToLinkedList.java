package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 */
public class AddOneToLinkedList {

    ListNode addOneToList(ListNode head) {
        if (head == null) throw new IllegalArgumentException("list is null");

        head = reverseList(head);

        int carry = 1;
        ListNode curr = head, tail = head;

        while (curr != null) {
            int value = curr.data + carry;
            curr.data = value % 10;
            carry = value / 10;
            tail = curr;
            curr = curr.next;
        }

        if (carry == 1) {
            tail.next = new ListNode(carry);
        }

        return reverseList(head);
    }

    ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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
