package io.codegitz.spring.common.mistakes.leetcode;

import java.util.*;

/**
 * @author 张观权
 * @date 2021/9/15 15:15
 *
 * 73. Set Matrix Zeroes
 * Medium
 *
 * 4592
 *
 * 411
 *
 * Add to List
 *
 * Share
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
 *
 * You must do it in place.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * Example 2:
 *
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 *
 * Follow up:
 *
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 **/
public class SetMatrixZeroes {
    public static void main(String[] args) {
//        [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        int[][] matrix = new int[][]{{1,0}};
        setZeroes(matrix);
    }
    public static void setZeroes1(int[][] matrix) {
        if (matrix == null){
            return;
        }
        Set<Integer> row = new HashSet<>();
        Set<Integer> clo = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    row.add(i);
                    clo.add(j);
                }
            }
        }
        Iterator<Integer> iterator = row.iterator();
        while (iterator.hasNext()){
            Arrays.fill(matrix[iterator.next()],0);
        }
        Iterator<Integer> iterator1 = clo.iterator();
        while (iterator1.hasNext()){
            Integer clomn = iterator1.next();
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][clomn] = 0;
            }
        }
    }
    public static void setZeroes(int[][] matrix) {
        if (matrix == null){
            return;
        }
        Set<Integer> clo = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            boolean flag = false;
            for (Integer integer : clo) {
                for (int k = 0; k < matrix.length; k++) {
                    matrix[k][integer] = 0;
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                if (clo.contains(j)){
                    continue;
                }
                if (matrix[i][j] == 0){
                    flag = true;
                    clo.add(j);
                }
            }
            if (flag){
                Arrays.fill(matrix[i],0);
            }
        }
    }
}
