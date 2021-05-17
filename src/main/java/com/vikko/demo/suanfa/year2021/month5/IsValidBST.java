package com.vikko.demo.suanfa.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/14 14:58
 * @Description:
 */
public class IsValidBST {

	public Boolean valid(TreeNode root){
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public Boolean helper(TreeNode root, int start, int end){
		if(root == null){
			return true;
		}
		if(root.val >= end || root.val <= start){
			return false;
		}
		return helper(root.left, Integer.MIN_VALUE, root.val) &&
				helper(root.right,root.val,Integer.MAX_VALUE);
	}


}
