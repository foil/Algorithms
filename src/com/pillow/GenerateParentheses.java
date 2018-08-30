package com.pillow;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n < 1)
            return ans;
        StringBuilder sb = new StringBuilder("");
        int lp = n;
        int rp = 0;
        rec(sb, lp, rp, ans);
        return ans;
    }
    private void rec(StringBuilder sb, int lp, int rp, List<String> ans) {
        if (rp == 0 && lp == 0) {
            ans.add(sb.toString());
        } else if (rp > 0 && lp > 0) {
            StringBuilder sb2 = new StringBuilder(sb.toString());
            sb.append("(");
            rec(sb, lp-1, rp+1, ans);
            sb2.append(")");
            rec(sb2, lp, rp-1, ans);
        } else if (rp > 0) {
            sb.append(")");
            rec(sb, lp, --rp, ans);
        } else {
            sb.append("(");
            rec(sb, --lp, ++rp, ans);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses s = new GenerateParentheses();
        System.out.println(s.generateParenthesis(3));
    }
}
