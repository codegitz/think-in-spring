package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Codegitz
 * @date 2022/1/1 14:02
 **/
public class BurstBalloons {
    public static void main(String[] args) {
        int[] nums = new int[]{9,76,64};
        int i = maxCoins(nums);
        System.out.println(i);
    }
    public static int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        List<Integer> nList = new ArrayList<>();
        for(int num : nums){
            nList.add(num);
        }
        int sum = 0;
        while(nList.size() > 0){
            int i = findIndex(nList);
            int left = 1;
            if(i - 1 >= 0){
                left = nList.get(i - 1);
            }
            int right = 1;
            if(i + 1 < nList.size()){
                right = nList.get(i + 1);
            }
            sum += left * nList.get(i) * right;
            nList.remove(i);
        }
        return sum;
    }
    public static int findIndex(List<Integer> nList){
        if(nList == null){
            return 0;
        }
        if (nList.size() == 1){
            return 0;
        }
        if (nList.size() == 2){
            return nList.get(0) < nList.get(1) ? 0 : 1;
        }
        int index = 1;
        for(int i = 2 ; i < nList.size() - 1; i++){
            if(nList.get(i) < nList.get(index)){
                index = i;
            }
        }
        return index;
    }
}
