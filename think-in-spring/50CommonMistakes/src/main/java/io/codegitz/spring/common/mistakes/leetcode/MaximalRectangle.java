package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 张观权
 * @date 2021/9/22 12:57
 *
 * 85. Maximal Rectangle
 * Hard
 *
 * 5088
 *
 * 93
 *
 * Add to List
 *
 * Share
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * Example 2:
 *
 * Input: matrix = []
 * Output: 0
 * Example 3:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 * Example 4:
 *
 * Input: matrix = [["1"]]
 * Output: 1
 * Example 5:
 *
 * Input: matrix = [["0","0"]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * rows == matrix.length
 * cols == matrix[i].length
 * 0 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 *
 **/
public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int max = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1'){
                    height[j]++;
                }else {
                    height[j] = 0;
                }
            }
            max = Math.max(max,largestRectangleArea(height));
        }
        return max;
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }
        if (heights.length == 1){
            return heights[0];
        }
        int[] newHeights = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;

        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 1; i < newHeights.length; i++) {
            while (heights[stack.peekLast()] > heights[i]){
                int height = heights[stack.removeLast()];
                int mid = i - stack.peekLast() - 1;
                max = Math.max(max,height * mid);
            }
            stack.addLast(i);
        }
        return max;
    }
}
