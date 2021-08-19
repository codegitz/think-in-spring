package io.codegitz.spring.common.mistakes.leetcode;

import java.util.Arrays;

/**
 * @author 张观权
 * @date 2021/8/12 11:28
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 *
 **/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 1;
        }
        Arrays.sort(nums);
        int result = nums[0];
        if (result > 1){
            return 1;
        }
        int j = 1;
        while (j < nums.length && result <= 0){
            result = nums[j];
            j++;
        }
        j--;
        if (result > 1){
            return 1;
        }
        int tmp = 1;
        for (int i = j ; i < nums.length; i++){
            while (i + 1 < nums.length && nums[i] == nums[i + 1]){
                i++;
            }
            if (tmp == nums[i]){
                tmp++;
                continue;
            }
            return tmp;
        }
        return tmp + 1;
    }
}
