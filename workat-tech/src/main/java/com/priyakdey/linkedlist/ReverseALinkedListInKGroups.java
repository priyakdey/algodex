package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 */
public class ReverseALinkedListInKGroups {

    ListNode reverseLinkedListKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode attachTo = dummyHead;
        ListNode curr = head;

        int size = 1;

        while (curr != null) {
            ListNode next = curr.next;
            if (size == k) {
                curr.next = null;
                ListNode[] nodes = reverseList(attachTo.next);
                ListNode groupHead = nodes[0];
                ListNode groupTail = nodes[1];

                attachTo.next = groupHead;
                groupTail.next = next;
                attachTo = groupTail;
                size = 0;
            }

            curr = next;
            size++;
        }

        return dummyHead.next;
    }


    private ListNode[] reverseList(ListNode head) {
        ListNode tail = head;
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return new ListNode[]{prev, tail};
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
