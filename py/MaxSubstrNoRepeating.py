class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        d = {}
        max_len = 0
        max_index = 0
        cur_index = 0
        for i, c in enumerate(s):
            if len(d) == 0:
                cur_index = i
                d[c] = True
                max_len = 1
            else:
                if c in d:
                    if len(d) > max_len:
                        max_len = len(d)
                        max_index = cur_index
                    d = {c: True}
                    cur_index = i
                else:
                    d[c] = True
                    if len(d) > max_len:
                        max_len = len(d)

        return max_len
