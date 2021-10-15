package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/9/29 9:56
 *
 * 92. Reverse Linked List II
 * Medium
 *
 * 4721
 *
 * 236
 *
 * Add to List
 *
 * Share
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 *
 * Follow up: Could you do it in one pass?
 *
 **/
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node1.next = node2;
        reverseBetween(node1,1,2);
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode iter = head;
        int i = 1;
        ListNode prev = null;
        ListNode last = null;
        while(i < left){
            last = iter;
            iter = iter.next;
            i++;
        }
        ListNode end = iter;
        while(i <= right){
            ListNode next = iter.next;
            iter.next = prev;
            prev = iter;
            iter = next;
            i++;
        }

        if(last == null){
            head = prev;
        }else{
            last.next = prev;
        }
        end.next = iter;
        return head;
    }

     // Definition for singly-linked list.
   static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next;
     }
 }
}
