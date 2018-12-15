package com.pillow;

import java.util.HashSet;
import java.util.Set;
class WordSearch {
    private boolean backtrack(char[][] B, int i, int j, String W, int k, Set<Integer> visited) {
        if (k == W.length())
            return true;

        char ch = W.charAt(k);
        if (i >= 0 && i < B.length &&
            j >= 0 && j < B[0].length &&
            ch == B[i][j] && !visited.contains(i * B[0].length + j)) {
            visited.add(i * B[0].length + j);
            int[] rx = new int[] {-1, 0, 1, 0};
            int[] ry = new int[] {0, -1, 0, 1};
            System.out.println(String.format("%d, %d, %c, %c", i, j, ch, B[i][j]));
            for (int p = 0; p < rx.length; p ++) {
                if (backtrack(B, i + ry[p], j + rx[p], W, k + 1, visited)) {
                    return true;
                }
            }
            visited.remove(i * B[0].length + j);
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i ++)
            for (int j = 0; j < board[0].length; j ++) {
                if (backtrack(board, i, j, word, 0, new HashSet<Integer>()))
                    return true;
            }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'a','a','a','a'},
            {'a','a','a','a'},
            {'a','a','a','a'},
            {'a','a','a','a'},
            {'a','a','a','b'}
        };
        String word = "aaaaaaaaaaaaaaaaaaaa";
        WordSearch s = new WordSearch();
        System.out.println(s.exist(board, word));
    }
}
