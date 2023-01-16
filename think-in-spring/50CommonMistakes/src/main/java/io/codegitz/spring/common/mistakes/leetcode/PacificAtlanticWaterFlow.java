package io.codegitz.spring.common.mistakes.leetcode;

import java.util.*;

/**
 *
 * 417. Pacific Atlantic Water Flow
 * Medium
 *
 * 4582
 *
 * 960
 *
 * Add to List
 *
 * Share
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
 * [0,4]: [0,4] -> Pacific Ocean
 *        [0,4] -> Atlantic Ocean
 * [1,3]: [1,3] -> [0,3] -> Pacific Ocean
 *        [1,3] -> [1,4] -> Atlantic Ocean
 * [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
 *        [1,4] -> Atlantic Ocean
 * [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
 *        [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
 * [3,0]: [3,0] -> Pacific Ocean
 *        [3,0] -> [4,0] -> Atlantic Ocean
 * [3,1]: [3,1] -> [3,0] -> Pacific Ocean
 *        [3,1] -> [4,1] -> Atlantic Ocean
 * [4,0]: [4,0] -> Pacific Ocean
 *        [4,0] -> Atlantic Ocean
 * Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
 * Example 2:
 *
 * Input: heights = [[1]]
 * Output: [[0,0]]
 * Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.
 *
 *
 * Constraints:
 *
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 105
 *
 * @author Codegitz
 * @date 2022/8/31 10:56
 **/
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a +","+ b);
    }
    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] can = new boolean[heights.length][heights[0].length];
        boolean[][] canP = new boolean[heights.length][heights[0].length];
        boolean[][] canA = new boolean[heights.length][heights[0].length];
        boolean[][] used = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (can[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                    continue;
                }
                if(dfsPacific(i,j,heights,used,can,canP) && dfsAtlantic(i,j,heights,used,can,canA)){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                    can[i][j] = true;
                }
            }
        }
        return result;
    }

    private boolean dfsAtlantic(int i, int j, int[][] heights, boolean[][] used, boolean[][] can, boolean[][] scan) {
        if (can[i][j]){
            return true;
        }
        if(i == heights.length - 1 || j == heights[0].length - 1){
            scan[i][j] = true;
            return true;
        }
        if (used[i][j]){
            return false;
        }
        used[i][j] = true;
        boolean top = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;
        if (i - 1 >= 0 && heights[i][j] >= heights[i - 1][j]){
            top = dfsAtlantic(i - 1,j,heights,used,can,scan);
        }
        if (i + 1 < heights.length && heights[i][j] >= heights[i + 1][j]){
            down = dfsAtlantic(i + 1,j,heights,used,can,scan);
        }
        if (j - 1 >= 0 && heights[i][j] >= heights[i][j - 1]){
            left = dfsAtlantic(i,j - 1,heights,used,can,scan);
        }
        if (j + 1 < heights[0].length && heights[i][j] >= heights[i][j + 1]){
            right = dfsAtlantic(i,j + 1,heights,used,can,scan);
        }
        used[i][j] = false;
        if (top || down || left || right){
            scan[i][j] = true;
        }
        return top || down || left || right;

    }

    private boolean dfsPacific(int i, int j, int[][] heights, boolean[][] used, boolean[][] can, boolean[][] scan) {
        if (can[i][j]){
            return true;
        }
        if(i == 0 || j == 0){
            scan[i][j] = true;
            return true;
        }
        if (used[i][j]){
            return false;
        }
        used[i][j] = true;
        boolean top = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;
        if (i - 1 >= 0 && heights[i][j] >= heights[i - 1][j]){
            top = dfsPacific(i - 1,j,heights,used,can,scan);
        }
        if (i + 1 < heights.length && heights[i][j] >= heights[i + 1][j]){
            down = dfsPacific(i + 1,j,heights,used,can,scan);
        }
        if (j - 1 >= 0 && heights[i][j] >= heights[i][j - 1]){
            left = dfsPacific(i,j - 1,heights,used,can,scan);
        }
        if (j + 1 < heights[0].length && heights[i][j] >= heights[i][j + 1]){
            right = dfsPacific(i,j + 1,heights,used,can,scan);
        }
        used[i][j] = false;
        if (top || down || left || right){
            scan[i][j] = true;
        }
        return top || down || left || right;
    }
}
