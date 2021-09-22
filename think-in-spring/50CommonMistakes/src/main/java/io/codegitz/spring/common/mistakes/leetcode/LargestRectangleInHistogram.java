package io.codegitz.spring.common.mistakes.leetcode;

import java.util.Comparator;

/**
 * @author 张观权
 * @date 2021/9/18 13:54
 *
 * 84. Largest Rectangle in Histogram
 * Hard
 *
 * 7147
 *
 * 116
 *
 * Add to List
 *
 * Share
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * Example 2:
 *
 *
 * Input: heights = [2,4]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 105
 * 0 <= heights[i] <= 104
 *
 **/
public class LargestRectangleInHistogram implements Comparator<LargestRectangleInHistogram> {
    private Integer sort;

    public static void main(String[] args) {
        int[] heights = new int[]{2,4};
        int i = largestRectangleArea(heights);
        System.out.println(i);
    }
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0 ){
            return -1;
        }
        if (heights.length == 1){
            return heights[0];
        }
        int max = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int minimumHeight = heights[i];
            for (int j = i; j < n; j++) {
                minimumHeight = Math.min(minimumHeight,heights[j]);
                max = Math.max(max,minimumHeight * (j - i + 1));
            }
        }
        return max;
    }

    @Override
    public int compare(LargestRectangleInHistogram o1, LargestRectangleInHistogram o2) {
        if (o1.sort != null && o2.sort != null){
            // normal comparison
            return Integer.compare(o1.sort,o2.sort);
        }
        // Special comparison
        if (o1 == null){
            return 1;
        }
        if (o2 == null){
            return -1;
        }
        return 0;
    }
}
