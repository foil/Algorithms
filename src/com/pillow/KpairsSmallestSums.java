package com.pillow;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

class KpairsSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int L1 = nums1.length, L2 = nums2.length;
        if (L1 == 0 || L2 == 0 || k == 0)
            return new ArrayList<int[]>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, (int[] r1, int[] r2) -> 
                (nums1[r1[0]] + nums2[r1[1]] - nums1[r2[0]] - nums2[r2[1]]));

        pq.offer(new int[] {0, 0});
        boolean[][] visited = new boolean[L1][L2];
        visited[0][0] = true;
        int p1 = 0;
        int[] range = new int[L1];
        
        List<int[]> ans = new ArrayList<>();
        while (ans.size() < k && !pq.isEmpty()) {
            int[] pair = pq.poll();
            System.out.println(Arrays.toString(pair) + " -> [" + nums1[pair[0]] + ", " + nums2[pair[1]] + "]");
            ans.add(new int[] {nums1[pair[0]], nums2[pair[1]]});
            if (pair[1] == 0)
                p1 = pair[0];
            else
                range[pair[0]] = pair[1];

            for (int y = 0; y <= p1; y ++) {
                int p2 = range[y] + 1;
                if (p2 < L2 && !visited[y][p2]) {
                    pq.offer(new int[] {y, p2});
                    visited[y][p2] = true;
                }
            }
            if (p1 + 1 < L1 && !visited[p1 + 1][0]) {
                pq.offer(new int[] {p1 + 1, 0});
                visited[p1 + 1][0] = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        KpairsSmallestSums s = new KpairsSmallestSums();
        int[] nums1 = new int [] {1,7,11};
        int[] nums2 = new int [] {2,4,6};
        int k = 3;
        //int[] nums1 = new int[] {1,2,4,5,6};
        //int[] nums2 = new int[] {3,5,7,9};
        //int k = 3;
//        int[] nums1 = new int[] {-10, -4, 0, 0, 6};
//        int[] nums2 = new int[] {3, 5, 6, 7, 8, 100};
//        int k = 10;
//
        List<int[]> l = s.kSmallestPairs(nums1, nums2, k);
    }
}
