package io.codegitz.spring.common.mistakes.leetcode;

import java.util.*;

/**
 * @author 张观权
 * @date 2021/10/9 14:40
 *
 * 103. Binary Tree Zigzag Level Order Traversal
 * Medium
 *
 * 4357
 *
 * 144
 *
 * Add to List
 *
 * Share
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 *
 **/
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        // [3,9,20,null,null,15,7]
//        Input: root = [3,9,20,null,null,15,7]
//        Output: [[3],[20,9],[15,7]]
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20);
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        List<List<Integer>> lists = zigzagLevelOrder(node3);
        System.out.println(lists);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> stack  = new ArrayDeque<TreeNode>();
        stack.push(root);
        zigzag(result,stack,true);
        return result;
    }

    private static void zigzag(List<List<Integer>> result, Deque<TreeNode> stack, Boolean left) {
        List<TreeNode> order = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        while (!stack.isEmpty()){
            //  弹出，值加入tmp，节点加入order
            TreeNode pop = stack.pop();
            order.add(pop);
            tmp.add(pop.val);
        }
        if (tmp.size() > 0){
            result.add(tmp);
        }
        if (order.size() > 0){
            if (left){
                for (TreeNode treeNode : order) {
                    if (treeNode.left != null){
                        stack.push(treeNode.left);
                    }
                    if (treeNode.right != null){
                        stack.push(treeNode.right);
                    }
                }
            }else {
                for (TreeNode treeNode : order) {
                    if (treeNode.right != null){
                        stack.push(treeNode.right);
                    }
                    if (treeNode.left != null){
                        stack.push(treeNode.left);
                    }
                }
            }
            zigzag(result,stack,!left);
        }

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
