package com.pillow;

public class ValidParenthesisString {
    static boolean check(String s, int i, int sum) {
        for (; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(')
                sum++;
            else if (c == ')')
                sum--;
            else if (c == '*')
                return check(s, i+1, sum+1) ||
                        check(s, i+1, sum) ||
                        check(s, i+1, sum-1);
            if (sum < 0)
                return false;
        }
        return sum == 0;
    }
    public static boolean checkValidString(String s) {
        return  s == null || s.isEmpty()|| check(s, 0, 0);
    }
}
