from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = (right - left) // 2 + left
            if nums[mid] == target:
                return mid

            if nums[mid] <= nums[-1]:
                if target < nums[mid]:
                    right = mid - 1
                else:
                    if target <= nums[-1]:
                        left = mid + 1
                    else:
                        right = mid - 1
            else:
                if target < nums[mid]:
                    if target > nums[-1]:
                        right = mid - 1
                    else:
                        left = mid + 1
                else:
                    left = mid + 1

        return -1

