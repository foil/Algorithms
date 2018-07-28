package com.pillow;

public class GCDArray {
    int gcd(int a, int b) {
        if (a == b)
            return a;
        else if (a > b)
            return gcd(a - b, b);
        else
            return gcd(a, b - a);
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr)
    {
        // WRITE YOUR CODE HERE
        int minGcd = 0;
        for (int i = 0; i < num - 1; i ++) {
            for (int j = i + 1; j < num; j ++) {
                if (minGcd == 0)
                    minGcd = gcd(arr[i], arr[j]);
                else
                    minGcd = gcd(minGcd, arr[j]);
                if (minGcd == 1)
                    return minGcd;
            }
        }
        return minGcd;
    }
}
