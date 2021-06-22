package com.vikko.demo.algorithm.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/19 16:21
 * @Description:
 */
public class LowestCommonAncestor {

	public static void main(String[] args) {

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(q.val == root.val){
			return q;
		}
		if(p.val == root.val){
			return p;
		}
		if(p.val > root.val && q.val > root.val){
			return lowestCommonAncestor(root.right,p,q);
		}else if(p.val < root.val && q.val < root.val){
			return lowestCommonAncestor(root.left, q,p);
		}else {
			return root;
		}
	}

}
