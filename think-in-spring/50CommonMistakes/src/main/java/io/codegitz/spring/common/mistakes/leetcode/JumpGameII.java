package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/8/25 16:53
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 *
 **/
public class JumpGameII {
    public static void main(String[] args) {
        jump(new int[]{2,3,1,1,4});
    }
    public static int jump2(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int max = 0;
        int sum = 0;
        int curMax = 0;
        for (int i = 0 ; i < nums.length - 1; i++){
            max = Math.max(max, nums[i] + i);
            if (curMax == i){
                sum++;
                curMax = max;
            }
        }
        return sum;
    }

    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int max = 0;
        int curMax = 0;
        int level = 0;
        int i = 0;
        while (curMax - i + 1 > 0){
            level++;
            for (;i <= curMax ;i++){
                max = Math.max(max,nums[i] + i);
                if (max > nums.length - 1){
                    return level;
                }
            }
            curMax = max;
        }
        return 0;
    }
}
