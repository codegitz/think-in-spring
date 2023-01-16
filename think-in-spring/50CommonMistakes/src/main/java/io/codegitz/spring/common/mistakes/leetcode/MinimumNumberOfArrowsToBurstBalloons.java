package io.codegitz.spring.common.mistakes.leetcode;

import java.util.Arrays;

/**
 * @author Codegitz
 * @date 2023/1/5 11:12
 **/
public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons minimumNumberOfArrowsToBurstBalloons = new MinimumNumberOfArrowsToBurstBalloons();
//        int[][] ints = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        int[][] ints = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        int minArrowShots = minimumNumberOfArrowsToBurstBalloons.findMinArrowShots(ints);
        System.out.println(minArrowShots);
    }

    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        Arrays.sort(points,(a, b) -> a[0] == b[0] ? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0]));
        int sum = 0;
        for(int i = 0; i < points.length ; i++){
            int start = points[i][1];
            while(i + 1 < points.length && points[i + 1][0] <= start){
                i++;
            }
            sum++;
        }
        return sum;

    }
}
