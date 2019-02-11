package com.pillow;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ll = new ArrayList<>();
        if (nums.length < 4)
            return ll;
        Arrays.sort(nums);
        Integer prevI = null, prevJ = null, prevK = null;
        for (int i = 0; i < nums.length - 3; i ++) {
            for (int j = i + 1; j < nums.length - 2; j ++) {
                int t = target - nums[i] - nums[j];
                for (int k = j + 1, l = nums.length - 1; k < l;) {
                    System.out.printf("%d, %d, %d, %d\n", nums[i], nums[j], nums[k], nums[l]);
                    if (nums[k] + nums[l] > t)
                        l --;
                    else if (nums[k] + nums[l] < t)
                        k ++;
                    else {
                        if (prevI == null || prevJ == null || prevK == null ||
                                prevI != nums[i] || prevJ != nums[j] || prevK != nums[k]) {
                            ll.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            prevI = nums[i]; prevJ = nums[j]; prevK = nums[k];
                                }
                        k ++;
                    }
                }
            }
        }
        return ll;
    }

    public static void main(String[] args) {
        //int[] nums = new int[] {1, 0, -1, 0, -2, 2};
        //int[] nums = new int[] {-3, -2, -1, 0, 0, 1, 2, 3};
        int[] nums = new int[] {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};

        List<List<Integer>> ll = new FourSum().fourSum(nums, 0);
        System.out.println(ll.toString());
    }
}
