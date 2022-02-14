package io.codegitz.spring.common.mistakes.leetcode;

/**
 *
 * 258. Add Digits
 * Easy
 *
 * 1979
 *
 * 1550
 *
 * Add to List
 *
 * Share
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 * Example 2:
 *
 * Input: num = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= num <= 231 - 1
 *
 *
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 *
 * @author Codegitz
 * @date 2022/2/8 22:27
 **/
public class AddDigits {
    public static void main(String[] args) {
        int digits = addDigits(38);
        System.out.println(digits);
    }
    public static int addDigits(int num) {
        if(num < 10){
            return num;
        }
        int tmp = process(num);
        while(tmp > 10){
            tmp = process(tmp);
        }
        return tmp;
    }
    public static int process(int num){
        if(num < 10){
            return num;
        }
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
