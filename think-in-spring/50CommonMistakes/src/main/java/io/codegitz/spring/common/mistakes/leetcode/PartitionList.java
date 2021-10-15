package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/9/23 12:59
 *
 * 86. Partition List
 * Medium
 *
 * 2754
 *
 * 439
 *
 * Add to List
 *
 * Share
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *
 **/
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode head1 = new ListNode(0);
        ListNode dummy1 = head1;
        ListNode head2 = new ListNode(0);
        ListNode dummy2 = head2;
        while (head != null){
            if (head.val >= x){
                ListNode tmp = new ListNode(head.val);
                dummy2.next = tmp;
                dummy2 = dummy2.next;
            }else {
                ListNode tmp = new ListNode(head.val);
                dummy1.next = tmp;
                dummy1 = dummy1.next;
            }
            head = head.next;
        }
        dummy1.next = head2.next;
        return head1.next;
    }

       // Definition for singly-linked list.
       static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
