package io.codegitz.spring.common.mistakes.leetcode;

/**
 *
 * 2370. Longest Ideal Subsequence
 * Medium
 *
 * 337
 *
 * 11
 *
 * Add to List
 *
 * Share
 * You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following conditions are satisfied:
 *
 * t is a subsequence of the string s.
 * The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
 * Return the length of the longest ideal string.
 *
 * A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
 *
 * Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "acfgbd", k = 2
 * Output: 4
 * Explanation: The longest ideal string is "acbd". The length of this string is 4, so 4 is returned.
 * Note that "acfgbd" is not ideal because 'c' and 'f' have a difference of 3 in alphabet order.
 * Example 2:
 *
 * Input: s = "abcd", k = 3
 * Output: 4
 * Explanation: The longest ideal string is "abcd". The length of this string is 4, so 4 is returned.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * 0 <= k <= 25
 * s consists of lowercase English letters.
 *
 * @author Codegitz
 * @date 2022/8/10 15:14
 **/
public class LongestIdealSubsequence {
    public static void main(String[] args) {
        LongestIdealSubsequence longestIdealSubsequence = new LongestIdealSubsequence();
        int idealString = longestIdealSubsequence.longestIdealString("acfgbd", 1);
        System.out.println(idealString);
    }

    public int longestIdealString(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        char[] sc = s.toCharArray();
        for(int i = 1; i <= s.length() ; i++){
            for(int j = 1 ; j <= s.length() ; j++){
                if(Math.abs(sc[i - 1] - sc[j - 1]) <= k){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                }
            }
        }
        return dp[s.length()][s.length()];
    }
}
