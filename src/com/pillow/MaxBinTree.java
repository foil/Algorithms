package com.pillow;

public class MaxBinTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return foo(nums, 0, nums.length);
    }
    TreeNode foo(int[] nums, int start, int end) {
        if (start >= end)
            return null;

        int maxIndex = start, max = nums[start];
        for (int i = start; i < end; i ++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = foo(nums, start, maxIndex);
        root.right = foo(nums, maxIndex + 1, end);
        return root;
    }
}
