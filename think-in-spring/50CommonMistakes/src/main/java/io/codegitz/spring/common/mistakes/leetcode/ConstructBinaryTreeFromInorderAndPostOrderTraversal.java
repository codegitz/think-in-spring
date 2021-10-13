package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/10/9 15:31
 **/
public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
    public static void main(String[] args) {
        // [9,3,15,20,7]
        //[9,15,7,20,3]
        int[] inorder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
        TreeNode treeNode = buildTree(inorder, postOrder);
        System.out.println(treeNode);
    }
    public static TreeNode buildTree(int[] inorder, int[] postOrder) {
        if (inorder == null || postOrder == null){
            return null;
        }
        int n = postOrder.length;
        TreeNode root = new TreeNode();
        build(root,inorder,0,n - 1,postOrder,0,n - 1);
        return root;
    }

    private static void build(TreeNode root, int[] inorder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if(postStart > postEnd || inStart > inEnd) {
            return;
        }
        int index = findPosition(inorder,inStart,inEnd,postOrder[postEnd]);
        if (index == -1){
            return;
        }
        root.val = postOrder[postEnd];
        if (index - 1 >= 0){
            TreeNode left = new TreeNode();
            root.left = left;
            build(left,inorder,inStart,index - 1,postOrder,postStart,postStart + index - inStart - 1);
        }
        if (postEnd != index && postEnd - index >= 0){
            TreeNode right = new TreeNode();
            root.right = right;
            build(right,inorder,index + 1,inEnd,postOrder,postStart + index - inStart,postEnd - 1);
        }
    }


    private static int findPosition(int[] inorder,int start,int end, int target) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == target){
                return i;
            }
        }
        return -1;
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
