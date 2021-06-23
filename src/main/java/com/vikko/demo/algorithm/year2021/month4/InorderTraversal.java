package com.vikko.demo.algorithm.year2021.month4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: vikko
 * @Date: 2021/4/20 10:16
 * @Description:
 */
public class InorderTraversal {

	public static void main(String[] args) {

	}

	List<Integer> list=new ArrayList();
	public List<Integer> inorderTraversal(TreeNode root) {
		if(root!=null){
			inorderTraversal(root.left);
			list.add(root.val);
			inorderTraversal(root.right);
		}
		return list;
	}


	public static List<Integer> inorderTraversal2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new LinkedList<>();
		while (root != null || !stack.isEmpty()) {
			if (root!=null){
				stack.push(root);
				root = root.left;
			}else {
				root = stack.pop();
				list.add(root.val);
				root = root.right;
			}
		}
		return list;
	}


}
