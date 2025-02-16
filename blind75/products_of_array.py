from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix_product, suffix_product = 1, 1
        left, right = 1, len(nums) - 2

        products: List[int] = [1] * len(nums)

        while left < len(nums):
            prefix_product *= nums[left - 1]
            products[left] *= prefix_product
            left += 1
            
            suffix_product *= nums[right + 1]
            products[right] *= suffix_product
            right -= 1
            
        return products

