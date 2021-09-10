package io.codegitz.spring.common.mistakes.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 张观权
 * @date 2021/9/10 17:11
 *
 * 62. Unique Paths
 * Medium
 *
 * 6291
 *
 * 259
 *
 * Add to List
 *
 * Share
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * Example 3:
 *
 * Input: m = 7, n = 3
 * Output: 28
 * Example 4:
 *
 * Input: m = 3, n = 3
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 109.
 *
 **/
public class UniquePaths {
    public static void main(String[] args) {
        int paths = uniquePaths(23, 12);
        System.out.println(paths);
    }
    public static int uniquePaths(int m, int n) {
        AtomicInteger sum = new AtomicInteger(0);
        boolean[][] board = new boolean[m][n];
        board[m - 1][n - 1] = true;
        getPath(board,0,0,m,n,sum);
        return sum.get();
    }

    private static void getPath(boolean[][] board, int row, int clo, int m, int n, AtomicInteger sum) {
        if (board[row][clo]){
            sum.set(sum.get() + 1);
            return;
        }
        if (row < m - 1){
            getPath(board,row + 1,clo,m,n,sum);
        }
        if (clo < n - 1){
            getPath(board,row,clo + 1,m,n,sum);
        }
    }
}
