package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/9/18 13:37
 *
 * 83. Remove Duplicates from Sorted List
 * Easy
 *
 * 3251
 *
 * 158
 *
 * Add to List
 *
 * Share
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 *
 *
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 *
 **/
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode p = head;
        while (p.next != null){
            if (p.next.val == p.val){
                p.next = p.next.next;
                continue;
            }
            p = p.next;
            if (p == null){
                return head;
            }
        }
        return head;
    }

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
        int val;
        RemoveDuplicatesFromSortedListII.TreeNode left;
        RemoveDuplicatesFromSortedListII.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, RemoveDuplicatesFromSortedListII.TreeNode left, RemoveDuplicatesFromSortedListII.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
