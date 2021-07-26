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
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }
    public static List<String> solve(int open , int close ,String str, List<String> ans) {

        if(open == 0 && close == 0){
            ans.add(str);
        }

        if(open != 0){
            String s = str+"(";
            solve(open-1, close ,s , ans);
        }

        if(close > open){
            String s = str+")";
            solve(open,close-1,s,ans);
        }
        return ans;
    }


    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        return solve(n,n,"",ans);
    }
}
