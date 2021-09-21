package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 张观权
 * @date 2021/9/9 15:50
 *
 * 60. Permutation Sequence
 * Hard
 *
 * 2756
 *
 * 376
 *
 * Add to List
 *
 * Share
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * Example 3:
 *
 * Input: n = 3, k = 1
 * Output: "123"
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 * 1 <= k <= n!
 *
 **/
public class PermutationSequence {
    public static void main(String[] args) {
        String permutation = getPermutation(3, 3);
        System.out.println(permutation);
    }

    public static String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 1 ; i <= n;i++){
            nums.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i++){
            fact[i] = fact[i - 1] * i;
        }
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0; i--){
            int num = nums.remove(k / fact[i]);
            sb.append(num);
            k %= fact[i];
        }
        return sb.toString();
    }
    public static String getPermutation2(int n, int k) {
        List<String> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(String.valueOf(i));
        }
        List<String> result = new ArrayList<>();
        boolean[] flag = new boolean[n];
        StringBuilder ans = new StringBuilder();
        AtomicBoolean found = new AtomicBoolean(false);
        dfs(result,new StringBuilder(),nums,flag,0,n,k,ans,found);
        if (k > result.size()){
            return "";
        }
        return result.get(k - 1);
    }

    private static void dfs(List<String> result, StringBuilder sb, List<String> nums, boolean[] flag, int pos, int n,int k,StringBuilder ans,AtomicBoolean found) {
        if (!ans.toString().equals("")){
            return;
        }
        if (result.size() == k){
            ans.append(result.get(k - 1));
            found.set(true);
            return;
        }
        if (pos == n){
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (found.get()){
                return;
            }
            if (flag[i]){
                continue;
            }
            sb.append(nums.get(i));
            flag[i] = true;
            dfs(result,sb,nums,flag,pos + 1,n,k,ans,found);
            sb.delete(sb.length() - 1,sb.length());
            flag[i] = false;
        }
    }
}
