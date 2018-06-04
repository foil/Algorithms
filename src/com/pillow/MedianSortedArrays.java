package com.pillow;

import java.util.ArrayList;
import java.util.List;

public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m + n == 0)
            return 0;
        List<Integer> l = new ArrayList<>();
        int i, j;
        for (i = 0, j = 0; i < m && j < n;) {
                if (nums1[i] < nums2[j]) {
                    l.add(nums1[i++]);
                } else {
                    l.add(nums2[j++]);
                }
        }
        for (; i < m; i ++)
            l.add(nums1[i]);
        for (; j < n; j ++)
            l.add(nums2[j]);
        if ((m + n) % 2 == 0)
            return (double)(l.get((m + n) / 2) + l.get((m + n) / 2 - 1)) / 2;
        return (double)(l.get((m + n) / 2));
    }
}
