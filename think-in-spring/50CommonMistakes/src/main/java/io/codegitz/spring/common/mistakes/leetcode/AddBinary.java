package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/9/14 11:27
 *
 * 67. Add Binary
 * Easy
 *
 * 3370
 *
 * 399
 *
 * Add to List
 *
 * Share
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 *
 **/
public class AddBinary {
    public static void main(String[] args) {
        String s = addBinary("0", "1011");
        System.out.println(s);
    }
    public static String addBinary(String a, String b) {
        if (a == null || b == null){
            return "";
        }
        if (a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (n >= 0 && m >= 0){
            int add = ac[m] - '0' + bc[n] - '0' + carry;
            carry = add / 2;
            sb.append(add % 2);
            m--;
            n--;
        }
        if (carry > 0){
            while (carry > 0 && m >= 0){
                int add = ac[m] - '0' + carry;
                carry = add / 2;
                sb.append(add % 2);
                m--;
            }
        }
        if (carry == 0 && m >= 0){
            while (m >= 0){
                sb.append(ac[m] - '0');
                m--;
            }
        }
        if (carry > 0 && m < 0){
            sb.append(carry);
        }

        String s = sb.toString();
        char[] chars = s.toCharArray();
        StringBuilder re = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            re.append(chars[i]);
        }
        return re.toString();
    }
}
