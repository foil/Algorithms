package com.pillow;

class WildcardMatching {
    private boolean comp(String s, int i, String p, int j) {
        if (i == s.length()) {
            if (j == p.length())
                return true;
            for (int k = j; k < p.length(); k ++)
                if (p.charAt(k) != '*')
                    return false;
            return true;
        } else if (j == p.length()) {
            return false;
        }
        
        char sc = s.charAt(i), pc = p.charAt(j);
        if (sc == pc || pc == '?')
            return comp(s, i + 1, p, j + 1);
        else if (pc == '*') {
            int k = j + 1;
            for (; k < p.length(); k ++)
                if (p.charAt(k) != '*')
                    break;
            
            for (; i <= s.length(); i ++)
                if (comp(s, i, p, k))
                    return true;
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        //  time out
        // return comp(s, 0, p, 0);
        int h = s.length(), w = p.length();
        boolean[][] dp = new boolean[h + 1][w + 1];
        dp[h][w] = true;
        for (int i = w - 1; i >= 0; i --)
            if (p.charAt(i) == '*')
                dp[h][i] = true;
            else
                break;

        for (int i = h - 1; i >= 0; i --) {
            for (int j = w - 1; j >= 0; j --) {
                char sc = s.charAt(i), pc = p.charAt(j);
                if (sc == pc || pc == '?')
                    dp[i][j] = dp[i + 1][j + 1];
                else if (pc == '*')
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                else
                    dp[i][j] = false;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String[] s = new String[] {"b", "a", "zacabz", "mississippi", "aa", "aa", "cb", "adceb", "acdcb"};
        String[] p = new String[] {"?*?", "a*", "*a?b*", "m??*ss*?i*pi", "a", "*", "?a", "*a*b", "a*c?b"};
        for (int i = 0; i < s.length; i ++) {
            System.out.println("s: " + s[i] + ", p: " + p[i]);
            System.out.println(new WildcardMatching().isMatch(s[i], p[i]));
        }
    }
}
