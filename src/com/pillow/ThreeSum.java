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
        System.out.println(Arrays.toString(nums));

        Integer dupa = null;
        for (int i = 0; i < L - 2; i ++) {
            int a = nums[i];
            if (dupa != null && a == dupa.intValue())
                continue;
        
            Integer dupb = null;
            for (int j = i + 1, k = L - 1; j < k;) {
                int b = nums[j], c = nums[k];
                if (dupb != null && b == dupb.intValue()) {
                    j ++;
                    continue;
                }

                if (b + c > -a)
                    k --;
                else if (b + c < -a)
                    j ++;
                else {
                    res.add(Arrays.asList(a, b, c));
                    k --; j ++;
                    dupa = a;
                    dupb = b;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
        //int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        //int[] nums = new int[] {-2, 0, 1, 1, 2};
        //int[] nums = new int[] {-2, 0, 0, 2, 2};
        int[] nums = new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> l = s.threeSum(nums);
        System.out.println(l.toString());
    }
}
