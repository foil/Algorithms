package com.pillow;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class MinHTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[][] distances = new int[n][n];
        for (int[] e: edges) {
            distances[e[0]][e[1]] = 1;
            distances[e[1]][e[0]] = 1;
        }
        for (int y = 0; y < n; y ++) {
            for (int x = 0; x < n; x ++) {
                if (distances[y][x] == 0)
                    continue;
                for (int t = 0; t < n; t ++) {
                    if (t != y && distances[x][t] == 1 && distances[y][t] == 0) {
                        // System.out.printf("%d-%d: %d, %d-%d: %d\n",
                                          // y, x, distances[y][x],
                                          // x, t, distances[x][t]);
                        distances[y][t] = distances[y][x] + 1;
                        distances[t][y] = distances[y][t];
                    }
                }
            }
        }
        int lineMax = Integer.MAX_VALUE;
        int[] maxs = new int[n];
        for (int y = 0; y < n; y ++) {
            int max = 0;
            for (int x = 0; x < n; x ++)
                max = Math.max(max, distances[y][x]);
            // System.out.printf("y: %d, max: %d\n", y, max);
            maxs[y] = max;
            lineMax = Math.min(lineMax, max);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            if (maxs[i] == lineMax)
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        MinHTrees s = new MinHTrees();
        int[][] edges = new int[][] {
            {0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}
        };
        List<Integer> l = s.findMinHeightTrees(6, edges);
        System.out.println(Arrays.toString(l.stream().mapToInt(i -> i).toArray()));
    }
}
