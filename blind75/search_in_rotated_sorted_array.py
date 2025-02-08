from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        index = -1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                index = mid
                break
            if target < nums[mid]:
                if nums[mid] <= nums[-1]:

