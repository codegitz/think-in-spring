package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/8/12 15:09
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 *
 **/
public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0){
            return 0;
        }
        int l = 0;
        int r = n - 1;
        int max_l = height[0];
        int max_r = height[n - 1];
        int sum = 0;
        while (l < r){
            if (max_l < max_r){
                sum += max_l - height[l];
                max_l = Math.max(max_l,height[++l]);
            }else {
                sum += max_r - height[r];
                max_r = Math.max(max_r,height[--r]);
            }
        }
        return sum;
    }
}
