class Solution:
    def spiralMatrixIII(self, R, C, r0, c0):
        """
        :type R: int
        :type C: int
        :type r0: int
        :type c0: int
        :rtype: List[List[int]]
        """
        step = 1
        sign = 1
        r = r0
        c = c0
        ans = [[r,c]]
        while True:
            for x in range(c + sign, c + (step + 1) * sign, sign):
                if 0 <= r < R and 0 <= x < C:
                    ans.append([r,x])
            c += step * sign
            for y in range(r + sign, r + (step + 1) * sign, sign):
                if 0 <= y < R and 0 <= c < C:
                    ans.append([y,c])
            r += step * sign

            sign = -sign
            step += 1

            if len(ans) == R * C:
                return ans