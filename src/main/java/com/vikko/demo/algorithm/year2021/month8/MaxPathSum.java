package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/8/10 11:58
 * @Description: leetcode124
 */
public class MaxPathSum {
	int sum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		dfs(root);
		return sum;
	}
	public int dfs(TreeNode root){
		if(root == null){
			return 0;
		}
		int left = Math.max(dfs(root.left), 0);
		int right = Math.max(dfs(root.right), 0);
		sum = Math.max(sum, left + right + root.val);
		return Math.max(left, right) + root.val;
	}

}
