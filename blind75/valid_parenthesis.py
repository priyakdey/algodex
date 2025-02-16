from collections import deque
from typing import Deque, Dict


class Solution:
    def isValid(self, s: str) -> bool:
        mappings: Dict[str, str] = {")": "(", "}": "{", "]": "["}
        stack: Deque[str] = deque()

        for ch in s:
            if ch in mappings:
                if len(stack) == 0 or stack.pop() != mappings[ch]:
                    return False
            else:
                stack.append(ch)


        return len(stack) == 0

