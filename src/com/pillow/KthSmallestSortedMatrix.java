package com.pillow;

public class KthSmallestSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;
        int x = 0, y = 0, n = 0;
        while (x1 < matrix.length && y1 < matrix.length &&
                x2 < matrix.length && y2 < matrix.length) {
            System.out.println("[" + y1 + "][" + x1 + "]:" + matrix[y1][x1] +
                    "; [" + y2 + "][" + x2 + "]:" + matrix[y2][x2]);
            if (x1 == x2 && y1 == y2) {
                x = x1; y = y1;
                x1 ++;
                y2 ++;
                n ++;
            } else {
                if (matrix[y1][x1] < matrix[y2][x2]) {
                    x = x1;
                    y = y1;
                    x1 ++;
                    n ++;
                } else if (matrix[y1][x1] > matrix[y2][x2]) {
                    x = x2; y = y2;
                    y2 ++;
                    n ++;
                } else {
                    x = x1; y = y1;
                    x1 ++; y2 ++;
                    n += 2;
                }
            }
            if (x1 == matrix.length) {
                y1++;
            }
            if (y2 == matrix.length) {
                x2++;
            }
            if (x1 == matrix.length) {
                x1 = x2 + 1;
            }
            if (y2 == matrix.length) {
                y2 = y1 + 1;
            }

            System.out.println(matrix[y][x]);
            if (n >= k)
                return matrix[y][x];
        }
        return matrix[matrix.length - 1][matrix.length - 1];
    }
}
