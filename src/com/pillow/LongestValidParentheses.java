package com.pillow;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int L = s.length();
        int[] dp = new int[L];
        int opened = 0, i = 0, max = 0;
        for (; i < L; i ++) {
            if (s.charAt(i) == '(')
                break;
        }
        for (; i < L; i ++) {
            char c = s.charAt(i);
            if (c == '(') {
                opened ++;
            } else if (opened > 0) {
                opened --;
                dp[i] = 2 + dp[i - 1];
                if (i >= dp[i])
                    dp[i] += dp[i - dp[i]];
                if (dp[i] > max)
                    max = dp[i];
            }
            System.out.printf("i: %d, opened: %d, dp: %d\n",
                    i, opened, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses s = new LongestValidParentheses();
        String[] tests = new String[] {
            //"(()",
            //")()())",
            "(()(()))"
        };
        for (String t : tests)
            System.out.println(s.longestValidParentheses(t));
    }
}
