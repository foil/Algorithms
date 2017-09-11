package com.pillow;

public class Main {
    public static void main(String args[]) throws Exception {
        int[] nums = new int[]
//                {1,3,5,4,7};
//                {2,2,2,2,2};
//        {5,5,5,4,5,6};
//                {8,13,9,14};
//                {8,13,9,14,15,1,2,3,4};
//                {10, 9, 2, 5, 3, 7, 101, 18};
//                {1,3,6,7,9,4,10,5,6};
//                {1,1,1,2,2,2,3,3,3};
                {1};
        int res = NumOfLIS.findNumberOfLIS(nums);
        System.out.println(res);
    }
}
