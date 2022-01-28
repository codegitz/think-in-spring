package io.codegitz.spring.common.mistakes.leetcode;

/**
 * 1345. Jump Game IV
 * Hard
 *
 * 1582
 *
 * 66
 *
 * Add to List
 *
 * Share
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 *
 * In one step you can jump from index i to index:
 *
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 * Return the minimum number of steps to reach the last index of the array.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 * Example 2:
 *
 * Input: arr = [7]
 * Output: 0
 * Explanation: Start index is the last index. You do not need to jump.
 * Example 3:
 *
 * Input: arr = [7,6,9,6,9,6,9,7]
 * Output: 1
 * Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 5 * 104
 * -108 <= arr[i] <= 108
 */
public class JumpGameIV {

    public static void main(String[] args) {
        int minJumps = minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404});
        System.out.println(minJumps);
    }

    public static int minJumps(int[] arr) {
        if(arr == null || arr.length < 1){
            return 0;
        }
        boolean[] used = new boolean[arr.length];
        used[0] = true;
        return dfs(arr,0,0,used);
    }
    public static int dfs(int[] arr,int index,int num,boolean[] used){
        if(index == arr.length - 1){
            return num;
        }
        used[index] = true;
        int forwards = Integer.MAX_VALUE;
        if(index + 1 < arr.length && !used[index + 1]){
            forwards = dfs(arr,index + 1,num + 1,used);
        }
        int withdraw = Integer.MAX_VALUE;
        if(index - 1 >= 0 && !used[index - 1]){
            withdraw = dfs(arr,index - 1,num + 1,used);
        }
        int same = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == arr[index] && i != index && !used[i]){
                same = Math.min(same,dfs(arr,i,num + 1,used));
            }
        }
        used[index] = false;
        return Math.min(Math.min(forwards,withdraw),same) + num;
    }
}
