package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/9/17 9:23
 *
 * 78. Subsets
 * Medium
 *
 * 6999
 *
 * 123
 *
 * Add to List
 *
 * Share
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
 * All the numbers of nums are unique.
 *
 **/
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }
        for (int i = 0; i <= nums.length; i++) {
            getCombine(0,result,new ArrayList<>(),nums,i,new HashSet<Integer>());
        }
        return result;
    }

    private void getCombine(int index,List<List<Integer>> result, ArrayList<Integer> tmp, int[] nums, int k, HashSet<Integer> set) {
        if (tmp.size() == k){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])){
                continue;
            }
            tmp.add(nums[i]);
            set.add(nums[i]);
            getCombine(i + 1 ,result,tmp,nums,k,set);
            set.remove(nums[i]);
            tmp.remove(tmp.size() - 1);
        }
    }
}
