package io.codegitz.spring.common.mistakes.leetcode;

import java.util.Arrays;

/**
 * @author 张观权
 * @date 2021/10/20 13:24
 *
 * 128. Longest Consecutive Sequence
 * Medium
 *
 * 7122
 *
 * 333
 *
 * Add to List
 *
 * Share
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 **/
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = 0;
        int longestLength = 1;
        Arrays.sort(nums);
        int tmp = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(tmp == nums[i]){
                continue;
            }
            if(tmp + 1 == nums[i]){
                longestLength++;
                tmp = nums[i];
                continue;
            }
            tmp = nums[i];
            result = Math.max(longestLength,result);
            longestLength = 1;
        }
        result = Math.max(longestLength,result);
        return result;
    }
}
