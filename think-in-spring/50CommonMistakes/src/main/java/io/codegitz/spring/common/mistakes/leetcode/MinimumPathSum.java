package io.codegitz.spring.common.mistakes.leetcode;

import java.util.Arrays;

/**
 * @author 张观权
 * @date 2021/9/13 17:19
 *
 * 64. Minimum Path Sum
 * Medium
 *
 * 5635
 *
 * 87
 *
 * Add to List
 *
 * Share
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 **/
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
        int i = minPathSum(grid);
        System.out.println(i);
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        for (int i = 0; i < path.length; i++) {
            Arrays.fill(path[i],-1);
        }
        path[m - 1][n - 1] = grid[m - 1][n - 1];
        return getPath(grid,path,0,0,m,n);
    }

    private static int getPath(int[][] grid,int[][] path, int i, int j, int m, int n) {
        if (path[i][j] != -1){
            return path[i][j];
        }
        int rightCount = Integer.MAX_VALUE;
        int downCount = Integer.MAX_VALUE;
        if (i < m - 1){
            rightCount = getPath(grid,path,i + 1,j,m,n);
        }
        if (j < n - 1){
            downCount = getPath(grid,path,i,j + 1,m,n);
        }
        path[i][j] = grid[i][j] + Math.min(rightCount,downCount);
        return path[i][j];
    }
}
