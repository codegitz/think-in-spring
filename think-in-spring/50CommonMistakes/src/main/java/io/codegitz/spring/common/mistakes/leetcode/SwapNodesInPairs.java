package io.codegitz.spring.common.mistakes.leetcode;

/**
 *
 * 24. Swap Nodes in Pairs
 * Medium
 *
 * 6096
 *
 * 276
 *
 * Add to List
 *
 * Share
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 * @author Codegitz
 * @date 2022/2/16 21:05
 **/

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
//        ListNode node4 = new ListNode(4);
//        node3.next = node4;
        ListNode listNode = swapPairs(node1);
        System.out.println(listNode);
    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode result = cur;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre.next = next == null ? null : next.next == null ? next : next.next;
            pre = next;
            cur = next == null ? null : next.next;
        }
        return result;
    }


//    Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
