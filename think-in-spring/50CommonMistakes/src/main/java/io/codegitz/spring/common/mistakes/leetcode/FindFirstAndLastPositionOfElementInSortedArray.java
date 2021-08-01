package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Program: think-in-spring
 * @Description:
 * @Author: <a href="http://codegitz.github.io">Codegitz</a>
 * @Create: 2021-08-01 17:33
 * @Since: 1.0
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 *
 **/
public class FindFirstAndLastPositionOfElementInSortedArray {
	public static void main(String[] args) {
		int[] nums = new int[]{5,7,7,8,8,10};
		int[] ints = searchRange(nums, 8);
		System.out.println(ints);
	}

	public static int[] searchRange1(int[] nums, int target) {
		if (nums == null || nums.length == 0){
			return new int[]{-1,-1};
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])){
				map.get(nums[i]).add(i);
				continue;
			}
			List<Integer> list = new ArrayList<>();
			list.add(i);
			map.put(nums[i],list);
		}
		if (map.containsKey(target)){
			List<Integer> integers = map.get(target);
			int[] result;
			if (integers.size() == 1){
				result = new int[2];
				result[0] = integers.get(0);
				result[1] = integers.get(0);
			}else {
				result = new int[integers.size()];
				for (int i = 0 ; i < integers.size() ; i++){
					result[i] = integers.get(i);
				}
			}
			return result;
		}else {
			return new int[]{-1,-1};
		}
	}

	public static int[] searchRange2(int[] nums, int target) {
		if (nums == null || nums.length == 0){
			return new int[]{-1,-1};
		}
		Map<Integer, int[]> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])){
				map.get(nums[i])[1] = i;
				continue;
			}
			int[] list = new int[2];
			list[0] = i;
			list[1] = i;
			map.put(nums[i],list);
		}
		if (map.containsKey(target)){
			return map.get(target);
		}else {
			return new int[]{-1,-1};
		}
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = findStartingIndex(nums,target);
		result[1] = findEndingIndex(nums,target);
		return result;
	}

	private static int findEndingIndex(int[] nums, int target) {
		int index = -1;
		int left = 0;
		int right = nums.length - 1;
		while (left <= right){
			int midPoint = left + (right - left) / 2;
			if (target >= nums[midPoint]){
				left = midPoint + 1;
			}else {
				right = midPoint - 1;
			}
			if (nums[midPoint] == target){
				index = midPoint;
			}
		}
		return index;
	}

	/**
	 * [5,7,7,8,8,8,8,8,8,8,10]
	 * @param nums
	 * @param target
	 * @return
	 */
	private static int findStartingIndex(int[] nums, int target) {
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
		return index;
	}

}
