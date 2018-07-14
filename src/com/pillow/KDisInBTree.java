package com.pillow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;

public class KDisInBTree {
    void DFS(TreeNode root, int depth, List<Integer> result) {
        if (root == null)
            return;
        if (depth == 0) {
            result.add(root.val);
        } else {
            DFS(root.left, depth-1, result);
            DFS(root.right, depth-1, result);
        }
    }

    List<TreeNode> criticalPath(TreeNode curRoot, TreeNode target, List<TreeNode> nodes) {
        if (curRoot == null)
            return null;
        nodes.add(curRoot);
        if (curRoot == target) {
            //  found it
            return nodes;
        }
        List<TreeNode> l = criticalPath(curRoot.left, target, new ArrayList<>(nodes));
        if (l != null)
            return l;
        return criticalPath(curRoot.right, target, nodes);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        //  1 find out the path from root to target
        List<TreeNode> path = new ArrayList<>();
        path = criticalPath(root, target, path);

        //  2 replace each node in the path with its sibling
        Map<TreeNode, Integer> map = new HashMap<>();
        for (int i = 0; i < path.size(); i ++) {
            TreeNode parent = path.get(i);
            if (parent == target)
                map.put(parent, K);
            else if (K + i == path.size() - 1)
                map.put(parent, 0);

            int depth = K + i - path.size();
            if (i == path.size() - 1 || depth < 0)
                continue;
            TreeNode child = path.get(i + 1);
            if (parent.left == child)
                map.put(parent.right, depth);
            else
                map.put(parent.left, depth);
        }

        //  3 dfs all relevant nodes
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
            TreeNode node = entry.getKey();
            int depth = entry.getValue();
            DFS(node, depth, result);
        }

        return result;
    }
}
