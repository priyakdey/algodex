from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        min_element = nums[0]

        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] <= nums[-1]:
                min_element = nums[mid]
                right = mid - 1
            else:
                left = mid + 1

        return min_element