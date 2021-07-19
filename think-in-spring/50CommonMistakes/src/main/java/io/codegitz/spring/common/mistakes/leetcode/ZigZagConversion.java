package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/7/16 10:33
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 *
 **/
public class ZigZagConversion {

    public static void main(String[] args) {
        String paypalishiring = convert("PAYPALISHIRING", 1);
        System.out.println(paypalishiring);
    }
    /**
     * Analysis of problem-solving ideas:
     *  - Firstly,calculate the distance between two parallel characters according to rowNums,
     *      from that we get distance = (rowNums - 2) * 2 - 1
     *
     *      explain what is two parallel characters :
     *          Explanation: I define P and I as two parallel characters,others like A and S , Y and H and so on.
     *            P     I    N
     *            A   L S  I G
     *            Y A   H R
     *            P     I
     *  - Then,based on row,traverse the s from zero(index = row,index is the subscript of the character).
     *    - when row = 0, we just need to find out the parallel character,so we get a substring = "PIN"
     *    - when row != 1, in addition to parallel character, we also need to find the character between them
     *      so we get a substring = "ALSIG".
     *          now the question is how to find out L. I use an variable count to record the index of the middle character,
     *          when row = 1 , count = distance.
     *          when row is incremented by one, count will be decremented by two.
     *              index = index + count + 1 is the subscript of the middle character.
     *              subsequently,the index = index + distance - count is the parallel character
     *    - After reaching the last line,the operation is likely to the first row, there is no middle character between them.
     *      we just only need simple assignment count = distance to solve the problem.
     * @param s
     * @param row
     * @return
     */
    public static String convert(String s, int row) {
        if (row > s.length() || row == 1){
            return s;
        }
        int distance = (row - 2) * 2 + 1;
        char[] chars = s.toCharArray();
        int index = 0;
        int count = distance;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < row; i++){
            index = i;
            while (index < chars.length){
                if (count == distance){
                    stringBuilder.append(chars[index]);
                    index = index + count + 1;
                }else {
                    stringBuilder.append(chars[index]);
                    index = index + count + 1;
                    if (index >= chars.length){
                        break;
                    }
                    stringBuilder.append(chars[index]);
                    index = index + distance - count;
                }

            }
            count -= 2;
            if (count < 1){
                count = distance;
            }
        }
        return stringBuilder.toString();
    }
}
