package com.vikko.demo.algorithm.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/18 17:27
 * @Description:
 */
public class CountNode {

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int level = 0;
		TreeNode node = root;
		while (node.left != null) {
			level++;
			node = node.left;
		}
		int low = 1 << level, high = (1 << (level + 1)) - 1;
		while (low < high) {
			int mid = (high - low + 1) / 2 + low;
			if (exists(root, level, mid)) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	public boolean exists(TreeNode root, int level, int k) {
		int bits = 1 << (level - 1);
		TreeNode node = root;
		while (node != null && bits > 0) {
			if ((bits & k) == 0) {
				node = node.left;
			} else {
				node = node.right;
			}
			bits >>= 1;
		}
		return node != null;
	}

	private int countNodes2(TreeNode root){
		if(root == null){
			return 0;
		}
		return countNodes2(root.right) + countNodes2(root.left) + 1;

	}
}
