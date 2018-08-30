package com.pillow;

public class FriendCircles {
    void dfs(int[][] M, int i, int j, int[][] visited, int count) {
        System.out.println("" + i + ", " + j);
        visited[i][j] = count;
        for (int jj = j + 1; jj < M.length; jj ++) {
            if (M[i][jj] == 1 && visited[i][jj] == 0) {
                visited[i][jj] = count;
                for (int k = 0; k < M.length; k++) {
                    if (M[jj][k] == 1 && visited[jj][k] == 0)
                        dfs(M, jj, k, visited, count);
                }
            }
        }
        for (int k = 0; k < M.length; k ++) {
            if (M[j][k] == 1 && visited[j][k] == 0)
                dfs(M, j, k, visited, count);
        }
    }
    public int findCircleNum(int[][] M) {
        int N = M.length;
        int[][] visited = new int[N][N];
        int count = 0;
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if (M[i][j] == 1 && visited[i][j] == 0)
                    dfs(M, i, j, visited, ++count);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FriendCircles s = new FriendCircles();
        int[][] M = new int[][] {
                new int[] {1,1,0},
                new int[] {1,1,0},
                new int[] {0,0,1}
        };
        System.out.println(s.findCircleNum(M));
    }
}
