package com.pillow;

public class ValidPalindromeII {
    static boolean test(String s, int i, int j) {
        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
    public static boolean validPalindrome(String s) {
        int len = s.length();
        for (int i = 0, j = len - 1; i < j; i ++, j --) {
            if (s.charAt(i) != s.charAt(j))
                return test(s, i +1, j) || test(s, i, j - 1);
        }
        return true;
    }
}
