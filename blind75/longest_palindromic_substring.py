class Solution:
    def longestPalindrome(self, s: str) -> str:
        max_length = 1

        left, right = 0, 1

        for i in range(len(s)):
            # odd length
            l, r = i - 1, i + 1
            while l >= 0 and r < len(s) and s[l] == s[r]:
                l -= 1
                r += 1

            length = r - (l + 1)
            if length > max_length:
                max_length = length
                left, right = l + 1, r

            # even length
            if i + 1 < len(s) and s[i] == s[i + 1]:
                l, r = i - 1, i + 2
                while l >= 0 and r < len(s) and s[l] == s[r]:
                    l -= 1
                    r += 1

                length = r - (l + 1)
                if length > max_length:
                    max_length = length
                    left, right = l + 1, r

        return s[left:right]
