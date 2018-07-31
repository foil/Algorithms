class Solution:
    def minEatingSpeed(self, piles, H):
        """
        :type piles: List[int]
        :type H: int
        :rtype: int
        """
        piles.sort()
        l = len(piles)
        if H == l:
            return piles[-1]
        delta = H - l
        s = 0
        e = l - 1
        while s <= e:
            m = (s + e) // 2
            d = 0
            for i in range(m + 1, l):
                d += (piles[i] + piles[m] - 1) // piles[m] - 1
            if d > delta:
                s = m + 1
            elif d < delta:
                e = m - 1
            else:
                return piles[m]

        pt = s
        if e < 0:
            s, e = 0, piles[s]
        else:
            s, e = piles[e], piles[s]

        while s <= e:
            m = (s + e) // 2
            if m == 0:
                return 1
            d = 0
            for i in range(pt, l):
                d += (piles[i] + m - 1) // m - 1
            if d > delta:
                s = m + 1
            elif d < delta:
                e = m - 1
            else:
                return m

        return s