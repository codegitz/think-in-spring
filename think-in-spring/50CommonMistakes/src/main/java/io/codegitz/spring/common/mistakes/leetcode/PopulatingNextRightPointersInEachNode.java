package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author 张观权
 * @date 2021/10/15 12:59
 *
 * 116. Populating Next Right Pointers in Each Node
 * Medium
 *
 * 4519
 *
 * 200
 *
 * Add to List
 *
 * Share
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 212 - 1].
 * -1000 <= Node.val <= 1000
 *
 *
 * Follow-up:
 *
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 *
 **/
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        connectNext(queue,1);
        return root;

    }

    private void connectNext(Queue<Node> queue,int count) {
        if (count == 0){
            return;
        }
        int nextCount = 0;
        while (count > 0){
            Node poll = queue.poll();
            if (count == 1){
                poll.next = null;
            }else {
                poll.next = queue.peek();
            }
            count--;
            if (poll.left != null){
                queue.add(poll.left);
                nextCount++;
            }
            if (poll.right != null){
                queue.add(poll.right);
                nextCount++;
            }
        }
        connectNext(queue,nextCount);
    }


    /*
 * Definition for a Node.
*/
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
