from typing import Dict, List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        element_dict: Dict[int, int] = {}

        for i, num in enumerate(nums):
            compliment = target - num
            if compliment in element_dict:
                return [element_dict[compliment], i]
            element_dict[num] = i

        return []
