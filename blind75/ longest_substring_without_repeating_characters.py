from typing import Dict


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        index_map: Dict[str, int] = {}
        start = 0
        max_length = 0
        for i, ch in enumerate(s):
            if ch in index_map and index_map[ch] >= start:
                max_length = max(max_length, i - 1 - start + 1)
                start = index_map[ch] + 1
            index_map[ch] = i

        max_length = max(max_length, len(s) - start)
        return max_length
