package com.pillow;

public class LIS {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i ++) {
            int dpmax = 0;
            for (int j = i-1; j >= 0; j --) {
                if (nums[i] > nums[j] && dp[j] > dpmax)
                    dpmax = dp[j];
            }
            dp[i] = dpmax == 0? 1: dpmax + 1;
        }
        int max = 0;
        for (int i = 0; i < dp.length; i ++) {
            System.out.println(" " + dp[i]);
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }
}
