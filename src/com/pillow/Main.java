package com.pillow;

public class Main {
    public static void main(String args[]) throws Exception {
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(0);
        r.right = new TreeNode(4);
        r.left.right = new TreeNode(2);
        r.left.right.left = new TreeNode(1);
        r = TrimBSTree.trimBST(r, 1, 3);
        System.out.println(r);
    }
}
