package com.vikko.demo.algorithm.year2021.month8;


/**
 * @author: vikko
 * @Date: 2021/8/9 14:31
 * @Description:
 */
public class DiameterOfBinaryTree {

	int max = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return max;
	}

	public int depth(TreeNode node){
		if(node == null){
			return 0;
		}
		int left = depth(node.left);
		int right = depth(node.right);
		max = Math.max(max, left + right);
		return Math.max(left, right) + 1;
	}
}
