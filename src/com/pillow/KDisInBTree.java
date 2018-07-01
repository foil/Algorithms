package com.pillow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KDisInBTree {
    private int targetDepth = -1;
    private TreeNode target = null;

    void DFS(TreeNode root, int depth, List<Integer> result) {
        if (depth == 0) {
            result.add(root.val);
        } else {
            DFS(root.left, depth-1, result);
            DFS(root.right, depth-1, result);
        }
    }

    private void DFS2(TreeNode root, int depth, List<List<TreeNode>> nodes) {
        if (root == null)
            return;
        if (nodes.size() <= depth)
            nodes.add(new ArrayList<>());
        List<TreeNode> l = nodes.get(depth);
        l.add(root);
        if (root == target)
            targetDepth = depth;

        if (targetDepth >= 0 && depth <= targetDepth) {
            DFS2(root.left, depth + 1, nodes);
            DFS2(root.right, depth + 1, nodes);
        }

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        TreeNode tr = target;
        List<Integer> result = new ArrayList<>();
        DFS(tr, K, result);

        this.target = target;
        tr = root;
        List<List<TreeNode>> nodes = new ArrayList<>();
        DFS2(tr, 0, nodes);

        int sz = nodes.size();
        List<TreeNode> aboves = null;
        if (sz >= K)
            aboves = nodes.get(K);
        else
        for (int i = 0; i < nodes.size(); i ++) {

        }
        return null;
    }
}
