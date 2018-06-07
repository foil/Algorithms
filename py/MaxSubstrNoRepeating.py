class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        d = {}
        max_len = 0
        cur_index = 0

        i = 0
        while i < len(s):
            c = s[i]
            if c in d and d[c] >= cur_index:
                cur_index = d[c] + 1
            d[c] = i

            i += 1
            if i - cur_index > max_len:
                max_len = i - cur_index

        return max_len
