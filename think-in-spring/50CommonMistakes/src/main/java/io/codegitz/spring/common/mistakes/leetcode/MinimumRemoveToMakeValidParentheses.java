package io.codegitz.spring.common.mistakes.leetcode;

import java.util.Stack;

/**
 *
 * 1249. Minimum Remove to Make Valid Parentheses
 * Medium
 *
 * 4042
 *
 * 71
 *
 * Add to List
 *
 * Share
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is either'(' , ')', or lowercase English letter.
 *
 * @author Codegitz
 * @date 2022/3/15 16:35
 **/
public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        String s = minRemoveToMakeValid("(((()))");
        System.out.println(s);
    }
    public static String minRemoveToMakeValid(String s) {
        int closeLeft = 0, unMatchedOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == ')') {
                closeLeft++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Already append enough (
                if (unMatchedOpen == closeLeft) {
                    continue;
                }
                unMatchedOpen++;
            } else if (c == ')') {
                closeLeft--;
                if (unMatchedOpen == 0) {
                    continue;
                }
                unMatchedOpen--;
            }
            sb.append(c);
        }
        return sb.toString();
    }
    public static String minRemoveToMakeValid2(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        Stack<Character> ch = new Stack<>();
        Stack<Integer> index = new Stack<>();
        char[] array = s.toCharArray();
        for(int i = 0 ; i < array.length ; i++){
            if (Character.isLetter(array[i])){
                continue;
            }
            if(ch.isEmpty()){
                ch.push(array[i]);
                index.push(i);
                continue;
            }
            if(array[i] == ')' && ch.peek() == '('){
                ch.pop();
                index.pop();
            }else if (array[i] == '(' || array[i] == ')'){
                ch.push(array[i]);
                index.push(i);
            }
        }
        if(ch.isEmpty()){
            return s;
        }
        while(!index.isEmpty()){
            array[index.pop()] = ' ';
        }
        return new String(array).replace(" ","");
    }
}
