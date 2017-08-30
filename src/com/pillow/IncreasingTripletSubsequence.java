package com.pillow;

public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int min = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int n: nums) {
            if (n <= min)
                min = n;
            else if (n <= middle)
                middle = n;
            else
                return true;
        }
        return false;
    }
}
