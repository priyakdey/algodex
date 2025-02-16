class Solution:

    def encode(self, strs: List[str]) -> str:
        buf: List[str] = []
        for s in strs:
            buf.append(str(len(s)))
            buf.append("-")
            buf.append(s)

        return "".join(buf)

    def decode(self, s: str) -> List[str]:
        strs: List[str] = []

        cursor: int = 0
        while cursor < len(s):
            start = cursor
            while cursor < len(s) and s[cursor] != "-":
                cursor += 1
            
            # assert that this does not fail
            length = int(s[start : cursor])

            cursor += 1
            word = s[cursor : cursor + length]
            strs.append(word)
            cursor += length
        
        return strs

