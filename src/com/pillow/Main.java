package com.pillow;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        rec(k, 1, n, new ArrayList<Integer>(), res);
        return res;
    }
    private static void rec(int k, int start, int n, List<Integer> l, List<List<Integer>> res) {
        if (k == 0 && n == 0)
            res.add(new ArrayList<>(l));
        for (int i = start; i <= 9; i ++) {
            l.add(i);
            rec(k - 1, i + 1, n - i, l, res);
            l.remove(l.size() - 1);
        }
    }

    static int maxProfit(int[] prices) {
        int[][] dp = new int[3][prices.length];
        dp[0][0] = -prices[0];   //  buy & hold
        dp[1][0] = 0;   //  sell
        dp[2][0] = 0;   //  cool down
        for (int i = 1; i < prices.length; i ++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[2][i-1] - prices[i]);
            dp[1][i] = dp[0][i-1] + prices[i];
            dp[2][i] = Math.max(dp[1][i-1], dp[2][i-1]);
        }
        return Math.max(dp[1][prices.length-1], dp[2][prices.length-1]);
    }

    static List<Integer> eventualSafeNodes(int[][] graph) {
        //  0: not visit; 1: failed; 2: safe
        int[] stats = new int[graph.length];
        for (int i = 0; i < graph.length; i ++) {
            if (stats[i] == 0)
                rec(i, graph, stats);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < graph.length; i ++) {
            if (stats[i] == 2)
                res.add(i);
        }
        return res;
    }
    private static boolean rec(int i, int[][] graph, int[] stats) {
        if (stats[i] == 1)
            return false;
        if (stats[i] == 2)
            return true;

        stats[i] = 1;
        for (int j = 0; j < graph[i].length; j ++) {
            int n = graph[i][j];
            if (!rec(n, graph, stats))
                return false;
        }
        stats[i] = 2;
        return true;
    }

    private static String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i --, j --) {
            int n1 = 0;
            if (i >= 0)
                n1 = num1.charAt(i) - '0';
            int n2 = 0;
            if (j >= 0)
                n2 = num2.charAt(j) - '0';
            int n = n1 + n2 + carry;
            carry = n >= 10? 1: 0;
            n %= 10;
            sb.insert(0, n);
        }
        if (carry > 0)
            sb.insert(0, 1);
        return sb.toString();
    }
    public static void main(String args[]) throws Exception {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.follow(1, 2);
        twitter.follow(2, 1);
//        System.out.println(twitter.getNewsFeed(2));
        twitter.postTweet(2, 6);
//        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
    }
}
