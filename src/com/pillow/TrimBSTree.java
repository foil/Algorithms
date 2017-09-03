package com.pillow;

public class TrimBSTree {
    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return root;
        if (root.val < L) {
            root = root.right;
            root = trimBST(root, L, R);
        } else if (root.val > R) {
            root = root.left;
            root = trimBST(root, L, R);
        } else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }
        return root;
    }
}
