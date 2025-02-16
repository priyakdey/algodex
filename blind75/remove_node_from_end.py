from typing import List, Optional


class listnode:
    """definition for singly-linked list."""
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNthFromEnd(self, head: Optional[listnode], n: int) -> Optional[listnode]:
        tail = head
        while tail is not None and n > 1:
            tail = tail.next
            n -= 1

        if tail is None:
            raise exception("not enough nodes")
        
        prev, curr = None, head
        while tail.next is not None:
            prev = curr
            curr = curr.next
            tail = tail.next

        if curr == head:
            return head.next
           
        prev.next = curr.next
        return head


