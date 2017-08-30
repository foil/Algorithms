package com.pillow;

public class NonDecreasingArray {
    public static boolean checkPossibility(int[] nums) {
        int max = nums[0], second = 1;
        boolean modified = false;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] < max) {
                if (modified)
                    return false;
                else {
                    modified = true;
                    if (nums[i] < second)
                        second = max;
                    else
                        max = nums[i];
                }
            } else if (nums[i] == max)
                second = max;
            else {
                second = max;
                max = nums[i];
            }
        }
        return true;
    }
}
