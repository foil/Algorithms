package com.pillow;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class KpairsSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int L1 = nums1.length, L2 = nums2.length;
        if (L1 == 0 || L2 == 0 || k == 0)
            return new ArrayList<int[]>();
        
        int n = 1, i = 0, j = 0;
        while (i < L1 - 1 && j < L2 - 1) {
            int n1 = nums1[i + 1] + nums2[j], n2 = nums2[j + 1] + nums1[i];
            if (n1 < n2) {
                i ++;
                n += j + 1;
            } else if (n1 > n2) {
                j ++;
                n += i + 1;
            } else {
                i ++;
                j ++;
                n += i + j + 1;
            }
            System.out.println(String.format("i: %d, j: %d, n: %d", i, j, n));
            if (n >= k)
                break;
        }
        
        if (n < k) {
            while (i < L1 - 1) {
                i ++;
                n += j + 1;
                if (n >= k)
                    break;
            }

            while (j < L2 - 1) {
                j++;
                n += i + 1;
                if (n >= k)
                    break;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(n, (int[] r1, int[] r2) -> 
                (r1[0] + r1[1]) - (r2[0] + r2[1]));
        for (int a = 0; a <= i; a ++)
            for (int b = 0; b <= j; b ++)
                pq.add(new int[] {nums1[a], nums2[b]});
        
        List<int[]> ans = new ArrayList<>();
        while (ans.size() < k && pq.size() > 0)
            ans.add(pq.poll());
        return ans;
    }

    public static void main(String[] args) {
        KpairsSmallestSums s = new KpairsSmallestSums();
        //int[] nums1 = new int [] {1,7,11};
        //int[] nums2 = new int [] {2,4,6};
        //int k = 3;
        //int[] nums1 = new int[] {1,2,4,5,6};
        //int[] nums2 = new int[] {3,5,7,9};
        //int k = 3;
        int[] nums1 = new int[] {-10, -4, 0, 0, 6};
        int[] nums2 = new int[] {3, 5, 6, 7, 8, 100};
        int k = 10;

        List<int[]> l = s.kSmallestPairs(nums1, nums2, k);
        System.out.println(l);
    }
}
