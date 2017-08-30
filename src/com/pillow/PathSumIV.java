package com.pillow;

public class PathSumIV {
    public static int pathSum(int[] nums) {
        int sum = 0;
        if (nums == null || nums.length == 0)
            return sum;

        boolean[] rec = new boolean[nums.length];

        for (int i = nums.length - 1; i >= 0; i --) {
            if (rec[i])
                continue;
            int Di = nums[i] / 100;
            int Pi = (nums[i] / 10) % 10;
            for (int j = i; j >= 0; j --) {
                int Dj = nums[j] / 100;
                int Pj = (nums[j] / 10) % 10;
                int Vj = nums[j] % 10;
                if ((Pi - 1) >> (Di - Dj) == (Pj - 1)) {
                    rec[j] = true;
                    sum += Vj;
                }
            }
        }
        return sum;
    }
}
