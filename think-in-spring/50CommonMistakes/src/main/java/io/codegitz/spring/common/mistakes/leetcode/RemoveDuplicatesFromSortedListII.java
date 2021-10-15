package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/9/17 14:04
 *
 * 82. Remove Duplicates from Sorted List II
 * Medium
 *
 * 3567
 *
 * 132
 *
 * Add to List
 *
 * Share
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 *
 **/
public class RemoveDuplicatesFromSortedListII {

    /**
     * Input: head = [1,2,3,3,4,4,5]
     * Output: [1,2,5]
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode flaky = new ListNode();
        flaky.next = head;
        ListNode pre = flaky;
        ListNode p = head;
        while (p.next != null){
            if(p.next.val == p.val){
                while (p.next != null && p.next.val == p.val){
                    p = p.next;
                }
                pre.next = p.next;
                p = p.next;
                if (p == null){
                    return flaky.next;
                }
                continue;
            }
            pre = p;
            p = p.next;
        }
        return flaky.next;
    }
    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
