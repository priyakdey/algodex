package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 */
public class RemoveLoopFromLinkedList {

    void removeLoop(ListNode list) {
        if (list == null || list.next == null) return;

        ListNode fast = list, slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast != slow) return;

        fast = list;
        ListNode prev = null;

        while (fast != slow) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }

        if (prev != null)
            prev.next = null;
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
