package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/7/22 13:11
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * Example 3:
 *
 * Input: head = [1,2,3,4,5], k = 1
 * Output: [1,2,3,4,5]
 * Example 4:
 *
 * Input: head = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range sz.
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 *
 **/
public class ReverseKGroup {
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
        node3.next = node4;
        node4.val = 4;
        ListNode node5  = new ListNode();
        node4.next = node5;
        node5.val = 5;
        ListNode node6  = new ListNode();
        node5.next = node6;
        node6.val = 6;
        ListNode[] listNodes = new ListNode[4];
        listNodes[0] = null;
        listNodes[1] = node1;
        listNodes[2] = null;
        listNodes[3] = node4;
        ListNode listNode = reverseKGroup(node1, 4);
        System.out.println(listNode);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode groupPrev = dummy;
        while (true){
            ListNode kthNode = getKthNode(groupPrev, k);
            if (kthNode == null){
                break;
            }
            ListNode groupNext = kthNode.next;
            ListNode pre = kthNode.next;
            ListNode curr = groupPrev.next;
            while (curr != groupNext){
                ListNode tmp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = tmp;
            }
            ListNode tmp = groupPrev.next;
            groupPrev.next = kthNode;
            groupPrev = tmp;
        }
        return dummy.next;
    }

        private static ListNode getKthNode(ListNode head, int k) {
        while (head != null && k > 0){
            head = head.next;
            k--;
        }
        return head;
    }


    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
