package com.vikko.demo.algorithm.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/15 17:45
 * @Description:
 */
public class SortedArray2BST {
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public TreeNode helper(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}

		// 总是选择中间位置左边的数字作为根节点
		int mid = left + (right - left) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);
		return root;
	}

}
