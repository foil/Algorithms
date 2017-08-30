package com.pillow;

public class MaxProfit {
    static int maxProfit(int costPerCut, int salePrice, int[] lengths) {
        int min = lengths[0];
        for (int i = 1; i < lengths.length; i ++)
            if (lengths[i] < min)
                min = lengths[i];

        //  try the saleLength
        int max = 0;
        for (int i = 1; i <= min; i ++) {
            int sum = 0;
            for (int j = 0; j < lengths.length; j ++) {
                int cut = (lengths[j] % i == 0)? 0: (lengths[j] / i) - 1;
                int remain = (lengths[j] % i);
                sum += (lengths[j] - remain) * salePrice - cut * costPerCut;
            }
            if (sum > max)
                max = sum;
        }
        return max;
    }
}
