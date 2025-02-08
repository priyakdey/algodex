from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        max_till, min_till = nums[0], nums[0]
        max_overall = nums[0]

        for i in range(1, len(nums)):
            num = nums[i]
            if num == 0:
                local_max = 0
                local_min = 0
            else:
                local_max = max(num, num * max_till, num * min_till)
                local_min = min(num, num * max_till, num * min_till)

            max_till = local_max
            min_till = local_min
            max_overall = max(max_overall, max_till)

        return max_overall
