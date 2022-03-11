package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/9/10 14:33
 *
 * 61. Rotate List
 * Medium
 *
 * 3067
 *
 * 1191
 *
 * Add to List
 *
 * Share
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 *
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 *
 **/
public class RotateList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode listNode = rotateRight2(node1, 2);
        System.out.println(listNode);
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        int length = 0;
        ListNode tmp = head;
        ListNode end = null;
        while(tmp != null){
            length++;
            if(tmp.next == null){
                end = tmp;
            }
            tmp = tmp.next;
        }
        k = k % length;
        if (k == 0){
            return head;
        }
        int step = length - k - 1;
        tmp = head;
        while(step != 0){
            tmp = tmp.next;
            step--;
        }
        ListNode point = tmp.next;
        tmp.next = null;
        end.next = head;
        return point;
    }


    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }
        int length = 0;
        ListNode tmp = head;
        while (tmp != null){
            length++;
            tmp = tmp.next;
        }
        k = k % length;
        if (k == 0){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head;
        // find the rotate point
        while (k > 0){
            if (pre == null){
                pre = head;
            }
            pre = pre.next;
            k--;
        }
        if (k == 0 && pre == null){
            return head;
        }
        while (pre.next != null){
            pre = pre.next;
            cur = cur.next;
        }
        ListNode point = cur.next;
        cur.next = null;
        pre.next = head;
        head = point;
        return head;
    }

    public static ListNode rotate(ListNode head){
        if (head == null){
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        ListNode tmp;
        cur.next = null;
        while (next != null){
            tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }
        return cur;
    }

   static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
