from typing import List, Set


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        elements: Set[int] = set(nums)
        max_length = 0

        for num in nums:
            if num not in elements: 
                continue
            
            left, right = num, num + 1
            while left in elements:
                elements.remove(left)
                left -= 1

            while right in elements:
                elements.remove(right)
                right += 1

            length = right - 1 - (left + 1) + 1
            max_length = max(max_length, length)

        return max_length

