package io.codegitz.spring.common.mistakes.leetcode;

/**
 *
 * 415. Add Strings
 * Easy
 *
 * 3440
 *
 * 571
 *
 * Add to List
 *
 * Share
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 *
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * Example 3:
 *
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 104
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 *
 * @author Codegitz
 * @date 2022/7/7 10:06
 **/
public class AddStrings {
    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        String s = addStrings.addStrings("1", "99");
        System.out.println(s);
    }
    public String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null){
            return num1;
        }
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        while(i >= 0 && j >= 0){
            int sum = c1[i] - '0' + c2[j] - '0' + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        if(i < 0){
            while(carry != 0 && j >= 0){
                int sum = carry + c2[j] - '0';
                sb.append(sum % 10);
                carry = sum / 10;
                j--;
            }
            if(carry == 0){
                while(j >= 0){
                    sb.append(c2[j]);
                    j--;
                }
            }else if(j < 0){
                sb.append(carry);
            }
        }else if(j < 0){
            while(carry != 0 && i >= 0){
                int sum = carry + c1[i] - '0';
                sb.append(sum % 10);
                carry = sum / 10;
                i--;
            }
            if(carry == 0){
                while(i >= 0){
                    sb.append(c1[i]);
                    i--;
                }
            }else if(i < 0){
                sb.append(carry);
            }
        }
        return sb.reverse().toString();
    }
}
