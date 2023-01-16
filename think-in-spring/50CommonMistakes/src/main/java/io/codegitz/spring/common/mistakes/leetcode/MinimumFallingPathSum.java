package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author Codegitz
 * @date 2022/12/13 11:38
 **/
public class MinimumFallingPathSum {
    public static void main(String[] args) {
        MinimumFallingPathSum minimumFallingPathSum = new MinimumFallingPathSum();
        int[][] matrix = new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        int sum = minimumFallingPathSum.minFallingPathSum(matrix);
        System.out.println(sum);
    }
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1] = matrix[m - 1];
        for(int i = m - 2 ; i >= 0 ; i--){
            for(int j = 0 ; j < n ; j++){
                int min = Integer.MAX_VALUE;
                // get minimuns value from (i + 1,j - 1), (i + 1, j), (i + 1,j + 1)
                if(j - 1 >= 0){
                    min = Math.min(dp[i + 1][j - 1],min);
                }
                if(j + 1 < n){
                    min = Math.min(dp[i + 1][j + 1],min);
                }
                min = Math.min(dp[i + 1][j],min);
                dp[i][j] = min + matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int num : dp[0]){
            min = Math.min(min,num);
        }
        return min;
    }
}
