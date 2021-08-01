package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @Program: think-in-spring
 * @Description:
 * @Author: <a href="http://codegitz.github.io">Codegitz</a>
 * @Create: 2021-08-01 16:55
 * @Since: 1.0
 *
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is guaranteed to be rotated at some pivot.
 * -104 <= target <= 104
 *
 **/
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int search = search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
		System.out.println(search);
	}
	public static int search(int[] nums, int target) {
		int length = nums.length;
		if (length == 1 && target == nums[0]){
			return 0;
		}

		if (length == 1 && target != nums[0]){
			return -1;
		}

		if (target < nums[0] && target > nums[length - 1]){
			return -1;
		}
		if (target >= nums[0]){
			return findFromLeft(nums,target,0);
		}else if (target <= nums[length - 1]){
			return findFromRight(nums,target,length - 1);
		}else {
			return -1;
		}

	}

	private static int findFromRight(int[] nums, int target, int position) {
		if (nums[position] == target){
			return position;
		}
		while (position >= 0){
			if (nums[position] == target){
				return position;
			}
			position--;
		}
		return -1;
	}

	private static int findFromLeft(int[] nums, int target, int position) {
		if (nums[position] == target){
			return position;
		}
		while (position < nums.length){
			if (nums[position] == target){
				return position;
			}
			position++;
		}
		return -1;
	}
}
