package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/8/12 10:16
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 **/
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,result,target,new ArrayList<Integer>(),0);
        return result;
    }

    private void dfs(int[] candidates, List<List<Integer>> result, int target, ArrayList<Integer> tmp, int start) {
        if (target < 0 ){
            return;
        }
        if (target == 0){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i< candidates.length; i++){
            tmp.add(candidates[i]);
            dfs(candidates,result,target - candidates[i],tmp,i + 1);
            tmp.remove(tmp.size() - 1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
                i++;
            }
        }
    }
}
