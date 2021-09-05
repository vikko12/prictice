package com.vikko.demo.algorithm.year2021.month8;

import com.vikko.demo.algorithm.year2021.month9.MinDepth;

/**
 * @author: vikko
 * @Date: 2021/8/30 17:08
 * @Description:
 * @see MinDepth
 */
public class MaxDepth {
	int res = 0;
	public int maxDepth(TreeNode root) {
		helper(root,0);
		return res;
	}

	private void helper(TreeNode root, int pre){
		if(root == null){
			return;
		}
		res = Math.max(res, pre + 1);
		helper(root.left, pre + 1);
		helper(root.right, pre + 1);
	}


}
