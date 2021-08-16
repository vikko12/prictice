package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/8/12 15:41
 * @Description:
 */
public class ConvertBST {
	int num = 0;
	public TreeNode convertBST(TreeNode root){
		if(root == null){
			return null;
		}
		convertBST(root.right);
		num += root.val;
		root.val = num;
		convertBST(root.left);
		return root;
	}

}
