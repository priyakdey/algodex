from typing import List, Set


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        distinct: Set[int] = set(nums)
        max_length = 0

        for num in nums:
            if num in distinct:
                distinct.remove(num)
                right = num + 1
                while right in distinct:
                    distinct.remove(right)
                    right += 1

                left = num - 1
                while left in distinct:
                    distinct.remove(left)
                    left -= 1

                length = right - 1 - (left + 1) + 1
                max_length = max(max_length, length)

        return max_length
