package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/9/17 14:04
 *
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Medium
 *
 * 6468
 *
 * 157
 *
 * Add to List
 *
 * Share
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 *
 **/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

//        [3,9,20,15,7]
//        [9,3,15,20,7]

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,3};
        int[] inorder = new int[]{1,2,3};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
    public static TreeNode buildBT(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int data = preOrder[preStart];
        TreeNode current = new TreeNode(data);
        int offSet = inStart;
        for(;offSet < inEnd; offSet++){
            if(inOrder[offSet] == data){
                break;
            }
        }
        current.left = buildBT(preOrder, preStart+1, preStart+offSet-inStart, inOrder, inStart, offSet-1);
        current.right = buildBT(preOrder, preStart+offSet-inStart+1, preEnd, inOrder, offSet+1,inEnd);
        return current;
    }
    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if(preOrder.length == 0 || preOrder.length != inOrder.length){
            return null;
        }
        return buildBT(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
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
