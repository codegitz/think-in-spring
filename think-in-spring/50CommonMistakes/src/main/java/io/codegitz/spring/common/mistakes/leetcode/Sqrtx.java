package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/9/14 16:26
 *
 * 69. Sqrt(x)
 * Easy
 *
 * 2528
 *
 * 2632
 *
 * Add to List
 *
 * Share
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 *
 *
 * Constraints:
 *
 * 0 <= x <= 231 - 1
 *
 **/
public class Sqrtx {
    public static void main(String[] args) {
        int i = mySqrt(9);
        System.out.println(i);
    }
    public static int mySqrt(int x) {
        if( x==0 || x==1) {
            return x;
        }
        int start = 0;
        int end = x;
        int possibleSquareRoot=0;


        while(end >= start){
            int mid= start + (end-start)/2;
            if( mid> x/mid){
                end = mid-1;
            } else{
                possibleSquareRoot = mid;
                start = mid+1;
            }
        }

        return possibleSquareRoot;
    }

    class Solution {
        public String simplifyPath(String path) {
            String[] arrPath = path.split("/");
            StringBuilder sb = new StringBuilder("/");
            List<String> l = new ArrayList<>();
            for(int i = 0;i < arrPath.length;i++) {
                if("".equals(arrPath[i]) || ".".equals(arrPath[i])) {
                    continue;
                }

                if("..".equals(arrPath[i])) {
                    if(l.size() == 0) {
                        continue;
                    }
                    l.remove(l.size() - 1);
                    continue;
                }

                l.add(arrPath[i]);
            }

            l.forEach(str -> sb.append(str + "/"));
            if(sb.length() > 1) {
                return sb.substring(0, sb.length() - 1);
            }
            return sb.toString();
        }
    }
}
