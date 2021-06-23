package com.vikko.demo.algorithm.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/19 15:52
 * @Description:
 */
public class IsDuiChenTree {

	public boolean isSymmetric(TreeNode root) {
		return check(root, root);
	}

	public boolean check(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
	}

}
