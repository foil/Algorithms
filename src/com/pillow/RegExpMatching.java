package com.pillow;
import java.util.Arrays;

class RegExpMatching {
    public boolean isMatch(String s, String p) {
        int h = s.length(), w = p.length();
        boolean[][] dp = new boolean[h+1][w+1];
        dp[0][0] = true;
        for (int j = 0; j < w; j ++) {
            char pc = p.charAt(j);
            if (pc == '*') {
                dp[0][j+1] = dp[0][j] || dp[0][j-1];
            } else
                dp[0][j+1] = false;
        }
        for (int i = 0; i < h; i ++) {
            for (int j = 0; j < w; j ++) {
                char sc = s.charAt(i), pc = p.charAt(j);
                if (sc == pc || pc == '.') {
                    dp[i+1][j+1] = dp[i][j];
                    if (j > 1 && p.charAt(j-1) == '*')
                        dp[i+1][j+1] |= dp[i][j-2];
                } else if (pc == '*') {
                    dp[i+1][j+1] = dp[i + 1][j] || dp[i+1][j-1];
                    if (p.charAt(j-1) == '.' || p.charAt(j-1) == sc)
                        dp[i+1][j+1] |= dp[i][j+1];
                } else
                    dp[i+1][j+1] = false;
        //        System.out.printf("sc: %c, pc: %c, match: %b\n",
        //                sc, pc, dp[i+1][j+1]);
            }
        }
        return dp[h][w];
    }

    public static void main(String[] args) {
        String[] s = new String[] {"ippi", "aab", "aaa", "a", "", "a"};
        String[] p = new String[] {"p*.", "c*a*b", ".*", "ab*", ".*c*", "c*c*a"};
        for (int i = 0; i < s.length; i ++) {
            System.out.println("s: " + s[i] + ", p: " + p[i]);
            System.out.println(new RegExpMatching().isMatch(s[i], p[i]));
        }
    }
}
