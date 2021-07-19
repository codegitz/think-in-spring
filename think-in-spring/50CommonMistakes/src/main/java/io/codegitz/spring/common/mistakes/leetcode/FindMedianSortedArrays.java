package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/7/15 13:15
 **/
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int sum = l1 + l2;
        int[] merge = new int[sum];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l1 && j < l2){
            if (nums1[i] <= nums2[j]){
                merge[k] = nums1[i];
                i++;
            }else {
                merge[k] = nums2[j];
                j++;
            }
            k++;
        }
        if (i == l1){
            while (j < l2){
                merge[k] = nums2[j];
                k++;
                j++;
            }
        }

        if (j == l2){
            while (i < l1){
                merge[k] = nums1[i];
                k++;
                i++;
            }
        }
        if (sum % 2 == 0){
            return (merge[sum/2] + merge[sum/2 -1]) / 2.0;
        }else {
            return merge[sum/2];
        }
    }
}
