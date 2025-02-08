from typing import Optional


class ListNode:
    """Definition for singly-linked list."""

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        curr = head
        while curr is not None and n > 1:
            curr = curr.next
            n -= 1

        if curr is None:
            raise Exception("not enough nodes")

        dummy_head = ListNode()
        dummy_head.next = head
        prev = dummy_head
        node = head
        while curr.next is not None:
            prev = node
            node = node.next
            curr = curr.next

        prev.next = node.next
        return dummy_head.next
