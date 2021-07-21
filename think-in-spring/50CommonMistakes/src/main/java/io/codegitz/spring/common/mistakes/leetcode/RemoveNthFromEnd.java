package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/7/21 19:28
 *
 * Given the head of a linked list,
 * remove the nth node from the end of the list and return its head.
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 **/
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode node1  = new ListNode();
        node1.val = 1;
        ListNode node2  = new ListNode();
        node1.next = node2;
        node2.val = 2;
        ListNode node3  = new ListNode();
        node2.next = null;
        node3.val = 3;
        ListNode node4  = new ListNode();
        node3.next = null;
        node4.val = 4;
        ListNode node5  = new ListNode();
        node4.next = node5;
        node5.val = 5;
        ListNode listNode = removeNthFromEnd(node1, 2);
        System.out.println(listNode);


    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        if (n == 1){
            first = first.next;
            if (first == null){
                return first;
            }
            while (first.next != null){
                first = first.next;
                second = second.next;
            }
            second.next = null;
            return head;
        }

        int i = 0;
        boolean flag = false;
        while (first.next != null){
            if (i < n){
                first = first.next;
                i++;
                continue;
            }
            flag = true;
            first = first.next;
            second = second.next;
        }
        if (flag){
            second.next = second.next.next;
            return head;
        }else if (i == n){
            second.next = first;
            return head;
        }else {
            return head.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next; }
    }

    /**
     * Excellent solution
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy=new ListNode();
        dummy.next=head;

        ListNode f=dummy;
        ListNode s=dummy;

        for(int i=0;i<n;i++){
            f=f.next;
        }

        while(f!=null && f.next!=null){
            f=f.next;
            s=s.next;
        }

        s.next=s.next.next;
        return dummy.next;


    }
}


