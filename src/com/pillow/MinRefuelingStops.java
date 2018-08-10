package com.pillow;

class MinRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length == 0)
            return target > startFuel? -1: 0;

        int [][] dp = new int[stations.length][stations.length];

        for (int s = 0; s < stations.length; s ++)
            dp[s][0] = target - stations[s][0];

        if (startFuel >= dp[0][0] + stations[0][0])
            return 0;

        for (int n = 1; n < stations.length; n ++) {
            int s = stations.length - n;
            dp[s][n] = Math.max(0, dp[s][n - 1] - stations[s][1]);
            for (s = stations.length - n - 1; s >= 0; s--)
                dp[s][n] = Math.max(0, Math.min(dp[s][n - 1] - stations[s][1], stations[s + 1][0] - stations[s][0] + dp[s + 1][n]));

            if (startFuel >= dp[0][n] + stations[0][0])
                return n;
        }

        int r = startFuel;
        for (int s = 0; s < stations.length; s ++) {
            if (r < stations[s][0])
                return -1;
            r += stations[s][1];
        }
        if (r >= target)
            return stations.length;

        return -1;
    }
}
