package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/8/26 12:28
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 **/
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        dfs(nums,0,nums.length,result,new ArrayList<Integer>(),new HashSet<Integer>());

        return result;
    }

    private void dfs(int[] nums, int cur, int deep, List<List<Integer>> result, ArrayList<Integer> tmp, HashSet<Integer> cache) {
        if (cur == deep){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (cache.contains(i)){
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && cache.contains(i - 1)){
                continue;
            }
            tmp.add(nums[i]);
            cache.add(i);
            dfs(nums,cur + 1,deep,result,tmp,cache);
            cache.remove(i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
