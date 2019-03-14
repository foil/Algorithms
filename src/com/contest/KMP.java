package com.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class KMP {
    private static Map<String, int[]> partialMatchTable = new HashMap<>();

    private static int[] getPartialMatchVec(String pattern) {
        int L = pattern.length();
        int[] vec = new int[L];
        for (int i = 1; i < L; i ++) {
            int j = i - 1;
            for (; j > 0; j --) {
                if (pattern.substring(0, j).equals(pattern.substring(i - j, i)))
                    break;
            }
            vec[i] = j;
        }
//        System.out.println(Arrays.toString(vec));
        return vec;
    }
    static int match(String target, String pattern) {
        //  generate partial match table
        partialMatchTable.putIfAbsent(pattern, getPartialMatchVec(pattern));
        int[] vec = partialMatchTable.get(pattern);
        int i = 0, j = 0;
        for (; i < target.length() && j < pattern.length(); i ++, j ++) {
            if (target.charAt(i) != pattern.charAt(j)) {
                    i += j - vec[j];
                    j = -1;
            }
            System.out.printf("i: %d, j: %d\n", i, j);
        }
        if (j == pattern.length())
            return i - j;
        return -1;
    }

    public static void main(String[] args) {
        String[] dict = new String[] {
                "abcdabd",
                "bc",
                "bcd",
                "adb",
                "adbc",
        };
        String[] targets = new String[] {
                "bbc abcdab abcdabcdabde",
//                "abcabcbcdefad",
//                "efgadbc",
//                "bcadabcadbc",
//                "eeefffgab",
        };

        for (String target: targets) {
            int i = KMP.match(target, dict[0]);
            System.out.printf("in: %s, matched: %d\n", target, i);
        }
    }
}