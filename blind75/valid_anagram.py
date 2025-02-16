from collections import defaultdict
from typing import Dict


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        def to_freq_map(word: str) -> Dict[str, int]:
            freq_map: Dict[str, int] = defaultdict(int)

            for ch in word:
                freq_map[ch] += 1
            
            return freq_map

        s_freq_map = to_freq_map(s)
        t_freq_map = to_freq_map(t)

        if len(s_freq_map) != len(t_freq_map):
            return False

        for ch, freq in s_freq_map.items():
            if ch not in t_freq_map or freq != t_freq_map[ch]:
                return False

        return True

