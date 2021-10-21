package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/10/20 13:30
 *
 * 129. Sum Root to Leaf Numbers
 * Medium
 *
 * 2975
 *
 * 65
 *
 * Add to List
 *
 * Share
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 *
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 9
 * The depth of the tree will not exceed 10.
 *
 **/
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int[] res = new int[1];
        this.sum(root, 0, res);
        return res[0];
    }

    private void sum(TreeNode node, int pref, int[] res){
        if (node.left == null && node.right == null) {
            res[0] += pref*10 + node.val;
            return;
        }
        if (node.left != null) {
            this.sum(node.left, pref*10+node.val, res);
        }
        if (node.right != null) {
            this.sum(node.right, pref*10+node.val, res);
        }
    }

    // Definition for a binary tree node.
    static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}
