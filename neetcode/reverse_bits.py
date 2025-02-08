class Solution:
    def reverseBits(self, n: int) -> int:
        reverse = 0
        for i in range(32):
            reverse = reverse | ((n & 1) << (31 - i)) 
            n = n >> 1

        return reverse

