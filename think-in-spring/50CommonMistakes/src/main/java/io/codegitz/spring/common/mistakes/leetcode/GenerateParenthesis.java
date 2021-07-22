package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/7/22 17:58
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 *
 **/
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> left = new ArrayList<>();
        List<String> right = new ArrayList<>();
        for (int i = 0 ; i < n ; i++){
            left.add("(");
            right.add(")");
        }
        List<String> result = new ArrayList<>();
        for (int i = 1 ; i <= n ; i++){
            int tmp = i;
            while (tmp > 0){
                getParenthesis(left,right,tmp,tmp - 1);
                tmp -= 1;
            }
        }
        return result;
    }

    private String getParenthesis(List<String> left, List<String> right, int leftNums, int rightNums) {

        return null;
    }
}
