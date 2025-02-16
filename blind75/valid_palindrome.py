class Solution:
    def isPalindrome(self, s: str) -> bool:
        left, right = 0, len(s) - 1
        
        while left < right:
            ch1, ch2 = s[left], s[right]
            if ch1.isalnum() and ch2.isalnum():
                if ch1.lower() != ch2.lower():
                    return False
                left += 1
                right -= 1
            elif ch1.isalnum() and not ch2.isalnum():
                right -= 1
            if not ch1.isalnum() and ch2.isalnum():
                left += 1
            if not ch1.isalnum() and not ch2.isalnum():
                left += 1
                right -= 1

        return True

