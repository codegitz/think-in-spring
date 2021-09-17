package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/9/17 9:18
 *
 * 77. Combinations
 * Medium
 *
 * 2883
 *
 * 96
 *
 * Add to List
 *
 * Share
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 **/
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0){
            return result;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        getCombine(0,result,new ArrayList<Integer>(),nums,k,new HashSet<Integer>());
        return result;
    }

    private void getCombine(int index,List<List<Integer>> result, ArrayList<Integer> tmp, List<Integer> nums, int k, HashSet<Integer> set) {
        if (tmp.size() == k){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            if (set.contains(nums.get(i))){
                continue;
            }
            tmp.add(nums.get(i));
            set.add(nums.get(i));
            getCombine(i + 1 ,result,tmp,nums,k,set);
            set.remove(nums.get(i));
            tmp.remove(tmp.size() - 1);
        }
    }


    /**
     * excellent solution on leetcode online.
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> excellentCombine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(1, n, k, list, res);
        return res;
    }
    private void helper(int start, int n, int k, List<Integer> list, List<List<Integer>> res){
        if(list.size() == k){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = start; i <= n; i++){
            if(n - i + 1 >= k - list.size()){
                list.add(i);
                int size = list.size();
                helper(i+1, n, k, list, res);
                list.remove(size - 1);
            }
        }

    }
}
