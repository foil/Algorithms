package com.pillow;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int x) {
        val = x;
    }
    TreeNode(int x, TreeNode l, TreeNode r) {
        val = x;
        left = l;
        right = r;
    }
    public static TreeNode fromArray(Integer[] arr) {
        int i = 0;
        TreeNode head = new TreeNode(arr[i++]);
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(head);
        while (i < arr.length) {
            TreeNode t = q.poll();
            Integer n = arr[i++];
            t.left = n == null? null: new TreeNode(n);
            n = arr[i++];
            t.right = n == null? null: new TreeNode(n);
            if (t.left != null)
                q.add(t.left);
            if (t.right != null)
                q.add(t.right);
        }
        return head;
    }
    public static Integer[] toArray(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.push(root);
        while (!q.isEmpty()) {
            TreeNode t = q.pop();
            if (t != null) {
                res.add(t.val);
                q.add(t.left);
                q.add(t.right);
            } else
                res.add(null);
        }
        int i = res.size() - 1;
        for (; i >= 0; i --) {
            if (res.get(i) != null)
                break;
        }
        return res.subList(0, i + 1).toArray(new Integer[0]);
    }
}
