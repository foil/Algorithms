package com.pillow;

public class LonglyInterger {
    static int lonelyInteger(int[] arr) {
        int[] map = new int[101];

        for (int i = 0; i < arr[0]; i ++) {
            int num = arr[i + 1];
            map[num] = map[num] + 1;
        }
        for (int i = 0; i < 101; i ++) {
            if (map[i] == 1)
                return i;
        }
        return 0;
    }
}
