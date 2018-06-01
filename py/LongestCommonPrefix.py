class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if not strs:
            return ""

        min_str = min(strs, key=len)
        if not min_str:
            return ""

        for i in range(len(min_str)):
            c = min_str[i]
            for str in strs:
                if str[i] != c:
                    return min_str[0:i]

        return min_str
