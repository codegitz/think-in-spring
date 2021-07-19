package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @Program: think-in-spring
 * @Description:
 * @Author: <a href="http://codegitz.github.io">Codegitz</a>
 * @Create: 2021-07-19 22:47
 * @Since: 1.0
 *
 * <p>Lowest Common Ancestor of a Binary Search Tree</p>
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the BST.
 *
 **/
public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// ensure the min one on left
		if (p.val > q.val){
			TreeNode tmp = p;
			p = q;
			q = tmp;
		}
		if (root.val == p.val){
			return p;
		}
		if (root.val == q.val){
			return q;
		}
		if (root.val > p.val && root.val < q.val){
			return root;
		}else if (root.val > p.val && root.val > q.val){
			return lowestCommonAncestor(root.left,p,q);
		}else{
			return lowestCommonAncestor(root.right,p,q);
		}

	}


	class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  	}
}
