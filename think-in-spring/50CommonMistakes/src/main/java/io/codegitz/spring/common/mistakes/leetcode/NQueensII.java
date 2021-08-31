package io.codegitz.spring.common.mistakes.leetcode;

import java.util.Arrays;

/**
 * @author 张观权
 * @date 2021/8/31 9:58
 *
 * 52. N-Queens II
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 *
 **/
public class NQueensII {
    private String[][] board;
    private boolean[] clo;
    private boolean[] diag;
    private boolean[] diag2;
    private int result;
    public int totalNQueens(int n) {
        board = new String[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i],".");
        }
        clo = new boolean[n];
        diag = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        result = 0;
        nQueens(0,n);
        return result;
    }

    private void nQueens(int y ,int n) {
        if (y == n){
            result++;
            return;
        }
        for (int x = 0; x < n ; x++){
            if (!available(x,y,n)){
                continue;
            }
            update(x,y,n,true);
            nQueens(y + 1,n);
            update(x,y,n,false);
        }
    }

    private boolean available(int x, int y, int n) {
        return !clo[x] && !diag[x + y] && !diag2[x - y + n - 1];
    }

    private void update(int x, int y, int n, boolean b) {
       clo[x] = b;
       diag[x + y] = b;
       diag2[x - y + n - 1] = b;
       board[x][y] = b ? "Q" : ".";
    }
}
