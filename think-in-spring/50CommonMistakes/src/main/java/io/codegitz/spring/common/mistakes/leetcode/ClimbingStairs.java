package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/9/14 17:56
 *
 * 70. Climbing Stairs
 * Easy
 *
 * 8062
 *
 * 237
 *
 * Add to List
 *
 * Share
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 *
 **/
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int[] result = new int[n];
        result[n - 1] = 1;
        result[n - 2] = 2;
        for (int i = n - 3; i >= 0; i--) {
            result[i] = result[i + 1] + result[i + 2];
        }
        return result[0];
    }
}
