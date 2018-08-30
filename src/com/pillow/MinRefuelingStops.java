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
    public static void main(String args[]) throws Exception {
        MinRefuelingStops s = new MinRefuelingStops();
//        int target = 100, startFuel = 10;
//        int [][]stations = new int[][] {new int[]{10,60}, new int[]{20,30}, new int[]{30,30}, new int[]{60,40}};
//        int target = 100, startFuel = 25;
//        int [][]stations = new int[][] {new int[]{25,25},new int[]{50,25},new int[]{75,25}};
        int target = 1000, startFuel = 83;
        int [][]stations = new int[][] {new int[]{25,27},new int[]{36,187},new int[]{140,186},new int[]{378,6},new int[]{492,202},
                            new int[]{517,89},new int[]{579,234},new int[]{673,86},new int[]{808,53},new int[]{954,49}};

        int n = s.minRefuelStops(target, startFuel, stations);
        System.out.println(n);
    }
}
