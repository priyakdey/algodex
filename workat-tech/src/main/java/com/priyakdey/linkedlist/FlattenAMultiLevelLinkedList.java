package com.priyakdey.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Priyak Dey
 */
public class FlattenAMultiLevelLinkedList {

    ListNode flattenTheLinkedList(ListNode root) {
        ListNode curr = root;
        PriorityQueue<ListNode> heap =
                new PriorityQueue<>(Comparator.comparing(node -> node.data));

        while (curr != null) {
            heap.offer(curr);
            curr = curr.next;
        }

        ListNode head = new ListNode(0);
        curr = head;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            curr.next = node;
            curr = curr.next;

            if (node.down != null) {
                heap.offer(node.down);
            }
        }

        return head.next;
    }

    static class ListNode {
        int data;
        ListNode next;
        ListNode down;

        ListNode(int data) {
            this.data = data;
            this.next = null;
            this.down = null;
        }
    }

}
