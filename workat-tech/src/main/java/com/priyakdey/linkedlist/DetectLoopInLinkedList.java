package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 */
public class DetectLoopInLinkedList {

    ListNode getStartingNodeOfLoop(ListNode list) {
        if (list == null || list.next == null) return null;

        ListNode fast = list, slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast != slow) return null;

        fast = list;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
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
