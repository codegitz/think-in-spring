package io.codegitz.spring.common.mistakes.leetcode;

import java.util.Arrays;

/**
 * @author 张观权
 * @date 2021/10/13 13:00
 *
 * 115. Distinct Subsequences
 * Hard
 *
 * 2771
 *
 * 122
 *
 * Add to List
 *
 * Share
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * It is guaranteed the answer fits on a 32-bit signed integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * rabbbit
 * rabbbit
 * rabbbit
 * Example 2:
 *
 * Input: s = "babgbag", t = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from S.
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 1000
 * s and t consist of English letters.
 *
 **/
public class DistinctSubsequences {
    public static void main(String[] args) {
        int numDistinct = numDistinct("babgbag", "bag");
        System.out.println(numDistinct);
    }
    public static int numDistinct(String s, String t) {
        if (s == null || t == null){
            return 0;
        }
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(dp[0],1);
        // s[1,i] equals t[1,j]
        for (int j = 1 ; j <= t.length(); j++){
            for (int i = 1; i <= s.length();i++){
                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[j][i] = dp[j][i - 1] + dp[j - 1][i - 1];
                }else {
                    dp[j][i] = dp[j][i - 1];
                }
            }
        }
        return dp[t.length()][s.length()];

    }
}
