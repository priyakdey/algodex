package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 */
public class MergeSortLinkedList {

    ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMiddle(head);
        ListNode left = head, right = mid.next;
        mid.next = null;
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode curr1 = left, curr2 = right;

        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (curr1 != null && curr2 != null) {
            if (curr1.data <= curr2.data) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }

        if (curr1 != null) curr.next = curr1;
        if (curr2 != null) curr.next = curr2;

        return head.next;
    }

    ListNode findMiddle(ListNode head) {
        ListNode mid = head;
        ListNode curr = head.next;

        while (curr != null && curr.next != null) {
            mid = mid.next;
            curr = curr.next.next;
        }

        return mid;
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
