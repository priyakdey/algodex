from typing import List


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        total = sum(nums)
        n = len(nums)

        return n * (n + 1) // 2 - total

