package io.codegitz.spring.common.mistakes.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张观权
 * @date 2021/7/13 12:56
 **/
public class TwoSum {
    public int[] twoSum1(int[] nums, int target) {
        int start = 0;
        int end = 1;
        if(nums.length < 1){
            return new int[1];
        }
        for(int i = start ; i < nums.length; i++){
            for(int j = end ; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
            end++;
            start++;
        }
        return new int[1];
    }

    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = 1;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[1];
    }
}
