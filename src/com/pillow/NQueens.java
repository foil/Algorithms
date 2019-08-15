package com.pillow;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class NQueens {
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> result = new ArrayList<>();
        bt(0, board, result);
        return result;
    }
    private static void bt(int y, int[][] board, List<List<String>> result) {
        for (int[] r: board)
            System.out.println(Arrays.toString(r));
        System.out.println();
        if (y == board.length) {
            System.out.println("good");
            List<String> l = new ArrayList<>();
            for (int[] r: board) {
                String s = "";
                for (int n: r)
                    s += (n == 1? 'Q': '.');
                l.add(s);
            }
            result.add(l);
        } else
        for (int x = 0; x < board.length; x ++) {
            if (board[y][x] == 0) {
                board[y][x] = 1;
                for (int yy = y + 1; yy < board.length; yy ++) {
                    board[yy][x] -= 1;
                    int xx = x - (yy - y);
                    if (xx >= 0)
                        board[yy][xx] -=1;
                    xx = x + (yy - y);
                    if (xx < board.length)
                        board[yy][xx] -=1;
                }
                bt(y + 1, board, result);
                board[y][x] = 0;
                for (int yy = y + 1; yy < board.length; yy ++) {
                    board[yy][x] += 1;
                    int xx = x - (yy - y);
                    if (xx >= 0)
                        board[yy][xx] += 1;
                    xx = x + (yy - y);
                    if (xx < board.length)
                        board[yy][xx] += 1;
                }
            
                System.out.println("bt:");
                for (int[] r: board)
                    System.out.println(Arrays.toString(r));
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        NQueens s = new NQueens();
        s.solveNQueens(4);
    }
}
