package com.pillow;
import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int p = -1;
        for (int i = nums.length - 2; i >= 0; i --) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }
        if (p < 0) {
            //  just reverse nums
            for (int i = 0, j = nums.length - 1; i < j; i ++, j --)
                swap(nums, i, j);
            return;
        }
        for (int i = nums.length - 1; i > p; i --)
            if (nums[i] > nums[p]) {
                System.out.printf("p: %d, i: %d\n", p, i);
                swap(nums, i, p);
                break;
            }
        System.out.println(Arrays.toString(nums));
        for (int i = p + 1, j = nums.length - 1; i < j; i ++, j --)
            swap(nums, i, j);
    }

    private static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {7,5,6,3,4,2,1};
        System.out.println(Arrays.toString(nums));
        NextPermutation s = new NextPermutation();
        s.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
