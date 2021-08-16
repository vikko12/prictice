package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/8/13 14:11
 * @Description:
 */
public class IsSameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null){
			return true;
		}

		if(p == null && q != null){
			return false;
		}
		if(p != null && q == null){
			return false;
		}

		return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
	}

}
