package io.codegitz.spring.common.mistakes.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 张观权
 * @date 2021/9/16 10:09
 *
 * 76. Minimum Window Substring
 * Hard
 *
 * 8030
 *
 * 485
 *
 * Add to List
 *
 * Share
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 *
 **/
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = minWindow("bba", "ab");
        System.out.println(s);
    }

    public static String minWindow(String s, String t) {
        int[] tCount = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }

        int minStart = -1;
        int minEnd = -1;
        int[] sCount = new int[128];
        int count = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            int rightChar = s.charAt(right);
            sCount[rightChar]++;
            if (sCount[rightChar] <= tCount[rightChar]) {
                count++;
            }
            while (count == t.length()) {
                if (minStart == -1 || right - left + 1 < minEnd - minStart + 1) {
                    minStart = left;
                    minEnd = right;
                }

                int leftChar = s.charAt(left++);
                sCount[leftChar]--;
                if (sCount[leftChar] < tCount[leftChar]) {
                    count--;
                }
            }
        }

        return minStart == -1 ? "" : s.substring(minStart, minEnd + 1);
    }

}
