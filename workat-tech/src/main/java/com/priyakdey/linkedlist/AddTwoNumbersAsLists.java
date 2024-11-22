package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 */
public class AddTwoNumbersAsLists {

    ListNode addTwoNumbers(ListNode firstList, ListNode secondList) {
        if (firstList == null && secondList == null) return null;
        if (firstList == null) return secondList;
        if (secondList == null) return firstList;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        ListNode curr1 = firstList;
        ListNode curr2 = secondList;

        int carry = 0;

        while (curr1 != null && curr2 != null) {
            int value = curr1.data + curr2.data + carry;
            curr.next = new ListNode(value % 10);
            curr = curr.next;
            carry = value / 10;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int value = curr1.data + carry;
            curr.next = new ListNode(value % 10);
            curr = curr.next;
            carry = value / 10;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int value = curr2.data + carry;
            curr.next = new ListNode(value % 10);
            curr = curr.next;
            carry = value / 10;
            curr2 = curr2.next;
        }

        if (carry == 1) {
            curr.next = new ListNode(1);
        }

        return dummy.next;
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
