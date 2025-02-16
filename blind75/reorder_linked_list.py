from typing import Optional


class ListNode:
    """Definition for singly-linked list."""

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if head is None or head.next is None:
            return

        mid, curr = head, head.next
        while curr is not None and curr.next is not None:
            mid = mid.next
            curr = curr.next.next

        head2 = mid.next
        mid.next = None

        prev, curr = None, head2
        while curr is not None:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node

        head2 = prev

        dummy_head = ListNode()
        curr = dummy_head
        curr1, curr2 = head, head2

        while curr1 is not None and curr2 is not None:
            curr.next = curr1
            curr1 = curr1.next
            curr = curr.next

            curr.next = curr2
            curr2 = curr2.next
            curr = curr.next

        if curr1 is not None:
            curr.next = curr1

        head = dummy_head.next

