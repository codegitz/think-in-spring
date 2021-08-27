package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/8/24 13:17
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input: s = "adceb", p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 *
 * Input: s = "acdcb", p = "a*c?b"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length, p.length <= 2000
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '?' or '*'.
 *
 **/
public class WildcardMatching {

    public static void main(String[] args) {
        boolean match = isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*");
        System.out.println(match);
    }
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        s = "#" + s;
        p = "#" + p;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int k = 1 ; k < p.length();k++){
            if (p.charAt(k) != '*'){
                break;
            }
            dp[0][k] = true;
        }
        for (int i = 1; i <= m; i++ ){
            for (int j = 1; j <= n; j++){
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (p.charAt(j) == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static boolean isMatch2(String s, String p) {
        if (s == null || p == null){
            return false;
        }
        return helper(s.toCharArray(),p.toCharArray(),0,0);
    }

    private static boolean helper(char[] s, char[] pattern, int sPos, int pPos) {
        if (pPos == pattern.length && sPos == s.length){
            return true;
        }
        if (pattern.length == pPos){
            return false;
        }
        if (s.length == sPos){
            // the rest of pattern is *
            return isStar(pattern,pPos);
        }

        /**
         * ""
         * "**"
         */
        if (pattern[pPos] == '*'){
            return helper(s,pattern,sPos + 1, pPos) || helper(s,pattern,sPos, pPos + 1);
        }
        if (pattern[pPos] == '?'){
            return helper(s,pattern,sPos + 1 , pPos + 1);
        }
        if (s[sPos] == pattern[pPos]){
            return helper(s,pattern,sPos + 1 , pPos + 1);
        }else {
            return false;
        }
    }

    private static boolean isStar(char[] pattern, int pPos) {
        while (pPos < pattern.length){
            if (pattern[pPos] == '*'){
                pPos++;
            }else {
                return false;
            }
        }
        return true;
    }
}
