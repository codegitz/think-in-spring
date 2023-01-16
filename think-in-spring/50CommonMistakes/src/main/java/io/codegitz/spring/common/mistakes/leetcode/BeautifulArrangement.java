package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 526. Beautiful Arrangement
 * Medium
 *
 * 2288
 *
 * 300
 *
 * Add to List
 *
 * Share
 * Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
 *
 * perm[i] is divisible by i.
 * i is divisible by perm[i].
 * Given an integer n, return the number of the beautiful arrangements that you can construct.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation:
 * The first beautiful arrangement is [1,2]:
 *     - perm[1] = 1 is divisible by i = 1
 *     - perm[2] = 2 is divisible by i = 2
 * The second beautiful arrangement is [2,1]:
 *     - perm[1] = 2 is divisible by i = 1
 *     - i = 2 is divisible by perm[2] = 1
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 15
 *
 * @author Codegitz
 * @date 2022/7/6 15:28
 **/
public class BeautifulArrangement {

    public static void main(String[] args) {
        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        int countArrangement = beautifulArrangement.countArrangement(3);
        System.out.println(countArrangement);
    }
    int count = 0;
    public int countArrangement(int n) {
        List<List<Integer>> permutation = getAllPermutation(n);
        return count;
    }

    public List<List<Integer>> getAllPermutation(int n){
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[n];
        dfs(nums,result,used,new ArrayList<>());
        return result;
    }

    public void dfs(List<Integer> nums,List<List<Integer>> result,boolean[] used,List<Integer> tmp){
        if(tmp.size() == nums.size()){
            result.add(new ArrayList<>(tmp));
            for(int j = 0; j < tmp.size(); j++){
                while(j < tmp.size() && (tmp.get(j) % (j + 1) == 0 || (j + 1) % tmp.get(j) == 0)){
                    j++;
                }
                if(j == tmp.size()){
                    count++;
                }else {
                    break;
                }
            }
            return;
        }
        for(int i = 0; i < nums.size(); i++){
            if (used[i]){
                continue;
            }
            tmp.add(nums.get(i));
            if(tmp.get(tmp.size() - 1) % tmp.size() != 0 && tmp.size() % tmp.get(tmp.size() - 1) != 0){
                tmp.remove(tmp.size() - 1);
                continue;
            }
            used[i] = true;
            dfs(nums,result,used,tmp);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
