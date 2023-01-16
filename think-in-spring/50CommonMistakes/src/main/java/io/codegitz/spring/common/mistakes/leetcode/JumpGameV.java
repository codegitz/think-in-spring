package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author Codegitz
 * @date 2023/1/10 10:40
 **/
public class JumpGameV {

    public static void main(String[] args) {
        JumpGameV jumpGameV = new JumpGameV();
        int[] arr = new int[]{6,4,14,6,8,13,9,7,10,6,12};
        int maxJumps = jumpGameV.maxJumps(arr, 2);
        System.out.println(maxJumps);
    }

    public int maxJumps(int[] arr, int d) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int[] dp = new int[arr.length];
        int max = 0;
        for(int i = 0 ; i < arr.length; i++){
            if(dp[i] == 0){
                fill(dp,i,arr,d);
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public void fill(int[] dp, int i, int[] arr, int d){
        dp[i] = selectMax(dp,i,arr,d) + 1;
    }
    public int selectMax(int[] dp, int i, int[] arr, int d){
        int max = 0;
        int left = i - 1;
        int times = d;
        while(left >= 0 && times > 0 && arr[left] < arr[i]){
            if(dp[left] == 0){
                fill(dp,left,arr,d);
            }
            max = Math.max(max,dp[left]);
            left--;
            times--;
        }
        int right = i + 1;
        times = d;
        while(right < arr.length && times > 0 && arr[right] < arr[i]){
            if(dp[right] == 0){
                fill(dp,right,arr,d);
            }
            max = Math.max(max,dp[right]);
            right++;
            times--;
        }
        return max;
    }
}
