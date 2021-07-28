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
        int i = strStr("mississippi", "issip");
        System.out.println(i);
    }
    public static int strStr(String haystack, String needle) {
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
}
