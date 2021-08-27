package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/8/26 12:27
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 *
 **/
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }
        boolean[] used = new boolean[nums.length];
        dfs(nums,0,nums.length,result,new ArrayList<Integer>(),used);
        return result;
    }

    private void dfs(int[] nums, int deep, int targetDeep, List<List<Integer>> result, ArrayList<Integer> tmp, boolean[] used) {
        if (deep == targetDeep){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0 ; i < nums.length ; i++){
            if (used[i]){
                continue;
            }
            tmp.add(nums[i]);
            used[i] = true;
            dfs(nums,deep + 1,targetDeep,result,tmp,used);
            tmp.remove(tmp.size() - 1);
            used[i] = false;
        }
    }
}
