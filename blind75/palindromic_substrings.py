class Solution:
    def countSubstrings(self, s: str) -> int:
        count = 0

        for i in range(len(s)):
            count += 1

            left, right = i - 1, i + 1
            while left >= 0 and right < len(s) and s[left] == s[right]:
                count += 1
                left -= 1
                right += 1

            if i + 1 < len(s) and s[i] == s[i + 1]:
                count += 1

                left, right = i - 1, i + 2
                while left >= 0 and right < len(s) and s[left] == s[right]:
                    count += 1
                    left -= 1
                    right += 1

        return count
