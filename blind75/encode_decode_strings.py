from typing import List


class Codec:

    DELIMITER: str = "-"

    def encode(self, strs: List[str]) -> str:
        """Encodes a list of strings to a single string."""
        buf: List[str] = [""] * len(strs) * 2
        cursor: int = 0
        for s in strs:
            buf[cursor] = str(len(s)) + Codec.DELIMITER
            cursor += 1
            buf[cursor] = s
            cursor += 1

        return "".join(buf)

    def decode(self, s: str) -> List[str]:
        """Decodes a single string to a list of strings."""
        strs: List[str] = []

        cursor: int = 0
        start: int = 0
        while cursor < len(s):
            while cursor < len(s) and s[cursor].isdigit():
                cursor += 1

            if s[cursor] != Codec.DELIMITER:
                raise Exception("invalid input")

            length = int(s[start:cursor])
            cursor += 1  # skip the delimiter
            strs.append(s[cursor : cursor + length])
            cursor += length
            start = cursor

        return strs
