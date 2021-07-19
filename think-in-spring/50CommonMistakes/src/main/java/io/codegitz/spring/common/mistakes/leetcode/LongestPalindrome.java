package io.codegitz.spring.common.mistakes.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author 张观权
 * @date 2021/7/15 13:38
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 **/
public class LongestPalindrome {
    public static void main(String[] args) {
        String longestPalindrome = longestPalindrome("aaaaa");
        System.out.println(longestPalindrome);
//        String substring = "longestPalindrome".substring(0, 1);
//        System.out.println(substring);
    }
    public static String longestPalindrome1(String s) {
        if (s == null || "".equals(s) || s.length() == 1){
            return s;
        }
        Stack<Character> stack = new Stack<>();
        int max = 0;
        Character center;
        Character left;
        Map<String,String> container = new HashMap<>();
        StringBuilder sBuilder = new StringBuilder(s);
        for (int i = 0; i < sBuilder.length(); i++){
            char c = sBuilder.charAt(i);
            if (stack.isEmpty()){
                stack.push(c);
                continue;
            }
            center = stack.pop();
            if (stack.isEmpty()){
                left = center;
            }else {
                left = stack.peek();
            }

            if (c == left){
                sBuilder = new StringBuilder(c + sBuilder.toString() + left);
                continue;
            }
            int length = sBuilder.toString().length();
            if ( length > max){
                max = length;
                container.put("max",sBuilder.toString());
            }
            stack.push(c);
        }
        return container.get("max");
    }

    public static String longestPalindrome2(String s) {
        if (s == null || "".equals(s) || s.length() == 1){
            return s;
        }
        Stack<Character> stack = new Stack<>();
        String max = "";
        Character center;
        Character left;
        String sub = "";
        for (int i = 0; i < s.length(); i++) {
            Character right = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(right);
                continue;
            }
            center = stack.peek();
            if (center.equals(right)){
                sub = stack.pop() + sub + right;
            }else {
                //search the left sub
                center = stack.pop();
                if (stack.isEmpty()){
                    stack.push(center);
                    stack.push(right);
                }else {
                    left = stack.peek();
                    if (left.equals(right)){
                        sub = new StringBuilder().append(left)
                        .append(center)
                        .append(right).toString();
                    }
                    stack.push(center);
                    stack.push(right);
                }
            }
            if (s.contains(sub)){
                max = sub.length() > max.length() ? sub : max;
            }
        }
        return max.length() == 0 ? String.valueOf(stack.peek()) : max;
    }

    public static String longestPalindrome3(String s) {
        if (s == null || "".equals(s) || s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int index = 0;
        String sub = "";
        for (int i = 0; i < chars.length;i++){
            index = i;
            start = index - 1;
            end = index + 1;
            while (start >= 0 && end < chars.length && chars[start] == chars[end]){
                start--;
                end++;
            }
            if (start == -1){
                start = 0;
            }
            sub = sub.length() > end - start + 1 ? sub : s.substring(start,end);
        }
        return sub;
    }
    public static String longestPalindrome(String s) {
        int length = 0;
        int start = -1;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length();i++){
            length = Math.max(getLength(i,i,chars),getLength(i,i+1,chars));
            if (length > maxLength){
                maxLength = length;
                start = i - (length - 1) /2;
            }
        }
        return s.substring(start,start + maxLength);
    }

    private static int getLength(int i, int j, char[]  s) {
        if (j >= s.length){
            return 0;
        }
        int length = (i == j) ? -1 : 0;
        while (i >= 0 && j < s.length){
            if (s[i] != s[j]){
                break;
            }
            length += 2;
            i--;
            j++;
        }
        return length;
    }

}
