package com.pillow;

public class DungeonGame {
    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0)
            return 1;
        int xlen = dungeon.length;
        int ylen = dungeon[0].length;
        int[][] dp = new int[xlen][ylen];

        for (int i = xlen - 1; i >= 0; --i) {
            for (int j = ylen - 1; j >= 0; --j) {
                if (i == xlen - 1 && j == ylen - 1) {
                    dp[i][j] = dungeon[i][j] >= 0 ? 1 : 1 - dungeon[i][j];
                } else if (i == xlen - 1) {
                    dp[i][j] = dungeon[i][j] >= dp[i][j + 1] ?
                            1 : dp[i][j + 1] - dungeon[i][j];
                } else if (j == ylen - 1) {
                    dp[i][j] = dungeon[i][j] >= dp[i + 1][j] ?
                            1 : dp[i + 1][j] - dungeon[i][j];
                } else {
                    int a = dungeon[i][j] >= dp[i][j + 1] ?
                            1 : dp[i][j + 1] - dungeon[i][j];
                    int b = dungeon[i][j] >= dp[i + 1][j] ?
                            1 : dp[i + 1][j] - dungeon[i][j];
                    dp[i][j] = a > b ? b : a;
                }
            }
        }
        return dp[0][0];
    }
}
