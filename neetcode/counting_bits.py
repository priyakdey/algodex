from typing import List


class Solution:
    def countBits(self, n: int) -> List[int]:
        if n == 0: 
            return [0]
        if n == 1:
            return [0, 1]

        count: List[int] = [0] * (n + 1)
        count[0] = 0
        count[1] = 1
        
        prev_power = 1
        
        for i in range(2, n + 1):
            if prev_power << 1 == i:
                count[i] = 1
                prev_power <<= 1
            else:
                count[i] = 1 + count[i - prev_power]

        return count

