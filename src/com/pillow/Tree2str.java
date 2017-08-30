package com.pillow;

public class Tree2str {
    static void preOrder(TreeNode t, StringBuilder str) {
        if (t != null) {
            str.append(t.val);
            if (t.left != null || t.right != null)
                str.append("(");
            preOrder(t.left, str);
            if (t.left != null || t.right != null)
                str.append(")");
            if (t.right != null)
                str.append("(");
            preOrder(t.right, str);
            if (t.right != null)
                str.append(")");
        }
    }
    public static String tree2str(TreeNode t) {
        StringBuilder str = new StringBuilder();
        preOrder(t, str);
        return str.toString();
    }
}
