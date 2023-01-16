package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * 946. Validate Stack Sequences
 * Medium
 *
 * 2957
 *
 * 53
 *
 * Add to List
 *
 * Share
 * Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4),
 * pop() -> 4,
 * push(5),
 * pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * Example 2:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 *
 *
 * Constraints:
 *
 * 1 <= pushed.length <= 1000
 * 0 <= pushed[i] <= 1000
 * All the elements of pushed are unique.
 * popped.length == pushed.length
 * popped is a permutation of pushed.
 *
 * @author Codegitz
 * @date 2022/3/16 17:37
 **/
public class ValidateStackSequences {
    public static void main(String[] args) {
        boolean validateStackSequences = validateStackSequences(new int[]{1,0}, new int[]{1,0});
        System.out.println(validateStackSequences);
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        // Create a stack
        Stack<Integer> st = new Stack<>();
        // initialize one pointer pointing on popped array
        int j = 0;

        for(int val : pushed){
            // insert the values in stack
            st.push(val);
            // if st.peek() values equal to popped[j];
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop(); // then pop out
                j++; // increment j
            }
        }
        // check if stack is empty return true else false
        return st.isEmpty();
    }
}
