package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/10/15 13:33
 *
 * 118. Pascal's Triangle
 * Easy
 *
 * 3806
 *
 * 167
 *
 * Add to List
 *
 * Share
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 **/
public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        System.out.println(generate);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0){
            return result;
        }
        int[][] matrix = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i - 1 >= 0 && j - 1 >= 0){
                    matrix[i][j] = matrix[i - 1][j] + matrix[i - 1][j - 1];
                }else {
                    matrix[i][j] = 1;
                }
                list.add(matrix[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}
