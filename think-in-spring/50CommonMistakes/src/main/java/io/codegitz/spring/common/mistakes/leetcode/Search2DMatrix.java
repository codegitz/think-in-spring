package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/9/15 19:07
 *
 * 74. Search a 2D Matrix
 * Medium
 *
 * 4419
 *
 * 215
 *
 * Add to List
 *
 * Share
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 **/
public class Search2DMatrix {
    //[[1,3,5,7],[10,11,16,20],[23,30,34,60]]
//    [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
//            20
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null){
            return false;
        }
        boolean flag = false;
        int row = matrix.length - 1;
        int targetRow = getRow(matrix,target,0,row);
        if (targetRow == -1){
            return flag;
        }
        for (int i = 0; i < matrix[targetRow].length; i++) {
            if (target == matrix[targetRow][i]){
                flag = true;
                break;
            }
        }
        return flag;
    }

    private int getRow(int[][] matrix, int target, int left, int right) {

        if (left > right){
            return -1;
        }
        if (left == right){
            return left;
        }
        int mid = (left + right) / 2;
        if (matrix[mid][0] == target){
            return mid;
        }
        if (matrix[mid][0] > target){
            return getRow(matrix,target,left,mid - 1);
        }else {
            if (matrix[mid][matrix[0].length - 1] >= target){
                return mid;
            }
            return getRow(matrix,target,mid + 1,right);
        }
    }
}
