package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/7/22 13:11
 *
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 *
 * Example 1:
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 *
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
 *
 **/
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode node1  = new ListNode();
        node1.val = 1;
        ListNode node2  = new ListNode();
        node1.next = node2;
        node2.val = 2;
        ListNode node3  = new ListNode();
        node2.next = node3;
        node3.val = 4;
        node3.next = null;

        ListNode node4  = new ListNode();
        node4.val = 1;
        ListNode node5  = new ListNode();
        node4.next = node5;
        node5.val = 3;
        ListNode node6  = new ListNode();
        node5.next = node6;
        node6.val = 4;
//        ListNode listNode = mergeTwoLists3(node1, node4);
//        System.out.println(listNode);
        ListNode[] listNodes = new ListNode[4];
        listNodes[0] = null;
        listNodes[1] = node1;
        listNodes[2] = null;
        listNodes[3] = node4;
        ListNode listNode = mergeKLists(listNodes);
        System.out.println(listNode);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l2.val < l1.val){
            ListNode listNode = l1;
            l1 = l2;
            l2 = listNode;
        }
        if (l1.next == null && l2.next == null){
            l1.next = l2;
            return l1;
        }

        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode pre = l1;
        // merge l2 to l1
        while (head1.next != null && head2.next != null){
            if (head1.val < head2.val && head1.next.val < head2.val){
                pre = head1;
                head1 = head1.next;
                continue;
            }
            ListNode tmp1 = head1.next;
            ListNode tmp2 = head2.next;
            head1.next = head2;
            head2.next = tmp1;
            pre = head1;
            head1 = head2;
            head2 = tmp2;
        }
        if (head1.next == null){
            head1.next = head2;
            return l1;
        }
        if (head2.next == null){
            while (head1 != null ){
                if (head2.val > head1.val){
                    pre = head1;
                    head1 = head1.next;
                    continue;
                }
                pre.next = head2;
                head2.next = head1;
                head1 = head1.next;
                break;
            }
            if (pre.next == null){
                pre.next = head2;
            }

        }
        return l1;
    }

    /**
     * excellent solution
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode prev = null;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        if (ptr1 == null) {
            return ptr2;
        }
        if (ptr2 == null) {
            return ptr1;
        }

        if (l2.val < l1.val) {
            ptr1 = l2;
            ptr2 = l1;
        }
        ListNode ret = ptr1;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val > ptr2.val) {
                ListNode tmp = ptr2.next;
                ptr2.next = ptr1;

                if (prev != null) {
                    prev.next = ptr2;
                    prev = prev.next;
                }
                ptr2 = tmp;
            } else {
                prev = ptr1;
                ptr1 = ptr1.next;
            }
        }

        if (ptr1 == null && ptr2 != null) {
            prev.next = ptr2;
        }
        return ret;
    }

    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                result.next = l1;
                l1 = l1.next;
                result = result.next;
            }else {
                result.next = l2;
                l2 = l2.next;
                result = result.next;
            }
        }
        if (l1 != null){
            result.next = l1;
        }
        if (l2 != null){
            result.next = l2;
        }
        return head.next;

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> filter = new ArrayList<>();
        for (ListNode list : lists) {
            if (list != null){
                filter.add(list);
            }
        }
        if (filter.size() == 0){
            return null;
        }
        ListNode[] listNodes = new ListNode[filter.size()];
        for (int i = 0 ; i < filter.size();i++){
            listNodes[i] = filter.get(i);
        }
        return mergeKSortedLists(listNodes,0,listNodes.length - 1);
    }

    private static ListNode mergeKSortedLists(ListNode[] lists, int left, int right) {
        if (left == right){
            return lists[left];
        }
        if (right - left == 1){
            return mergeTwoLists3(lists[left],lists[right]);
        }else {
            return mergeTwoLists3(mergeKSortedLists(lists,left,(left + right) / 2),mergeKSortedLists(lists,(left + right) / 2 + 1 ,right));
        }
    }


    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
