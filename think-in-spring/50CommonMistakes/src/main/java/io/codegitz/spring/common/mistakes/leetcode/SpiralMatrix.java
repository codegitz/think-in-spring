package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/9/1 14:16
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 **/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> li = new ArrayList<Integer>();
        int n = matrix.length, m = matrix[0].length;
        int count = n*m;
        int rmin = 0, cmin = 0, rmax = n - 1, cmax = m - 1;
        while(count != 0){
            for(int c = cmin; c <= cmax && count > 0; c++){
                li.add(matrix[rmin][c]);
                count--;
            }
            rmin++;

            for(int r = rmin; r <= rmax && count > 0; r++){
                li.add(matrix[r][cmax]);
                count--;
            }
            cmax--;

            for(int c = cmax; c >= cmin && count > 0; c--){
                li.add(matrix[rmax][c]);
                count--;
            }
            rmax--;


            for(int r = rmax; r >= rmin && count > 0; r--){
                li.add(matrix[r][cmin]);
                count--;
            }
            cmin++;

        }
        return li;
    }
}
