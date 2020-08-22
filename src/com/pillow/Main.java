package com.pillow;
import java.io.IOException;
import java.util.*;

public class Main {
    private static int calc(int n1, char op, int n2) {
        if (op == '+')
            return n1 + n2;
        if (op == '-')
            return n1 - n2;
        return n1 * n2;
    }
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i ++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> ll = diffWaysToCompute(input.substring(0, i));
                List<Integer> rl = diffWaysToCompute(input.substring(i + 1));
                for (int l: ll) {
                    for (int r: rl) {
                        res.add(calc(l, c, r));
                    }
                }
            }
        }
        if (res.isEmpty())
            res.add(Integer.valueOf(input));
        System.out.println("res: " + Arrays.toString(res.toArray()));
        return res;
    }
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return rec(1, n);
    }
    private static List<TreeNode> rec(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end)
            res.add(null);
        else
        for (int i = start; i <= end; i ++) {
            List<TreeNode> ll = rec(start, i - 1);
            List<TreeNode> rl = rec(i + 1, end);
            for (TreeNode l: ll) {
                for (TreeNode r: rl) {
                    TreeNode t = new TreeNode(i);
                    t.left = l;
                    t.right = r;
                    res.add(t);
                }
            }
        }
        return res;
    }
    public static void main(String args[]) throws Exception {
        List<Integer> l = diffWaysToCompute("2*3-4*5");
        System.out.println(Arrays.toString(l.toArray()));
    }
}
