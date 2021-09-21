package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/8/30 16:56
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * Example 2:
 *
 * Input: n = 1
 * Output: [["Q"]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 *
 **/
public class NQueensI {

    private boolean[] clo;
    boolean[] diag;
    boolean[] diag2;
    String[][] board;
    private List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        clo = new boolean[n];
        diag = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        board = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i],".");
        }
        nQueens(0,n);
        return result;
    }

    private void nQueens(int y, int n) {
        if (y == n){
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int i1 = board[i].length - 1; i1 >= 0; i1--) {
                    sb.append(board[i][i1]);
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        for (int x = 0; x < n; x++) {
            if (!available(x,y,n)){
                continue;
            }
            update(x,y,n,true);
            nQueens(y + 1,n);
            update(x,y,n,false);
        }
    }

    private void update(int x, int y, int n ,boolean available) {
        clo[x] = available;
        diag[x + y] = available;
        diag2[x - y + (n - 1)] = available;
        board[x][y] = available ? "Q" : ".";
    }

    private boolean available(int x, int y,int n) {
        return !clo[x] && !diag[x + y] && !diag2[x - y + (n - 1)];
    }
}
