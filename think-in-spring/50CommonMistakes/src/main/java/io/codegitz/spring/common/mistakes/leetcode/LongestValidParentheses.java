package io.codegitz.spring.common.mistakes.leetcode;

import java.util.Stack;

/**
 * @author 张观权
 * @date 2021/7/31 16:08
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 *
 **/
public class LongestValidParentheses {
    public static void main(String[] args) {
        int i = longestValidParentheses("(())");
        System.out.println(i);
    }
    public static int longestValidParentheses(String s) {
        if (s == null || s.equals("")){
            return 0;
        }
        int length = s.length();
        if (length == 1){
            return 0;
        }
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < chars.length ; i++) {
            if (chars[i] == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    max = max > i - stack.peek() ? max : i - stack.peek();
                }
            }
        }
        return max;
    }
}
