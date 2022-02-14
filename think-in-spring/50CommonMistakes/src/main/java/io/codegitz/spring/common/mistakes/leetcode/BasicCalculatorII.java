package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Codegitz
 * @date 2021/12/25 10:44
 *
 * 227. Basic Calculator II
 * Medium
 *
 * 3285
 *
 * 472
 *
 * Add to List
 *
 * Share
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: s = " 3+5 / 2 "
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 **/
public class BasicCalculatorII {

    public static void main(String[] args) {
        int calculate = calculate("1*2-3/4+5*6-7*8+9/10");
        System.out.println(calculate);
    }
    public static int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] ch = s.toCharArray();
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' '){
                continue;
            }
            if (ch[i] == '+' || ch[i] == '-'){
                stack.addLast(String.valueOf(ch[i]));
                continue;
            }
            if (ch[i] != '*' && ch[i] != '/'){
                StringBuilder sb = new StringBuilder();
                sb.append(ch[i]);
                if (Character.isDigit(ch[i])){
                    while (i + 1 < ch.length && Character.isDigit(ch[i + 1])){
                        sb.append(ch[i + 1]);
                        i++;
                    }
                }
                stack.addLast(sb.toString());
                continue;
            }
            if (ch[i] == '*'){
                int popNum = Integer.parseInt(stack.pollLast());
                while (ch[i + 1] == ' '){
                    i++;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(ch[i + 1]);
                if (i + 2 < ch.length && Character.isDigit(ch[i + 2])){
                    while (i + 2 < ch.length && Character.isDigit(ch[i + 2])){
                        sb.append(ch[i + 2]);
                        i++;
                    }
                }
                int nextNum = Integer.parseInt(sb.toString());
                stack.addLast(String.valueOf(popNum * nextNum));
                i++;
            }else if (ch[i] == '/'){
                int popNum = Integer.parseInt(stack.pollLast());
                while (ch[i + 1] == ' '){
                    i++;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(ch[i + 1]);
                if (i + 2 < ch.length && Character.isDigit(ch[i + 2])){
                    while (i + 2 < ch.length && Character.isDigit(ch[i + 2])){
                        sb.append(ch[i + 2]);
                        i++;
                    }
                }
                int nextNum = Integer.parseInt(sb.toString());
                stack.addLast(String.valueOf(popNum / nextNum));
                i++;
            }
        }
        int result = Integer.parseInt(stack.pollFirst());
        while (!stack.isEmpty()){
            String pop = stack.pollFirst();
            if ("+".equals(pop)){
                result += Integer.parseInt(stack.pollFirst());
            }else if ("-".equals(pop)){
                result -= Integer.parseInt(stack.pollFirst());
            }
        }
        return result;
    }
}
