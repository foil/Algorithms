class Solution:
    def nthMagicalNumber(self, N, A, B):
        """
        :type N: int
        :type A: int
        :type B: int
        :rtype: int
        """
        mod = 10 ** 9 + 7
        if A == B:
            return A * N % mod

        mi = min(A, B)
        ma = A + B - mi

        n = 1
        s1 = mi
        s2 = ma
        r = s1
        while n < N:
            s1 += mi
            if s1 >= s2:
                if s1 > s2:
                    n += 1
                    if n == N:
                        r = s2
                        break
                s2 += ma

            n += 1
            if n == N:
                r = s1
                break

        return r % mod