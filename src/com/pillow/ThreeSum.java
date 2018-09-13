package com.pillow;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)
            return res;

        Arrays.sort(nums);
        int s = 0, e = nums.length - 1;
        while (s < e - 1) {
            int i = this.bsearch(s + 1, e - 1, nums, -(nums[s] + nums[e]));
            int sum = nums[s] + nums[i] + nums[e];
            if (sum == 0) {
                boolean seen = false;
                for (List<Integer> l : res) {
                    if (l.get(0) == nums[s] && l.get(1) == nums[i] && l.get(2) == nums[e]) {
                        seen = true;
                        break;
                    }
                }
                if (!seen) {
                    List<Integer> l = new ArrayList<>(Arrays.asList(nums[s], nums[i], nums[e]));
                    res.add(l);
                }
                s ++;
            } else if (sum < 0)
                s ++;
            else
                e --;
        }
        return res;
    }

    private static int bsearch(int s, int e, int[] A, int T) {
        while (s <= e) {
            int m = (s + e) / 2;
            if (A[m] > T) {
                e = m - 1;
                if (e < s)
                    return s;
            } else if (A[m] < T) {
                s = m + 1;
                if (s > e)
                    return e;
            } else
                return m;
        }
        return -1;
    }

    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
        //int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        int[] nums = new int[] {-2, 0, 1, 1, 2};
        List<List<Integer>> l = s.threeSum(nums);
        System.out.println(l.toString());
    }
}
