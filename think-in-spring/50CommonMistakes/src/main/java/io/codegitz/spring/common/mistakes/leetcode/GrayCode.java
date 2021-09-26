package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/9/26 13:17
 *
 * 89. Gray Code
 * Medium
 *
 * 1207
 *
 * 2100
 *
 * Add to List
 *
 * Share
 * An n-bit gray code sequence is a sequence of 2n integers where:
 *
 * Every integer is in the inclusive range [0, 2n - 1],
 * The first integer is 0,
 * An integer appears no more than once in the sequence,
 * The binary representation of every pair of adjacent integers differs by exactly one bit, and
 * The binary representation of the first and last integers differs by exactly one bit.
 * Given an integer n, return any valid n-bit gray code sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [0,1,3,2]
 * Explanation:
 * The binary representation of [0,1,3,2] is [00,01,11,10].
 * - 00 and 01 differ by one bit
 * - 01 and 11 differ by one bit
 * - 11 and 10 differ by one bit
 * - 10 and 00 differ by one bit
 * [0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
 * - 00 and 10 differ by one bit
 * - 10 and 11 differ by one bit
 * - 11 and 01 differ by one bit
 * - 01 and 00 differ by one bit
 * Example 2:
 *
 * Input: n = 1
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 16
 *
 **/
public class GrayCode {
    public static void main(String[] args) {
        System.out.println(1 << 1 ^ 1);
    }
    public List<Integer> grayCode(int n) {
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        boolean[] used = new boolean[1 << n];
        used[0] = true;
        backtrack(n, curr, used);
        return curr;
    }

    private boolean backtrack(int n, List<Integer> curr, boolean[] used) {
        if (curr.size() == 1 << n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            // (1 << i) is the mask in example, nex is next valid number
            int nex = (1 << i) ^ curr.get(curr.size() - 1);
            if (used[nex]){
                continue;
            }
            used[nex] = true;
            curr.add(nex);
            if (backtrack(n, curr, used)){
                return true;
            }
            used[nex] = false;
            curr.remove(curr.size() - 1);
        }
        return false;
    }
}
