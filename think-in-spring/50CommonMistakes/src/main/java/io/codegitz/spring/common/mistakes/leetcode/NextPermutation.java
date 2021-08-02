package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/7/31 14:35
 *
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 **/
public class NextPermutation {

    private int tmp;
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return;
        }
        int pivot = n - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]){
            pivot--;
        }
        if (pivot < 0){
            reverse(nums,0,n - 1);
            return;
        }
        int lg = pivot + 1;
        while (lg < n && nums[lg] > nums[pivot]){
            lg++;
        }
        swap(nums,pivot,lg - 1);
        reverse(nums,pivot + 1 , n - 1);
    }

    private void swap(int[] nums, int left, int right) {
        tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right){
            swap(nums,left++,right--);
        }

    }
}
