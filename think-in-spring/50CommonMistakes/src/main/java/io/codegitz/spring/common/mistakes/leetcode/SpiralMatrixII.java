package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/9/9 15:22
 *
 * 59. Spiral Matrix II
 * Medium
 *
 * 1962
 *
 * 143
 *
 * Add to List
 *
 * Share
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 *
 **/
public class SpiralMatrixII {
    public static void main(String[] args) {
        generateMatrix(3);
    }
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n;
        int cloBegin = 0;
        int cloEnd = n;
        int number = 1;

        while (rowBegin <= rowEnd && cloBegin <= cloEnd){
            for (int i = cloBegin; i < cloEnd; i++) {
                result[rowBegin][i] = number;
                number++;
            }
            rowBegin++;
            for (int i = rowBegin; i < rowEnd; i++) {
                result[i][cloEnd - 1] = number;
                number++;
            }
            cloEnd--;
            if (rowBegin <= rowEnd){
                for (int i = cloEnd - 1; i >= cloBegin ; i--) {
                    result[rowEnd - 1][i] = number;
                    number++;
                }
                rowEnd--;
            }
            if (cloBegin <= cloEnd){
                for (int i = rowEnd - 1; i >= rowBegin ; i--) {
                    result[i][cloBegin] = number;
                    number++;
                }
                cloBegin++;
            }
        }
        return result;
    }
}
