package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author Codegitz
 * @date 2022/12/4 15:10
 **/
public class MinimumAverageDifference {
    public static void main(String[] args) {
        MinimumAverageDifference minimumAverageDifference = new MinimumAverageDifference();
        int i = minimumAverageDifference.minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3});
        System.out.println(i);
    }
    public int minimumAverageDifference(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        int min = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 2 ; i <= n ; i++){
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        for(int i = 1 ; i <= n ; i++){
            int left = dp[i] / i;
            int right = n == i ? 0 : (dp[n] - dp[i]) / (n - i);
            int diff = Math.abs(left - right);
            if(diff < minDiff){
                min = i - 1;
                minDiff = diff;
            }
        }
        return min;
    }
}
