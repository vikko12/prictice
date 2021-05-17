package com.vikko.demo.suanfa.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/15 16:26
 * @Description:
 */
public class KthSmallest {

	private int count;
	private int res;

	public int kthSmallest(TreeNode root, int k) {
		inOrder(root, k);
		return res;
	}

	private void inOrder(TreeNode root, int k){
		if(root == null){
			return;
		}
		inOrder(root.left, k);
		count ++;
		if(count == k){
			res = root.val;
			return;
		}
		inOrder(root.right, k);
	}

}
