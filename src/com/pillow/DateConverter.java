package com.pillow;

import java.util.Scanner;

public class DateConverter {
    static void convert() {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arr = input.split(" ");
        int n = Integer.valueOf(arr[0]);
        int o = Integer.valueOf(arr[1]);

        int[] list = new int[n];
        for (int i = 0; i < o; i ++) {
            input = scanner.nextLine();
            arr = input.split(" ");
            int l = Integer.valueOf(arr[0]);
            int r = Integer.valueOf(arr[1]);
            int k = Integer.valueOf(arr[2]);
            for (int j = 0; j < (r - l + 1); j ++) {
                list[l - 1 + j] += k;
            }
        }

        int max = list[0];
        for (int i = 1; i < n; i ++) {
            if (list[i] > max)
                max = list[i];
        }
        System.out.println(max);
    }
}
