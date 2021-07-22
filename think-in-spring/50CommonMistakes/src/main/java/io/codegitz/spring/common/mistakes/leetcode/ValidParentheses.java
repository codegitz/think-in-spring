package io.codegitz.spring.common.mistakes.leetcode;

import java.util.Stack;

/**
 * @author 张观权
 * @date 2021/7/22 10:56
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 *
 **/
public class ValidParentheses {
    public static void main(String[] args) {
        boolean valid = isValid("{([])}}");
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (stack.isEmpty()){
                stack.push(c);
            }else {
                if ( c - stack.peek() == 2 || c - stack.peek()  == 1){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }
}
