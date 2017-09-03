package com.pillow;

public class SecondMinInBTree {
    static int findBigger(int val, TreeNode t) {
        if (t == null)
            return val;
        else if (t.val > val)
            return t.val;
        else {
            int l = findBigger(val, t.left);
            int r = findBigger(val, t.right);
            if (val == l && val == r)
                return val;
            else if (val == l)
                return r;
            else if (val == r)
                return l;
            else
                return l > r? r: l;
        }
    }
    public static int findSecondMinimumValue(TreeNode root) {
        TreeNode p = root;
        if (p == null)
            return -1;
        int l = findBigger(root.val, p.left);
        int r = findBigger(root.val, p.right);
        if (root.val == l && root.val == r)
            return -1;
        else if (root.val == l)
            return r;
        else if (root.val == r)
            return l;
        else
            return l > r? r: l;
    }
}
