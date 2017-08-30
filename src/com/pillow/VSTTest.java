package com.pillow;

import java.util.Arrays;

class LargestNumberWords {
    static int solution(String S) {
        int max = 0;
        if (S == null || S.length() == 0)
            return max;

        String[] substrs = S.split("[.?!]");
        for (String str : substrs) {
            String[] subsubstrs = str.split(" ");
            int sum = 0;
            for (String sub : subsubstrs) {
                if (sub != null && sub.length() > 0)
                    sum++;
            }
            if (sum > max)
                max = sum;
        }
        return max;
    }

    static void test() {
        String S = ".! ? x..! ";
        int n = solution(S);
        System.out.println(n == 1 ? "true" : "false");

        S = ".x  xx . !?";
        n = LargestNumberWords.solution(S);
        System.out.println(n == 2 ? "true" : "false");
    }
}

class Elevator {
    static int solution(int[] A, int[] B, int M, int X, int Y) {
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return 0;

        int count = 0, totalWeight = 0, sum = 0;
        for (int i = 0; i < A.length; i++) {
            count++;
            totalWeight += A[i];
            if (count >= X || totalWeight >= Y || i == A.length - 1) {
                if (count > X || totalWeight > Y) {
                    count--;
                    i--;
                }
                Arrays.sort(B, i - count + 1, i + 1);
                int s = 1, prev = B[i - count + 1];
                for (int j = i - count + 1; j <= i; j++) {
                    if (B[j] != prev)
                        s++;
                    prev = B[j];
                }
                sum += s + 1;
                count = 0;
                totalWeight = 0;
            }
        }
        return sum;
    }

    static void test() {
        int[] A = new int[]{60, 60, 60};
        int[] B = new int[]{5, 5, 3};
        int M = 5;
        int X = 3;
        int Y = 120;
        int n = solution(A, B, M, X, Y);
        System.out.println(n == 4 ? "true" : "false");
    }
}

public class VSTTest {
}
