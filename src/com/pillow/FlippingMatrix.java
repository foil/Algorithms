package com.pillow;

public class FlippingMatrix {
    public int matrixScore(int[][] A) {
        int x = A[0].length;
        int y = A.length;
        for (int i = 0; i < y; i ++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < x; j++)
                    A[i][j] = 1 - A[i][j];
            }
        }
        for (int i = 0; i < x; i ++) {
            int numZero = 0;
            for (int j = 0; j < y; j ++) {
                if (A[j][i] == 0)
                    numZero++;
            }
            if (numZero > y - numZero) {
                for (int j = 0; j < y; j ++)
                    A[j][i] = 1 - A[j][i];
            }
        }
        int sum = 0;
        for (int[] t: A) {
            int subsum = 0;
            for (int i: t)
                subsum = subsum * 2 + i;
            sum += subsum;
        }
        return sum;
    }
}
