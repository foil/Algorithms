package com.pillow;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    static final char[][] dlMap = new char[][] {
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    static void letterCombo(String digits, int index, List<String> res) {
        if (index == digits.length())
            return;
        int n = Character.getNumericValue(digits.charAt(index++));
        if (n >= 2 && n <= 9) {
            char[] map = dlMap[n - 2];
            int len = res.size();
            if (len > 0) {
                for (int i = 0; i < len; i ++) {
                    String s = res.get(i);
                    res.set(i, s + map[0]);
                    for (int j = 1; j < map.length; j++)
                        res.add(s + map[j]);
                }
            } else {
                for (char c : map)
                    res.add(String.valueOf(c));
            }
        }

        letterCombo(digits, index, res);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.isEmpty())
            return res;

        letterCombo(digits, 0, res);
        return res;
    }
}
