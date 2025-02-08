from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()

        triplets: List[List[int]] = []

        for i in range(len(nums) - 2):
            if i - 1 >= 0 and nums[i] == nums[i - 1]:
                continue

            j, k = i + 1, len(nums) - 1
            while j < k:
                if j > i + 1 and nums[j] == nums[j - 1]:
                    j += 1
                    continue

                _sum = nums[i] + nums[j] + nums[k]
                if _sum == 0:
                    triplets.append([nums[i], nums[j], nums[k]])
                    j += 1
                    k -= 1
                elif _sum > 0:
                    k -= 1
                else:
                    j += 1

        return triplets
