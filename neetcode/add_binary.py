class Solution:
    def addBinary(self, a: str, b: str) -> str:
        def _add_binary(x: str, y: str, z: str) -> Tuple[str, str]:
            match (x, y, z):
                case ("0", "0", "0"): return "0", "0"
                case ("0", "0", "1"): return "1", "0"
                case ("0", "1", "0"): return "1", "0"
                case ("0", "1", "1"): return "0", "1"
                case ("1", "0", "0"): return "1", "0"
                case ("1", "0", "1"): return "0", "1"
                case ("1", "1", "0"): return "0", "1"
                case ("1", "1", "1"): return "1", "1"
                case _: raise Exception("invalid input")
        
        buf: List[str] = []
        i, j = len(a) - 1, len(b) - 1
        carry = "0"
        while i >= 0 and j >= 0:
            value, carry = _add_binary(a[i], b[j], carry)
            buf.append(value)
            i -= 1
            j -= 1

        while i >= 0:
            value, carry = _add_binary(a[i], "0", carry)
            buf.append(value)
            i -=1

        while j >= 0:
            value, carry = _add_binary("0", b[j], carry)
            buf.append(value)
            j -=1

        if carry == "1":
            buf.append("1")

        return "".join(buf[::-1])

