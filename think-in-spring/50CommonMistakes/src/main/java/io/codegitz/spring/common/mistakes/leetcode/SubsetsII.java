package io.codegitz.spring.common.mistakes.leetcode;

import java.util.*;

/**
 * @author 张观权
 * @date 2021/9/26 13:26
 *
 * 90. Subsets II
 * Medium
 *
 * 3518
 *
 * 124
 *
 * Add to List
 *
 * Share
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 **/
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, 0, res, new ArrayList<Integer>());
        return new ArrayList(res);
    }



    public void solve(int[] nums, int start, List<List<Integer>> res, List<Integer> temp) {
        if(start <= nums.length) {
            List<Integer> copy = new ArrayList<>(temp);
            res.add(copy);
        }

        for(int i = start; i < nums.length; ) {
            temp.add(nums[i]);
            solve(nums, i+1, res, temp);
            temp.remove(temp.size() - 1);
            i++;
            while(i < nums.length && nums[i] == nums[i-1]){
                i++;
            }
        }
    }
}
