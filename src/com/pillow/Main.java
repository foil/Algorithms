package com.pillow;

public class Main {
    static void swap(int i, int j, int[] na) {
        int t = na[i];
        na[i] = na[j];
        na[j] = t;
    }

    static void quickSort(int l, int h, int[] A) {
        if (l < h) {
            int p = partition(A, l, h);
            quickSort(p + 1, h, A);
            quickSort(l, p - 1, A);
        }
    }
    static int partition(int[] A, int l, int h) {
        int i = l;
        int pivot = A[h];
        for (int j = i; j < h; j ++) {
            if (A[j] < pivot) {
                swap(i, j, A);
                i ++;
            }
        }
        swap(i, h, A);
        return i;
    }

    static String countAndSay(int n) {
        String cur = "1";
        for (int i = 2; i <= n; i ++) {
            String tmp = "";
            char c = cur.charAt(0);
            int m = 1;
            for (int k = 1; k < cur.length(); k ++) {
                if (cur.charAt(k) == c)
                    m++;
                else {
                    tmp += m;
                    tmp += c;
                    c = cur.charAt(k);
                    m = 1;
                }
            }
            tmp += m;
            tmp += c;
            cur = tmp;
        }
        return cur;
    }

    public static void main(String args[]) throws Exception {
        System.out.println(countAndSay(4));
    }
}
