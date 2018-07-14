package com.pillow;

public class Main {
    public static void main(String args[]) throws Exception {
        MaxBinTree s = new MaxBinTree();
        int[] a = new int[] {3,2,1,6,0,5};
        TreeNode tree = s.constructMaximumBinaryTree(a);
        System.out.println(tree);
    }
}
