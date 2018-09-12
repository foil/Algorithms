package com.pillow;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class LongestPalindromeStr {
    /*
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
     */
    public String longestPalindrome(String s) {
        int L = s.length();
        if (L < 2)
            return s;

        int[][] dp  = new int[L][L];

        for (int i = 0; i < L; i ++) {
            dp[i][i] = 1;
            if (i < L - 1)
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1)? 2: 1;
        }

        int maxi = 0, max = 1;
        for (int d = 0; d < L; d ++)
            for (int i = 0; i < L; i ++) {
                int j = i + d;
                if (j >= L)
                    break;
                if (dp[i][j] == 0) 
                    dp[i][j] = this.getValue(s, i, j, dp);

                if (dp[i][j] > max) {
                    maxi = i;
                    max = dp[i][j];
                }
            }

        return s.substring(maxi, maxi + max);
    }
    private static int getValue(String s, int i, int j, int[][] dp) {
        if (s.charAt(i) == s.charAt(j) &&
            dp[i + 1][j - 1] == j - 1 - i)
            return dp[i + 1][j - 1] + 2;
        return dp[i + 1][j - 1];
    }

    public static void main(String[] args) {
        LongestPalindromeStr s = new LongestPalindromeStr();
        String[] tests = new String[] {
                "abcdbbfc",
        };
        for (String t : tests)
            System.out.println(s.longestPalindrome(t));
    }
}
