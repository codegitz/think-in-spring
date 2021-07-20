package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Program: think-in-spring
 * @Description:
 * @Author: <a href="http://codegitz.github.io">Codegitz</a>
 * @Create: 2021-07-19 23:23
 * @Since: 1.0
 *
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 **/
public class ThreeSumClosest {
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,0};
		int i = threeSumClosest(nums, -100);
		System.out.println(i);
	}

	public int threeSumClosest1(int[] nums, int target) {
		int length = nums.length;
		if (length < 3){
			return 0;
		}
		Arrays.sort(nums);
		int i = 0;
		int left = i + 1;
		int rigtht = length - 2;
		int close = 0;
		for (i = 0 ; i < length - 2; i++){
			while (left < rigtht){
				int sum = nums[i] + nums[left] + nums[rigtht] - target;
				if (sum == 0){
					return 0;
				}else if (sum < 0){
					close = close > -sum ? -sum : close;
				}else {
					close = close > sum ? sum : close;

				}

			}
		}
		return close;
	}

	public static int threeSumClosest2(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		int ans = Integer.MAX_VALUE;
		if (n < 3) {
			return ans;
		}
		for (int i = 0; i < n - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int l = i + 1;
			int r = n - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r] - target;
				if (sum > 0) {
					ans = ans > sum + target ? sum + target : ans;
					r--;
				} else if (sum < 0) {
					ans = ans > Math.abs(sum + target) ? Math.abs(sum + target)  : ans;
					l++;
				} else {
//
//					l++;
//					r--;
//					while (l < r && nums[l] == nums[l - 1]) {
//						l++;
//					}
//					while (l < r && nums[r] == nums[r + 1]) {
//						r--;
//					}
					return target;
				}
			}
		}
		return ans ;
	}

	public static int threeSumClosest3(int[] nums, int target) {
		int length = nums.length;
		int sum = 0;
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		int result = nums[0] + nums[1] + nums[length - 1];
		for (int i = 0 ; i < length - 2 ; i++){
			int left = i + 1;
			int right = length - 1;
			while (left < right){
				sum = nums[i] + nums[left] + nums[right];
				if(Math.abs(sum-target) < diff){

					result = sum;
					diff = Math.abs(sum - target);
				}
				if (sum == target){
					return sum;
				}else if (sum < target){
					left++;
				}else if (sum > target){
					right--;
				}
				while (left < right && nums[left -1] == nums[left]){
					left++;
				}
				while (left < right && right + 1 < length && nums[right + 1] == nums[right]){
					right--;
				}
			}
		}
		return result;
	}
	public static int threeSumClosest(int[] nums, int target) {
		int n = nums.length;
		Arrays.sort(nums);
		int ans = 0;
		int diff = Integer.MAX_VALUE;
		for(int i=0;i<n-2;i++){
			int l = i+1;
			int r = n-1;
			while(l<r){
				int sum = nums[i] + nums[l] + nums[r];
				if(Math.abs(sum-target)<diff){
					ans = sum;
					diff = Math.abs(sum - target);
				}
				if(sum==target){
					return sum;
				}
				else if(sum > target){
					r--;
				}
				else {
					l++;
				}
			}
		}
		return ans;
	}

}
