package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @Program: think-in-spring
 * @Description:
 * @Author: <a href="http://codegitz.github.io">Codegitz</a>
 * @Create: 2021-08-01 22:28
 * @Since: 1.0
 *
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * Example 4:
 *
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 * Example 5:
 *
 * Input: nums = [1], target = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 *
 **/
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int index = -1;
		int left = 0;
		int right = nums.length - 1;
		while (left <= right){
			int midPoint = left + (right - left) / 2;
			if (target <= nums[midPoint]){
				right = midPoint - 1;
			}else {
				left = midPoint + 1;
			}
			if (nums[midPoint] == target){
				index = midPoint;
			}
		}
		if (index == -1){
			return left;
		}
		return index;
	}
}
