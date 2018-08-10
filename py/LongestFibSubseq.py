class Solution:
    def lenLongestFibSubseq(self, A):
        """
        3 <= A.length <= 1000
        1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
        :type A: List[int]
        :rtype: int
        """
        def bsearch(arr, n, s):
            e = len(arr) - 1
            while s <= e:
                m = (s + e) // 2
                if arr[m] > n:
                    e = m - 1
                elif arr[m] < n:
                    s = m + 1
                else:
                    return m

            return -1

        l = len(A)
        dp = []
        for i in range(l):
            dp.append([0] * l)

        dict = {x: i for i, x in enumerate(A)}
        for j in range(1, l):
            for i in range(0, j):
                n = A[i] + A[j]
                # k = bsearch(A, n, j)
                k = dict.get(n, None)
                if k:
                    dp[j][k] = 3 if dp[i][j] == 0 else dp[i][j] + 1

        return max(map(max, dp))
