package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 */
public class PartitionList {

    ListNode partitionList(ListNode head, int key) {
        if (head == null || head.next == null) return head;

        ListNode head1 = new ListNode(0);
        ListNode curr1 = head1;

        ListNode head2 = new ListNode(0);
        ListNode curr2 = head2;

        ListNode head3 = new ListNode(0);
        ListNode curr3 = head3;

        ListNode curr = head;

        while (curr != null) {
            if (curr.data < key) {
                curr1.next = curr;
                curr1 = curr1.next;
            } else if (curr.data == key) {
                curr2.next = curr;
                curr2 = curr2.next;
            } else {
                curr3.next = curr;
                curr3 = curr3.next;
            }
            curr = curr.next;
        }

        curr1.next = null;
        curr2.next = null;
        curr3.next = null;

        if (head3.next != null) {
            curr2.next = head3.next;
        }
        if (head2.next != null) {
            curr1.next = head2.next;
        }
        return head1.next;
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


