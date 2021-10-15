package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/10/9 15:16
 **/
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    private int maxDeep(TreeNode root) {
        return 0;
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
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
