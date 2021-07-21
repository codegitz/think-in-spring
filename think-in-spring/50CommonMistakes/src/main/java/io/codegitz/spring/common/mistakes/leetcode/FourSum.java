package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/7/21 14:33
 *
 * Given an array nums of n integers,
 * return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 **/
public class FourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
        List<List<Integer>> lists = fourSum(nums, 8);
        System.out.println(lists);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        if (length < 4){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        if (length == 4){
            List<Integer> integers = new ArrayList<>();
            int sum = 0;
            for (int i : nums){
                sum +=i;
                integers.add(i);
            }
            if (sum == target){
                result.add(integers);
            }
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0;i < length - 3 ; i++){
            if (i != 0 && nums[i] == nums[i -1]){
                continue;
            }
            boolean first = false;
            for (int j = i + 1 ; j < length - 2; j++){
                if (first && nums[j] == nums[j -1]){
                    continue;
                }
                first = true;
                int left = j + 1;
                int right = length - 1;
                int sum = 0;
                int tmp = nums[i] + nums[j];
                while (left < right){
                    sum =  tmp + nums[left] + nums[right];
                    if (sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                        right--;
                        while (left < right && nums[left] == list.get(2)){
                            left++;
                        }
                        while (left < right && nums[right] == list.get(3)){
                            right--;
                        }
                    }else if (sum < target){
                        left++;
                        while (left < right && nums[left] == nums[left - 1]){
                            left++;
                        }
                    }else {
                        right--;
                        while (left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int target_2 = target - (nums[i] + nums[j]);
                int start = j+1;
                int end = n-1;
                while(start < end) {
                    int two_sum = nums[start] + nums[end];
                    if(two_sum < target_2) {
                        start++;
                    } else if(two_sum > target_2) {
                        end--;
                    } else {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        res.add(temp);
                        //to get rid of duplicate elements//
                        while(start < end && nums[start] == temp.get(2)){
                            start++;
                        }

                        //to get rid of duplicate elements//
                        while(start < end && nums[end] == temp.get(3)){
                            end--;
                        }
                    }
                }
                //to get rid of duplicate elements//
                while((j+1) < n && nums[j+1] == nums[j]){
                    j++;
                }

                //to get rid of duplicate elements//
                while((i+1) < n && nums[i+1] == nums[i]){
                    i++;
                }
            }
        }
        return res;
    }
}
