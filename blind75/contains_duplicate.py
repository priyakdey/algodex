from typing import List, Set


class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        seen: Set[int] = set()
        for num in nums:
            if num in seen:
                return True
            seen.add(num)

        return False

