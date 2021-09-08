package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/9/8 19:45
 *
 * 58. Length of Last Word
 * Easy
 *
 * 101
 *
 * 18
 *
 * Add to List
 *
 * Share
 * Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 *
 **/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null){
            return 0;
        }
        int sum = 0;
        char[] chars = s.toCharArray();
        boolean first = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!first && chars[i] == ' '){
                continue;
            }
            if (first && chars[i] == ' '){
                break;
            }
            first = true;
            sum++;

        }
        return sum;
    }
}
