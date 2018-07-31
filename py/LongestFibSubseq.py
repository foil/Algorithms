class Solution:
    def lenLongestFibSubseq(self, A):
        """
        3 <= A.length <= 1000
        1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
        :type A: List[int]
        :rtype: int
        """
        l = len(A)
        ans = 0
        for s in range(l - 2):
            i = s
            j = i + 1
            k = i + 2
            max = 0
            while k < l:
                n = A[i] + A[j]
                if n < A[k]:
                    break
                elif n == A[k]:
                    if max == 0:
                        max = 3
                    else:
                        max += 1
                    i = j
                    j = k
                k += 1

            if max > ans:
                ans = max

        return ans