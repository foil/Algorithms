class Solution:
    def advantageCount(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        db = [(i, b) for i, b in enumerate(B)]
        db.sort(key=lambda x: x[1])
        da = [(i, a) for i, a in enumerate(A)]
        da.sort(key=lambda x: x[1])

        i = 0
        l = len(A)
        ans = [-1] * l
        rest = []
        for pb in db:
            while i < len(da):
                if da[i][1] > pb[1]:
                    ans[pb[0]] = da[i][1]
                    i += 1
                    break
                else:
                    rest.append(da[i][1])
                i += 1

        for i, c in enumerate(ans):
            if c == -1:
                ans[i] = rest.pop()

        return ans