package com.vikko.demo.algorithm.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/18 16:10
 * @Description:
 */
public class SumNumbers {

	private int sum = 0;
	public int sumNumbers(TreeNode root) {
		helper(root, 0);
		return sum;
	}

	private void helper(TreeNode root, int before){
		if(root.left == null && root.right == null){
			sum += before * 10 + root.val;
		}
		if(root.left != null){
			helper(root.left, before * 10 + root.val);
		}
		if(root.right != null){
			helper(root.right, before * 10 + root.val);
		}
	}

	public void helper2(TreeNode root, int res) {
		if (root == null) {
			return;
		}
		res = (res * 10) + root.val;
		if (root.left == null && root.right == null) {
			sum += res;
		}
		helper(root.left, res);
		helper(root.right, res);
	}

}
