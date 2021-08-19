package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/8/13 17:51
 **/
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null){
            return "0";
        }
        int[] pos = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1;i >= 0 ; i--){
            for (int j = num2.length() - 1 ; j >= 0 ; j--){
                int p1 = i + j;
                int p2 = i + j + 1;
                int p = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = p + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int po : pos) {
            if (!(po == 0 && result.length() == 0)){
                result.append(po);
            }
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}
