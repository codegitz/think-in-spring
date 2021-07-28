package io.codegitz.spring.common.mistakes.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张观权
 * @date 2021/7/27 11:08
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 *
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    public static int removeDuplicates1(int[] nums) {
        int finalLength = nums.length;
        for (int i = 0 ; i < finalLength ; i++){
            for (int j = i + 1 ; j < finalLength; j++){
                if (nums[i] == nums[j]){
                    // find all same numbers
                    int tmpLength = finalLength;
                    while (j < tmpLength && nums[i] == nums[j] ){
                        j++;
                        finalLength--;
                    }
                    int tmp = j;
                    int start = i + 1;
                    while (tmp < nums.length){
                        nums[start] = nums[tmp];
                        start++;
                        tmp++;
                    }
                    j = i + 1;
                }
            }
        }
        return finalLength;
    }

    public static int removeDuplicates(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            while(i<nums.length-1 && nums[i]==nums[i+1]){
                i++;
            }
            nums[j] = nums[i];
            j++;
        }
        return j;
    }

}
