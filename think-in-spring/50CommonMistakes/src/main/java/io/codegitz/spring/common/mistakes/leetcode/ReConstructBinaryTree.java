package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author Codegitz
 * @date 2022/3/11 16:33
 **/
public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println(treeNode);
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length != in.length){
            return null;
        }
        return build(pre,0,pre.length - 1,in,0,in.length - 1);
    }

    private static TreeNode build(int[] pre, int pStart, int pEnd, int[] in, int inStart, int inEnd) {
        if (pStart > pEnd || inStart > inEnd){
            return null;
        }
        TreeNode current = new TreeNode(pre[pStart]);
        int data = pre[pStart];
        int offset = inStart;
        // search root node
        for (; offset < in.length; offset++){
            if (in[offset] == data){
                break;
            }
        }
        current.left = build(pre,pStart + 1,pStart + offset - inStart,in,inStart,offset - 1);
        current.right = build(pre,pStart + offset - inStart + 1,pEnd,in,offset + 1,inEnd);
        return current;
    }


    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
