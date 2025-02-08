from typing import List, Optional


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        def can_partition(
            start: int, end: int, cache: List[List[Optional[bool]]]
        ) -> bool:
            nonlocal s, words

            word = s[start:end]

            if start == len(s) - 1 or end == len(s):
                return word in words

            if cache[start][end] is not None:
                return cache[start][end]

            can_break = False

            if word in words:
                can_break = can_partition(end, end + 1, cache)

            can_break = can_break or can_partition(start, end + 1, cache)
            cache[start][end] = can_break
            return can_break

        words = set(wordDict)
        cache = [[None for _ in range(len(s) + 1)] for _ in range(len(s) + 1)]
        return can_partition(0, 1, cache)
