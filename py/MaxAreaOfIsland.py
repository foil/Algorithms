class Solution(object):

    @staticmethod
    def dfs(grid, y, x, accTb, n):
        if 0 <= y < len(grid) and 0 <= x < len(grid[0])\
                and grid[y][x] == 1 and not accTb[y][x]:
            accTb[y][x] = True
            n += 1
            n = Solution.dfs(grid, y-1, x, accTb, n)
            n = Solution.dfs(grid, y, x-1, accTb, n)
            n = Solution.dfs(grid, y+1, x, accTb, n)
            n = Solution.dfs(grid, y, x+1, accTb, n)

        return n

    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        ySize = len(grid)
        if ySize == 0:
            return 0

        xSize = len(grid[0])
        accTb = [[False] * xSize for _ in xrange(ySize)]
        max = 0
        for y in xrange(ySize):
            for x in xrange(xSize):
                n = Solution.dfs(grid, y, x, accTb, 0)
                if n > max:
                    max = n

        return max
