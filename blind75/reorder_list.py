from typing import Optional


class ListNode:
    """Definition for singly-linked list."""

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        def find_mid(head: ListNode) -> ListNode:
            mid, curr = head, head.next

            while curr is not None and curr.next is not None:
                mid = mid.next
                curr = curr.next.next

            return mid

        def reverse_list(head: ListNode) -> ListNode:
            prev, curr = None, head

            while curr is not None:
                next_node = curr.next
                curr.next = prev
                prev = curr
                curr = next_node

            return prev

        if head is None or head.next is None or head.next.next is None:
            return

        mid = find_mid(head)
        head2 = mid.next
        mid.next = None
        head2 = reverse_list(head2)

        prev, curr1 = head, head.next
        curr2 = head2

        while curr1 is not None:
            next_node = curr2.next
            prev.next = curr2
            curr2.next = curr1
            prev = curr1
            curr1 = curr1.next
            curr2 = next_node

        if curr2 is not None:
            prev.next = curr2
