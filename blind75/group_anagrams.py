from collections import defaultdict
from typing import Dict, List


primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]
large_prime = 1_000_000_007
hash_seed = 5381


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        def calc_hash(s: str) -> int:
            _hash = hash_seed
            for ch in s:
                _hash = (_hash * primes[ord(ch) - ord("a")]) % large_prime
            
            return _hash

        group_map: Dict[int, List[str]] = defaultdict(list)

        for s in strs:
            _hash = calc_hash(s)
            group_map[_hash].append(s)

        groups:List[List[str]] = []
        for group in group_map.values():
            groups.append(group)

        return groups

