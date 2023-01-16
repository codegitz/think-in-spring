package io.codegitz.spring.common.mistakes.leetcode;

/**
 *
 * 583. Delete Operation for Two Strings
 * Medium
 *
 * 4179
 *
 * 62
 *
 * Add to List
 *
 * Share
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
 *
 * In one step, you can delete exactly one character in either string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Example 2:
 *
 * Input: word1 = "leetcode", word2 = "etco"
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 500
 * word1 and word2 consist of only lowercase English letters.
 *
 * @author Codegitz
 * @date 2022/7/6 17:14
 **/
public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        DeleteOperationForTwoStrings deleteOperationForTwoStrings = new DeleteOperationForTwoStrings();
        int minDistance = deleteOperationForTwoStrings.minDistance("eat", "sea");
        System.out.println(minDistance);
    }
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null){
            return 0;
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int max = 0;
        for(int i = 1 ; i <= c1.length; i++){
            for(int j = 1; j <= c2.length; j++){
                if(c1[i - 1] == c2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return (word1.length() + word2.length()) - 2 * max;
    }

}
