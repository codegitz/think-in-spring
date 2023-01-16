package io.codegitz.spring.common.mistakes.leetcode;

/**
 *
 *
 * 695. Max Area of Island
 * Medium
 *
 * 6619
 *
 * 155
 *
 * Add to List
 *
 * Share
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 *
 *
 * [
 * [0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *
 * Example 2:
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 *
 * @author Codegitz
 * @date 2022/7/15 14:34
 **/
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int[][] gird = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int areaOfIsland = maxAreaOfIsland.maxAreaOfIsland(gird);
        System.out.println(areaOfIsland);
    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null){
            return 0;
        }
        boolean[][] used = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0){
                    continue;
                }
                max = Math.max(dfs(grid,used,i,j) ,max);
            }
        }
        return max;
    }

    private int dfs(int[][] grid, boolean[][] used, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return 0;
        }
        if (used[i][j]){
            return 0;
        }
        if (grid[i][j] == 0){
            return 0;
        }
        used[i][j] = true;
        int area = 0;
        area += dfs(grid,used,i + 1,j);
        area += dfs(grid,used,i - 1,j);
        area += dfs(grid,used,i,j + 1);
        area += dfs(grid,used,i,j - 1);
//        used[i][j] = false;
        return area + 1;
    }
}
