class Solution:
    def fairCandySwap(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        sa = sum(A)
        sb = sum(B)
        t = (sa + sb) / 2
        A.sort()
        B.sort()
        i = 0
        j = 0
        while i < len(A) and j < len(B):
            if sa + B[j] - A[i] < t:
                j+=1
            elif sa + B[j] - A[i] > t:
                i+=1
            else:
                return [A[i], B[j]]