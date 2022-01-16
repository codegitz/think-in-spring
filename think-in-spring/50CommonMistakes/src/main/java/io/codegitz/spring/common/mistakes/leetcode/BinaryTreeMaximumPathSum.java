package io.codegitz.spring.common.mistakes.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 124. Binary Tree Maximum Path Sum
 * Hard
 *
 * 7397
 *
 * 454
 *
 * Add to List
 *
 * Share
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * Example 2:
 *
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 *
 * @Author
 * @Date
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        // [1,-2,-3,1,3,-2,null,-1]
        TreeNode node1 = new TreeNode(1);
        TreeNode noden2 = new TreeNode(-2);
        TreeNode noden3 = new TreeNode(-3);
        TreeNode node1c = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode noden2c = new TreeNode(-2);
        TreeNode noden1 = new TreeNode(-1);
        node1.left = noden2;
        node1.right = noden3;
        noden2.left = node1c;
        noden2.right = node3;
        noden3.left = noden2c;
        node1c.left = noden1;
        int i = maxPathSum(node1);
        System.out.println(i);
    }
    static int max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        helper(root);

        return max;

    }

    /**
     * Posiible case:
     *   (a)            (b)
     *          6               6 
     *         / \             / \  
     *        3   9          -1   9
     *       / \             /   / \
     *      1   2          -2   8   2    
     *
     *  a.  Path through the root (leftPath + root + rightPaht)
     *      The result is the path with maximum sum on the left that can reach to the root
     *      plus the value of root node
     *      plus the path with maximum sum on the right that can reach to the root
     *      that form a path go through the root
     *      2 -> 3 -> 6 -> 9
     *
     *  b.  Path to the root (max(leftPaht,rightPath) + root)
     *      The result is the path with maximum sum on the right that can reach to the root
     *      plus the value of the root
     *      that is 8 -> 9 -> 6
     *
     *
     *  To solve the problem, we need a helper function
     *      1. return maximum path from left or right that can reach the parent node
     *      2. also calculate leftPaht + root + rightPaht to check if Case (a) has a great value
     *
     */
    //DFS visited each node once so the time is O(N)
    //Recursive call stack space usage = the height of the tree, so it is O(M)

    private static int helper(TreeNode root){
        if(root == null) return 0;

        int leftMaxPathSum = helper(root.left);
        int rigthMaxPathSum = helper(root.right);
        int pathSumThroughTheRoot = leftMaxPathSum + root.val + rigthMaxPathSum;
        int maxPathSumToTheRoot = Math.max(root.val, root.val + Math.max(leftMaxPathSum, rigthMaxPathSum));

        max = Math.max(max, maxPathSumToTheRoot);
        max = Math.max(max, pathSumThroughTheRoot);

        return maxPathSumToTheRoot;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,Integer> wordMap = new HashMap<>();
        for (String word : wordList) {
            wordMap.put(word,0);
        }
        return 0;
    }

    /**
     * Definition for a binary tree node.
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
