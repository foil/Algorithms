package com.pillow;

import java.util.ArrayList;
import java.util.List;

public class MaxSwap {
    public static int maximumSwap(int num) {
        List<Integer> l = new ArrayList<>();
        while (num > 0) {
            l.add(num % 10);
            num /= 10;
        }
        boolean swapped = false;
        for (int i = l.size() - 1; i >= 1; i --) {
            int maxIndex = i - 1;
            for (int j = i - 1; j >= 0; j --) {
                if (l.get(j) >= l.get(maxIndex))
                    maxIndex = j;
            }
            if (l.get(i) < l.get(maxIndex) && !swapped) {
                int tmp = l.get(i);
                l.set(i, l.get(maxIndex));
                l.set(maxIndex, tmp);
                swapped = true;
            }
        }
        int max = 0;
        for (int i = l.size() - 1; i >= 0; i --)
            max = max * 10 + l.get(i);
        return max;
    }
}
