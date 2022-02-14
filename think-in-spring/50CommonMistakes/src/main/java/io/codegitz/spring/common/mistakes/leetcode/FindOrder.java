package io.codegitz.spring.common.mistakes.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Codegitz
 * @date 2021/12/23 20:50
 **/
public class FindOrder {
    public int[] findOrder(int nums, int[][] pre) {
        int[] result = new int[nums];
        if(pre == null || pre.length == 0){
            for(int i = 0 ; i < nums; i++){
                result[i] = i;
            }
            return result;
        }
        Map<Integer, Set<Integer>> need = new HashMap<>();
        for (int i = 0; i < pre.length; i++) {
            int[] p = pre[i];
            need.getOrDefault(p[1],new HashSet<>()).add(p[0]);
        }
        return result;
    }
}
