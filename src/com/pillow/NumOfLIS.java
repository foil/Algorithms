package com.pillow;

public class NumOfLIS {
    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dpLen = new int[nums.length];
        dpLen[0] = 1;
        for (int i = 1; i < nums.length; i ++) {
            dpLen[i] = 1;
            for (int j = i-1; j >= 0; j --) {
                if (nums[i] > nums[j])
                    dpLen[i] = Math.max(dpLen[i], dpLen[j] + 1);
            }
        }
        int[] dpNum = new int[nums.length];
        dpNum[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i ++) {
            for (int j = i - 1; j >= 0; j --) {
                if (dpLen[j] == dpLen[i] - 1 && nums[j] < nums[i])
                    dpNum[i] += dpNum[j];
            }
            if (dpNum[i] == 0)
                dpNum[i] = 1;
            if (dpLen[i] > max)
                max = dpLen[i];
        }
        int num = 0;
        for (int i = 0; i < nums.length; i ++) {
            System.out.println(String.format(" %d %d", dpLen[i], dpNum[i]));
            if (dpLen[i] == max)
                num += dpNum[i];
        }
        return num;
    }
}
