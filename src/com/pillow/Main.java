package com.pillow;

public class Main {
    public static void main(String args[]) throws Exception {
        int[] a = { 3, 2, 1, 5, 6, 4 };
        System.out.println(KthLargestNum.findKthLargest(a, 1));
        int[] b = { -1,2,0};
        System.out.println(KthLargestNum.findKthLargest(b, 3));
        int[] c = { 3,1,2,4};
        System.out.println(KthLargestNum.findKthLargest(c, 2));
    }
}
