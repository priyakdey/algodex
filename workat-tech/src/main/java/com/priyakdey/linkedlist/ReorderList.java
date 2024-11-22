package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 */
public class ReorderList {

    ListNode reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode mid = findMid(head);

        ListNode next = mid.next;
        mid.next = null;
        next = reverseList(next);

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        ListNode curr1 = head, curr2 = next;

        while (curr1 != null && curr2 != null) {
            curr.next = curr1;
            curr1 = curr1.next;
            curr = curr.next;

            curr.next = curr2;
            curr2 = curr2.next;
            curr = curr.next;
        }

        if (curr1 != null) curr.next = curr1;
        return dummyHead.next;
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

    ListNode findMid(ListNode head) {
        ListNode mid = head, curr = head.next;

        while (curr != null && curr.next != null) {
            curr = curr.next.next;
            mid = mid.next;
        }

        return mid;
    }


    class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
