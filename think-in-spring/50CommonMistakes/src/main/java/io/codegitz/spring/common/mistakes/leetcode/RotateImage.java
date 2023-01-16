package io.codegitz.spring.common.mistakes.leetcode;

/**
 *
 * 48. Rotate Image
 * Medium
 *
 * 11114
 *
 * 550
 *
 * Add to List
 *
 * Share
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 *
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 * @author Codegitz
 * @date 2022/8/30 11:18
 **/
public class RotateImage {
    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6}, {7,8,9}};
        rotateImage.rotate(matrix);
        System.out.println(matrix);
    }
    public void rotate(int[][] matrix) {
        if (matrix.length == 1){
            return;
        }
        boolean[][] used = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                if (used[i][j]){
                    continue;
                }
                swap(i,j,matrix,matrix.length - 1,used);
            }
        }
    }

    private void swap(int i, int j, int[][] matrix,int n,boolean[][] used) {
        int row = j;
        int col = n - i;
        int ti = i,tj = j;
        int tmp = matrix[i][j];
        while (row != i || col != j){
            tmp = swapValue(tmp,matrix,row,col);
            used[row][col] = true;
            ti = row;
            tj = col;
            row = tj;
            col = n - ti;
        }
        matrix[i][j] = tmp;
        used[i][j] = true;
    }

    private int swapValue(int tmp, int[][] matrix, int row, int col) {
        int value = matrix[row][col];
        matrix[row][col] = tmp;
        return value;
    }
}
