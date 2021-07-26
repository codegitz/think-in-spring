package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/7/22 13:11
 *
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
 *
 **/
public class SwapPairs {
    public static void main(String[] args) {
        ListNode node1  = new ListNode();
        node1.val = 1;
        ListNode node2  = new ListNode();
        node1.next = node2;
        node2.val = 2;
        ListNode node3  = new ListNode();
        node2.next = node3;
        node3.val = 3;

        ListNode node4  = new ListNode();
        node3.next = null;
        node4.val = 4;
        ListNode node5  = new ListNode();
        node4.next = null;
        node5.val = 3;
        ListNode node6  = new ListNode();
        node5.next = node6;
        node6.val = 4;
        ListNode[] listNodes = new ListNode[4];
        listNodes[0] = null;
        listNodes[1] = node1;
        listNodes[2] = null;
        listNodes[3] = node4;
        ListNode listNode = swapPairs(node1);
        System.out.println(listNode);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode result = new ListNode();
        ListNode listNode = result;
        result.next = head;
        while (head.next != null){
            result.next = head.next;
            result = result.next;
            ListNode tp = result.next;
            head.next = null;
            result.next = head;
            result = result.next;
            head = tp;
            if (head == null){
                break;
            }
        }
        result.next = head;
        return listNode.next;
    }


    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
