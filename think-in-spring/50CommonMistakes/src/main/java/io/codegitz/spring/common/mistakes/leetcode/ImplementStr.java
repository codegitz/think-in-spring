package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/7/27 14:28
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Example 3:
 *
 * Input: haystack = "", needle = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack and needle consist of only lower-case English characters.
 *
 **/
public class ImplementStr {
    public static void main(String[] args) {
        String s1 = "aaaaa";
        String s2 = "aaa";
        int i1 = s2.compareTo(s1);
        System.out.println(i1);
        int i = strStr("mississippi", "issip");
        System.out.println(i);
    }
    public static int strStr1(String haystack, String needle) {
        if ("".equals(needle)){
            return 0;
        }
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int index = 0;
        for (int j = 0 ; j < haystackChars.length; j++){
            int i = 0;
            boolean first = true;
            // find the first same character
            if (haystackChars[j] == needleChars[0]){
                index = j;
                int tmp = j;
                while (tmp < haystackChars.length && i < needleChars.length &&
                        haystackChars[tmp] == needleChars[i]){
//                    if (first && haystackChars[tmp] == haystackChars[j]){
//                        first = false;
//                        j = tmp - 1;
//                    }
                    tmp++;
                    i++;
                }
                if (i == needleChars.length){
                    return index;
                }
            }
        }
        return -1;
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()){
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        if (m < n){
            return -1;
        }
        for (int i = 0 ; i <= m -n ;++i){
            int j;
            for (j = 0 ; j < n ; ++j){
                if (haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
            }
            if (j == n){
                return i;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int check = needle.length();

        if(check == 0) {
            return 0;
        }

        if(haystack.equals(needle)) {
            return 0;
        }

        for(int i = 0; i < haystack.length() - check + 1; i++) {
            if(haystack.substring(i, i + check).equals(needle)) {
                return i;
            }
        }

        return - 1;
    }
    public int strStr3(String haystack, String needle) {

        if(needle.length() == 0) return 0;

        String s = needle+'|'+haystack;

        int lps[] = new int[s.length()];
        lps[0] = 0;
        int j = 0;

        for(int i=1; i<s.length(); i++){
            j=lps[i-1];

            while(j>0 && s.charAt(i)!=s.charAt(j))
                j = lps[j-1];

            if(s.charAt(i)==s.charAt(j))
                j++;

            lps[i] = j;

            if( lps[i]== needle.length()) //needle found
                return i-(2*needle.length());

        }

        return -1; //if needle not found

    }

    public int strStr5(String haystack, String needle) {
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();

        int n = s.length;
        int m = p.length;

        if(m==0) return 0;
        if(n==0) return -1;

        int[] suffix = preprocess(p);

        int[] dp = new int[n];
        if(s[0] == p[0]) dp[0] = 1;
        else dp[0] = 0;
        if(m==1 && dp[0] == 1) return 0;

        for(int i=1; i<n; i++){
            int j = dp[i-1];
            while( j>=1 && p[j] != s[i]){
                j = suffix[j-1];
            }
            if(p[j] == s[i]) dp[i] = j+1;
            else dp[i] = j;

            if(dp[i] == m) return i-m+1;
        }

        return -1;
    }

    int[] preprocess(char[] s){
        int n = s.length;
        int[] dp = new int[n];

        for(int i=1; i<n; i++){
            int j = dp[i-1];
            while(j >=1 && s[j]!=s[i]){
                j = dp[j-1];
            }
            if(s[j] == s[i]) dp[i] = j+1;
            else dp[i] = j;
        }
        return dp;
    }
}
