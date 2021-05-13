package com.vikko.demo.suanfa.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/13 17:39
 * @Description:
 */
public class IsValidBST {

	TreeNode pre = null;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean l = isValidBST(root.left);
		if (!l) {
			return false;
		}
		if (pre == null) {
			pre = root;
		} else {
			if (pre.val >= root.val) {
				return false;
			}
			pre = root;
		}
		return isValidBST(root.right);
	}

	public boolean isValidBST2(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	/**
	 * solution1
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */


	/**
	 * solution2
	 */
	public boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}

		if ((root.val >= max) || (root.val <= min)) {
			return false;
		}

		return isValidBST(root.left, min, root.val)
				&& isValidBST(root.right, root.val, max);
	}

	//	private boolean isValidBST(TreeNode root, int min, int max) {
//		return root == null || (root.val > min && root.val < max && isValidBST(root.left, min, root.val)
//				&& isValidBST(root.right, root.val, max));
//	}

}
