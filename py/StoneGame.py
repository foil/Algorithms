class Solution:
    def stoneGame(self, piles):
        """
        :type piles: List[int]
        :rtype: bool
        """
        Dp = []
        l = len(piles)
        for i in range(l):
            Dp.append([0] * l)
        for i in range(l-1):
            Dp[i][i + 1] = max(piles[i], piles[i + 1])
        for i in range(3, l, 2):
            for j in range(l - 3):
                if j + i < l:
                    Dp[j][j + i] = max(min(Dp[j + 2][j + i], Dp[j + 1][j + i - 1]) + piles[j],
                                       min(Dp[j + 1][j + i - 1], Dp[j][j + i - 2]) + piles[j + i])
        print(Dp[0][l-1])
        return Dp[0][l-1] > sum(piles) / 2