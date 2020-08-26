package com.pillow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AmazonTest {
    private final static String id = "23280666465968";

    ArrayList<Integer> IDsOfPackages(int truckSpace,
                                     ArrayList<Integer> packagesSpace)
    {
        // WRITE YOUR CODE HERE
        ArrayList<Integer> res = new ArrayList<>(2);
        int target = truckSpace - 30;
        if (target <= 0)
            return res;
        int n1 = -1, n2 = -1;
        ArrayList<Integer> tmp = new ArrayList<>(packagesSpace);
        Collections.sort(tmp);
        int i = 0, j = tmp.size() - 1;
        while (i < j) {
            int sum = tmp.get(i) + tmp.get(j);
            if (sum == target) {
                n1 = tmp.get(i);
                n2 = tmp.get(j);
                break;
            }
            if (sum > target)
                j--;
            else
                i++;
        }
        if (n1 > 0) {
            for (i = packagesSpace.size() - 1; i >= 0; i --) {
                if (packagesSpace.get(i) == n2 || packagesSpace.get(i) == n1)
                    res.add(i);
                if (res.size() == 2)
                    break;
            }
        }
        return res;
    }

    int removeObstacle(int[][] lot) {
        // WRITE YOUR CODE HERE
        int numRows = lot.length, numColumns = lot[0].length;
        int n = numColumns * numRows;

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        boolean[] visited = new boolean[n];

        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{-1, 0, 1, 0};

        for (int i = 0; i < n; i++) {
            int minDistance = Integer.MAX_VALUE;
            int p = 0;
            for (int j = 0; j < n; j ++) {
                if (!visited[j] && distances[j] < minDistance) {
                    p = j;
                    minDistance = distances[j];
                }
            }
            visited[p] = true;
            int x = p % numColumns, y = p / numRows;
            for (int d = 0; d < dy.length; d ++) {
                int ty = y + dy[d], tx = x + dx[d];
                if (tx < 0 || tx >= numColumns || ty < 0 || ty >= numRows)
                    continue;
                int v = lot[ty][tx];
                if (v != 0) {
                    distances[ty * numRows + tx] = minDistance + 1;
                    if (v == 9)
                        return minDistance + 1;
                }
            }
        }

        return -1;
    }

    int numberAmazonGoStores(int rows, int column, List<List<Integer> > grid)
    {
        // WRITE YOUR CODE HERE
        int count = 0;
        for (int r = 0; r < rows; r ++) {
            for (int c = 0; c < column; c ++) {
                count += dfs(r, c, rows, column, grid);
            }
        }
        return count;
    }
    private int dfs(int r, int c, int rows, int column, List<List<Integer>> grid) {
        if (r < 0 || r >= rows || c < 0 || c >= column)
            return 0;
        int v = grid.get(r).get(c);
        if (v == 1) {
            grid.get(r).set(c, 0);
            dfs(r + 1, c, rows, column, grid);
            dfs(r - 1, c, rows, column, grid);
            dfs(r, c + 1, rows, column, grid);
            dfs(r, c - 1, rows, column, grid);
            return 1;
        }
        return 0;
    }

    int minimumDays(int rows, int columns, List<List<Integer> > grid)
    {
        // WRITE YOUR CODE HERE
        boolean none = true;
        for (int r = 0; r < rows; r ++) {
            for (int c = 0; c < columns; c++) {
                if (grid.get(r).get(c) == 1) {
                    none = false;
                    break;
                }
            }
        }
        if (none)
            return -1;

        boolean[][] tags = new boolean[rows][columns];
        int days = 0;
        for (;; days++) {
            for (int r = 0; r < rows; r ++) {
                System.out.println(grid.get(r));
            }
            System.out.println();

            boolean done = true;
            for (int r = 0; r < rows; r ++) {
                for (int c = 0; c < columns; c++) {
                    if (grid.get(r).get(c) == 0) {
                        done = false;
                        break;
                    }
                }
            }
            if (done)
                break;

            for (int r = 0; r < rows; r ++) {
                for (int c = 0; c < columns; c++)
                    tags[r][c] = false;
            }
            for (int r = 0; r < rows; r ++) {
                for (int c = 0; c < columns; c ++) {
                    if (grid.get(r).get(c) == 1 && !tags[r][c]) {
                        update(r + 1, c, rows, columns, grid, tags);
                        update(r - 1, c, rows, columns, grid, tags);
                        update(r, c + 1, rows, columns, grid, tags);
                        update(r, c - 1, rows, columns, grid, tags);
                    }
                }
            }
        }
        return days;
    }
    private void update(int r, int c, int rows, int column, List<List<Integer>> grid, boolean[][] tags) {
        if (r >= 0 && r < rows && c >= 0 && c < column && grid.get(r).get(c) == 0) {
            grid.get(r).set(c, 1);
            tags[r][c] = true;
        }
    }

    public static void main(String[] args) {
        AmazonTest a = new AmazonTest();
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1,1,1));
        grid.add(Arrays.asList(1,1,1));
        grid.add(Arrays.asList(1,1,1));
        System.out.println(a.minimumDays(3,3,grid));
    }
}
