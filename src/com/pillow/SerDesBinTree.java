package com.pillow;
import java.lang.StringBuilder;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SerDesBinTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> s = new LinkedList<>();
        s.add(root);
        while (!s.isEmpty()) {
            TreeNode n = s.remove();
            sb.append(n == null? null: n.val);
            sb.append(",");
            if (n != null) {
                s.add(n.left);
                s.add(n.right);
            }
        }
        String str = sb.toString();
        return str.substring(0, str.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        List<TreeNode> l = Stream.of(data.split(",")).map(s -> s.equals("null")? null: new TreeNode(Integer.valueOf(s))).collect(Collectors.toList());
        TreeNode root = l.get(0);
        for (int i = 0, j = 1; j < l.size(); i ++) {
            TreeNode p = l.get(i);
            if (p != null) {
                p.left = l.get(j++);
                p.right = l.get(j++);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        SerDesBinTree serDesBinTree = new SerDesBinTree();
        root = serDesBinTree.deserialize(serDesBinTree.serialize(root));
        System.out.println(serDesBinTree.serialize(root));
    }
}

