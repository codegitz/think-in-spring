package io.codegitz.spring.common.mistakes.leetcode;

import java.util.Arrays;

/**
 * @author 张观权
 * @date 2021/9/15 12:36
 *
 * 72. Edit Distance
 * Hard
 *
 * 6580
 *
 * 78
 *
 * Add to List
 *
 * Share
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 *
 * Constraints:
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 *
 **/
public class EditDistance {
    public static void main(String[] args) {
        int i = minDistance("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopically");
        System.out.println(i);
    }
    public static int minDistance1(String word1, String word2) {
        if (word1 == null || word1.length() == 0){
            return word2.length();
        }
        if (word2 == null || word2.length() == 0){
            return word1.length();
        }
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        return getMin(dp,word1,word2,l1,l2);
    }

    private static int getMin(int[][] dp, String word1, String word2, int l1, int l2) {
        if (l1 == 0){
            return l2;
        }
        if (l2 == 0){
            return l1;
        }
        if (dp[l1][l2] != -1){
            return dp[l1][l2];
        }
        if (word1.charAt(l1 - 1) == word2.charAt(l2 - 1)){
            return dp[l1][l2] = getMin(dp,word1,word2,l1 - 1,l2 -1) ;
        }
        return dp[l1][l2] = Math.min(getMin(dp,word1,word2,l1,l2 -1),Math.min(getMin(dp,word1,word2,l1 - 1,l2 -1),getMin(dp,word1,word2,l1 - 1,l2 ))) + 1;
    }

    public static int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0){
            return word2.length();
        }
        if (word2 == null || word2.length() == 0){
            return word1.length();
        }
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int c = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j - 1] + c,Math.min(dp[i - 1][j],dp[i][j - 1]) + 1);
            }
        }

        return dp[l1][l2];
    }

}
