package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/7/13 13:18
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        //[9]
        //[1,9,9,9,9,9,9,9,9,9]
        ListNode flag = new ListNode();
        ListNode result = flag;
        flag.val = 1;
        for (int i = 0 ; i < 9 ;i ++){
            ListNode node = new ListNode();
            node.val = 9;
            flag.next = node;
            flag = flag.next;
        }
        System.out.println(result);
        ListNode l1 = new ListNode();
        l1.val = 9;
        ListNode node = addTwoNumbers(l1, result);
        System.out.println(node);
        ListNode node2 = new ListNode();
        node2.val = 2;
        ListNode node4 = new ListNode();
        node4.val = 4;
        ListNode node3 = new ListNode();
        node3.val = 3;
        ListNode node5 = new ListNode();
        node5.val = 5;
        ListNode node6 = new ListNode();
        node6.val = 6;
        ListNode node42 = new ListNode();
        node42.val = 4;
        node2.next = node4;
        node4.next = node3;
        node5.next = node6;
        node6.next = node42;
        ListNode node1 = addTwoNumbers(node2, node5);
        System.out.println(node1);
    }
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        long i1 = 0;
        long i2 = 0;
        long sum = 0;
        int coefficient = 1;
        while (l1 != null){
            i1 = i1 + l1.val * coefficient;
            coefficient = coefficient * 10;
            l1 = l1.next;
        }
        coefficient = 1;
        while (l2 != null){
            i2 = i2 + l2.val * coefficient;
            coefficient = coefficient * 10;
            l2 = l2.next;
        }
        sum = i1 + i2;

        ListNode listNode = new ListNode();
        ListNode result = listNode;
        int remainder = (int) (sum % 10);
        sum = sum / 10;
        if (sum == 0){
            listNode.val = remainder;
            return listNode;
        }
        listNode.val = remainder;
        while (sum != 0){
            ListNode node = new ListNode();
            remainder = (int) (sum % 10);
            sum = sum / 10;
            node.val = remainder;
            listNode.next = node;
            listNode = listNode.next;
        }
        return result;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode flag = new ListNode();
        ListNode result  = flag;
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        int carry = 0;
        while ( l1 != null && l2 != null){
            int sum = l1.val + l2.val;
            if (carry != 0){
                sum = sum + carry;
            }
            if (sum / 10 > 0){
                carry = 1;
            }else {
                carry = 0;
            }
            ListNode node = new ListNode();
            node.val = sum % 10;
            flag.next = node;
            flag = flag.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (carry != 0 && l1 != null){
            int sum = l1.val + carry;
            if (sum / 10 > 0){
                carry = 1;
            }else {
                carry = 0;
            }
            ListNode node = new ListNode();
            node.val = sum % 10;
            flag.next = node;
            flag = flag.next;
            l1 = l1.next;
        }

        while (carry != 0 && l2 != null){
            int sum = l2.val + carry;
            if (sum / 10 > 0){
                carry = 1;
            }else {
                carry = 0;
            }
            ListNode node = new ListNode();
            node.val = sum % 10;
            flag.next = node;
            flag = flag.next;
            l2 = l2.next;
        }
        if (carry != 0){
            ListNode node = new ListNode();
            node.val = carry;
            flag.next = node;
        }
        if (l1 != null){
            flag.next = l1;
        }
        if (l2 != null){
            flag.next = l2;
        }
        return result.next;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}