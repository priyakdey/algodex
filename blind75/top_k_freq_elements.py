import typing
from collections import Counter
from heapq import heappop, heappush
from typing import List, Tuple


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_map: typing.Counter[int] = Counter(nums)

        heap: List[Tuple[int, int]] = []

        for num, freq in freq_map.items():
            heappush(heap, (freq, num))
            if len(heap) > k:
                heappop(heap)
        print(freq_map, heap)
        top_k_elements = [0] * k
        curr = 0
        while len(heap) > 0:
            _, num = heappop(heap)
            top_k_elements[curr] = num
            curr += 1
            
        return top_k_elements

