package io.codegitz.spring.common.mistakes.leetcode;

import java.util.*;

/**
 * @author 张观权
 * @date 2021/7/19 17:58
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * the idea of solving the problem is:
 *  - sort the given array first
 *  - then start traversing from zero
 *  - determine the left and right boundaries
 *  - if the sum is equal to zero, then add to the result set
 *  - at the same time, if the same number appears ,skip the same number to avoid the duplicate results.
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3){
            return new ArrayList<>();
        }
        int sum = 0;
        for (int i = 0 ; i + 1 < length;i++){
            sum = nums[i] + nums[i+1];
            for (int k = i + 1 ; k < length ; k++){
                for (int j = i + 2 ; j < length ; j++){
                    if (sum + nums[j] == 0){
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[i + 1]);
                        integers.add(nums[j]);
                        result.add(integers);
                    }

                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Map<List<Integer>, String> map = new HashMap();
        int sum = 0;
        for (int i = 0 ; i < length - 2 ; i++){
            int left = i + 1;
            int right = length - 1;
            while (left < right){
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> integers = new ArrayList(Arrays.asList(nums[i], nums[left], nums[right]));
                    if (!map.containsKey(integers)){
                        map.put(integers,"");
                        result.add(integers);
                    }
                    left++;
                    right--;
                }else if (sum < 0){
                    left++;
                }else if (sum > 0){
                    right--;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(n<3) {
            return ans;
        }
        for(int i = 0;i < n - 2; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = n-1;
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum>0) {
                    r--;
                } else if(sum<0){
                    l++;
                } else{
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    ans.add(temp);
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                    while(l<r && nums[r]==nums[r+1]){
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
