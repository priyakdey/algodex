package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 */
public class ReverseALinkedListII {

    ListNode reverseLinkedListRange(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prevNode = dummyHead, leftNode = head, rightNode = head;
        ListNode curr = head;
        int i = 1;

        while (curr != null) {
            if (i < left) {
                prevNode = curr;
            } else if (i == left) {
                leftNode = curr;
            } else if (i == right) {
                rightNode = curr;
            }

            i++;
            curr = curr.next;
        }

        assert (rightNode != null);

        prevNode.next = null;
        ListNode nextNode = rightNode.next;
        rightNode.next = null;

        ListNode[] nodes = reverseList(leftNode);
        prevNode.next = nodes[0];
        nodes[1].next = nextNode;
        return dummyHead.next;
    }

    private ListNode[] reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return new ListNode[]{prev, head};
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
