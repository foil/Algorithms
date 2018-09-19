package com.pillow;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int L = nums.length;
        if (L < 3)
            return res;

        Arrays.sort(nums);

        for (int i = 0; i < L - 2; i ++) {
            int last = i;
            for (int k = L - 1; k >= i + 2; k --) {
                int j = bsearch(last + 1, k - 1, nums, -(nums[i] + nums[k]));
                if (j > 0) {
                    last = j;
                    if (!hasSeen(nums[i], nums[j], nums[k], res)) {
                        List<Integer> l = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        res.add(l);
                    }
                }
            }
        }

        return res;
    }

    private static boolean hasSeen(int i, int j, int k, List<List<Integer>> l) {
        for (List<Integer> ll: l)
            if (ll.get(0) == i && ll.get(1) == j && ll.get(2) == k) 
                return true;
        return false;
    }

    private static int bsearch(int s, int e, int[] A, int T) {
        while (s <= e) {
            int m = (s + e) / 2;
            if (A[m] > T) {
                e = m - 1;
            } else if (A[m] < T) {
                s = m + 1;
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
