from typing import List, Optional


class ListNode:
    """Definition for singly-linked list."""

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class MinHeap:

    def __init__(self, capacity: int):
        self.heap: List[Optional[ListNode]] = [None] * capacity
        self.size: int = 0
        self.capacity: int = capacity

    def push(self, node: ListNode) -> None:
        self.heap[self.size] = node
        self.size += 1

        curr = self.size - 1
        while curr > 0:
            parent = (curr - 1) // 2
            if self.heap[curr].val < self.heap[parent].val:
                self.heap[parent], self.heap[curr] = self.heap[curr], self.heap[parent]
            else:
                break
            curr = parent

    def pop(self) -> ListNode:
        root = self.heap[0]
        self.heap[0] = self.heap[self.size - 1]
        self.size -= 1

        curr = 0
        while curr < self.size:
            left, right = 2 * curr + 1, 2 * curr + 2
            if left >= self.size:
                break

            swap_index = left
            if right < self.size and self.heap[right].val < self.heap[left].val:
                swap_index = right

            if self.heap[swap_index].val < self.heap[curr].val:
                self.heap[swap_index], self.heap[curr] = (
                    self.heap[curr],
                    self.heap[swap_index],
                )
            else:
                break
            curr = swap_index

        return root

    def __len__(self) -> int:
        return self.size


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode(0)
        curr = dummy
        heap = MinHeap(len(lists))

        for _list in lists:
            if _list is not None:
                heap.push(_list)

        dummy = ListNode(0)
        curr = dummy

        while len(heap) > 0:
            node = heap.pop()
            curr.next = node
            curr = curr.next

            if node.next is not None:
                heap.push(node.next)

        return dummy.next
