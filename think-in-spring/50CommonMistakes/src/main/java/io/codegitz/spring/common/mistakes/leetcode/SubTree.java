package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayDeque;

/**
 * @author Codegitz
 * @date 2022/3/18 14:56
 **/
public class SubTree {
    public static void main(String[] args) {
//        TreeNode root1 = new TreeNode(8);
//        root1.left = new TreeNode(8);
//        root1.left.left = new TreeNode(9);
//        root1.left.left.left = new TreeNode(2);
//        root1.left.left.left.left = new TreeNode(5);
//
////        root1.right = new TreeNode(3);
//        TreeNode root2 = new TreeNode(8);
//        root2.left = new TreeNode(9);
//        root2.left.left = new TreeNode(2);
//
//        boolean b = HasSubtree(root1, root2);
//        System.out.println(b);
        System.out.println(1 ^ 2);
    }


    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root1);
        while (!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            if(node.left != null){
                queue.addLast(node.left);
            }
            if(node.right != null){
                queue.addLast(node.right);
            }
            if(sub(node,root2)){
                return true;
            }
        }
        return false;
    }

    public static boolean sub(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return true;
        }
        if(root1.val != root2.val){
            return false;
        }
        if(root1.val == root2.val && root2.left == null && root2.right == null){
            return true;
        }
        return sub(root1.left,root2.left) && sub(root1.right,root2.right);
    }
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
