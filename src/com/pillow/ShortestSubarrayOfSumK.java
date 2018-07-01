package com.pillow;

public class ShortestSubarrayOfSumK {
    public int shortestSubarray(int[] A, int K) {
        int sum[] = new int[A.length];
        int start = 0;
        int minLen = -1;
        for (int i = 0; i < A.length; i ++) {
            if (i == 0 || sum[i - 1] <= 0)
                sum[i] = A[i];
            else
                sum[i] = sum[i-1] + A[i];

            if (sum[i] <= 0)
                start = i + 1;
            else if (sum[i] >= K) {
                for (int j = start; j < i; j ++)
                    if (sum[i] - sum[j] >= K) {
                        start = j + 1;
                    }
                int len = i - start + 1;
                if (minLen == -1 || len < minLen)
                    minLen = len;
            }
        }
        return minLen;
    }
}
