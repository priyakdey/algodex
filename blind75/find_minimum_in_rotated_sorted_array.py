from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        assert len(nums) > 0
        min_element = nums[0] 
        while left <= right:
            mid = left + (right - left) // 2
            while left <= right and nums[left] == nums[right]:
                min_element = min(min_element, nums[left])
                left += 1

            if nums[mid] < nums[-1]:
                min_element = nums[mid]
                right -= 1
            else:
                left += 1
        
        return min_element

