package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/8/10 11:24
 * @Description:
 * @see DiameterOfBinaryTree
 */
public class TreeHeight {

	/**
	 * 通过递归的方式求出二叉树高度
	 */
	public static int getHeightByRecursion(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = getHeightByRecursion(node.left);
		int right = getHeightByRecursion(node.right);
		return Math.max(left, right) + 1;
	}

}
