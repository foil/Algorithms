class Solution:
    def findAndReplacePattern(self, words, pattern):
        """
        :type words: List[str]
        :type pattern: str
        :rtype: List[str]
        """
        ans = []

        for w in words:
            r = True
            d = {c: None for c in pattern}
            rd = {c: None for c in w}
            for i, c in enumerate(w):
                if d[pattern[i]] and d[pattern[i]] != c:
                    r = False
                    break
                if rd[c] and rd[c] != pattern[i]:
                    r = False
                    break
                d[pattern[i]] = c
                rd[c] = pattern[i]
            if r:
                ans.append(w)

        return ans