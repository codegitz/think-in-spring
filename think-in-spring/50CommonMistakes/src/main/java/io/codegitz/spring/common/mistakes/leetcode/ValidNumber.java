package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/9/14 11:21
 *
 * 65. Valid Number
 * Hard
 *
 * 252
 *
 * 496
 *
 * Add to List
 *
 * Share
 * A valid number can be split up into these components (in order):
 *
 * A decimal number or an integer.
 * (Optional) An 'e' or 'E', followed by an integer.
 * A decimal number can be split up into these components (in order):
 *
 * (Optional) A sign character (either '+' or '-').
 * One of the following formats:
 * One or more digits, followed by a dot '.'.
 * One or more digits, followed by a dot '.', followed by one or more digits.
 * A dot '.', followed by one or more digits.
 * An integer can be split up into these components (in order):
 *
 * (Optional) A sign character (either '+' or '-').
 * One or more digits.
 * For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
 *
 * Given a string s, return true if s is a valid number.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "0"
 * Output: true
 * Example 2:
 *
 * Input: s = "e"
 * Output: false
 * Example 3:
 *
 * Input: s = "."
 * Output: false
 * Example 4:
 *
 * Input: s = ".1"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.
 *
 **/
public class ValidNumber {
    public boolean isNumber(String s) {

        if (s.length() < 1)
            return false;

        boolean hasDigit = false, hasDot = false, hasE = false;
        int countSign = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // see if it is valid character or not
            if (isValidCharacter(ch) == false)
                return false;

            // check digit
            if (ch >= '0' && ch <= '9')
                hasDigit = true;

                // check sign
            else if (ch == '+' || ch == '-') {
                // sign can be at max two
                if (countSign == 2)
                    return false;

                // sign in between first and last character
                if (i > 0 && !(s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                    return false;
                }
                // sign can't be at last of String
                if (i == s.length() - 1)
                    return false;

                countSign++;
            }

            // check dot
            else if (ch == '.') {
                // if dot and E/e was already there, can have only one dot
                if (hasDot || hasE)
                    return false;

                // if dot is at last, and there was no digit before it
                if (i == s.length() - 1 && !hasDigit)
                    return false;

                hasDot = true;
            }

            // check e/E
            else if (ch == 'e' || ch == 'E' ) {
                // can't have more than 1 e/E, must have digit before e/E
                if (hasE || !hasDigit)
                    return false;

                // e/E can't be at last or at first
                if (i == s.length() - 1 || i == 0)
                    return false;

                hasE = true;
            }


        }
        return true;
    }

    private  boolean isValidCharacter(char ch) {
        return ch >= 48 && ch <= 57 || ch == 'e' || ch == 'E' || ch == '.' || ch == '+' || ch == '-';
    }
}
