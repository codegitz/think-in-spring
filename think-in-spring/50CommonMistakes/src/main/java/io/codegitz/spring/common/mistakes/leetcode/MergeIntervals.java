package io.codegitz.spring.common.mistakes.leetcode;

import java.util.*;

/**
 * @author 张观权
 * @date 2021/9/7 14:30
 *
 * 56. Merge Intervals
 * Medium
 *
 * 9116
 *
 * 424
 *
 * Add to List
 *
 * Share
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 **/
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] nums = {{2,6},{1,3},{8,10},{15,18}};
        int[][] merge = merge(nums);
        System.out.println(merge);
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals.length == 1){
            return intervals;
        }
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]){
                    int[] tmp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = tmp;
                }
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (list.size() == 0 || intervals[i][0] > list.get(list.size() - 1)[1]){
                list.add(intervals[i]);
            }else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1],intervals[i][1]);
            }
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
