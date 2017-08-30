package com.pillow;

import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;

        List<TreeNode> l = new LinkedList<>();
        l.add(root);
        while (!l.isEmpty()) {
            List<Integer> li = new LinkedList<>();
            List<TreeNode> tmp = new LinkedList<>();
            for (TreeNode t : l) {
                li.add(t.val);
                if (t.left != null) {
                    tmp.add(t.left);
                } if (t.right != null) {
                    tmp.add(t.right);
                }
            }
            if (!li.isEmpty())
                res.add(li);
            if (tmp.isEmpty())
                l.clear();
            else
                l = tmp;
        }
        return res;
    }
}
