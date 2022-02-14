package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张观权
 * @date 2021/10/21 13:25
 *
 * 130. Surrounded Regions
 * Medium
 *
 * 3571
 *
 * 904
 *
 * Add to List
 *
 * Share
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * Example 2:
 *
 * Input: board = [["X"]]
 * Output: [["X"]]
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 *
 **/
public class SurroundedRegions {
    public void solve(char[][] board) {

    }

    public static void main(String[] args) {
//        double[] doubles = dicesProbability(4);
//        输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
//        System.out.println(doubles);
    }

    public static double[] dicesProbability(int n){
        if ( n == 0){
            return new double[1];
        }
        int[] nums = new int[6];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,0,n,nums,new ArrayList<Integer>());
        Map<Integer,Integer> cache = new HashMap<>();
        for (int i = 0; i < result.size(); i++) {
            List<Integer> permutation = result.get(i);
            int key = permutation.stream().mapToInt(a -> a).sum();
            cache.put(key,cache.getOrDefault(key,0) + 1 );
        }
        int size = cache.size();
        int order = n;
        double[] doubles = new double[size];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = cache.get(order) / (result.size() * 1.0);
            order++;
        }
        return doubles;
    }

    private static void dfs(List<List<Integer>> result, int pos, int deep, int[] nums, ArrayList<Integer> tmp) {
        if (pos == deep){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(result,pos + 1,deep,nums,tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
