package com.pillow;

public class Main {
    public static void main(String args[]) throws Exception {
        MedianSortedArrays medianSortedArrays = new MedianSortedArrays();
        int [] nums1 = new int[] {1,3};
        int[] nums2 = new int[] {2,6};
        System.out.println(medianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
