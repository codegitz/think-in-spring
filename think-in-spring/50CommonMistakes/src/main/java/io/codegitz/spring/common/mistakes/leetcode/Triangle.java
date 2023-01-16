package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Codegitz
 * @date 2022/4/8 14:54
 **/
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        result.add(l1);
        result.add(l2);
        result.add(l3);
        result.add(l4);
        /**
         *    2
         *   3 4
         *  6 5 7
         * 4 1 8 3
         */
        l1.add(2);
        l2.add(3);
        l2.add(4);
        l3.add(6);
        l3.add(5);
        l3.add(7);
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        int i = minimumTotal(result);
        System.out.println(i);
    }

    public static int minimumTotal(List<List<Integer>> t) {
        if(t == null || t.size() == 0){
            return 0;
        }
        int m = t.size();
        int n = t.get(m - 1).size();
        int[][] dp = new int[m][n];
        // init
        for(int i = 0 ; i < m; i++){
            dp[m - 1][i] = t.get(m - 1).get(i);
        }

        for(int i = m - 2 ; i >= 0 ; i--){
            for(int j = 0 ; j < t.get(i).size() ; j++){
                dp[i][j] = Math.min(dp[i + 1][j + 1],dp[i + 1][j])
                        + t.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
