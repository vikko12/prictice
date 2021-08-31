package com.vikko.demo.algorithm.year2021.month8;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: vikko
 * @Date: 2021/8/30 17:15
 * @Description: leetcode114
 */
public class Flatten {

	TreeNode cur = new TreeNode();

	/**
	 * 需要全局变量，先序遍历
	 * @param root
	 */
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		cur.right = root;
		cur = root;
		root.left = null;
		flatten(left);
		flatten(right);
	}

	/**
	 * 复杂度高一点
	 */
	Deque<TreeNode> deque = new ArrayDeque<>();
	public void flatten2(TreeNode root){
		dfs(root);
		if(deque.isEmpty()){
			return;
		}
		deque.removeFirst();
		while (!deque.isEmpty()){
			TreeNode cur = deque.poll();
			root.left = null;
			root.right = cur;
			root = root.right;
		}
	}

	private void dfs(TreeNode root){
		if(root == null){
			return;
		}
		deque.offerLast(root);
		dfs(root.left);
		dfs(root.right);
	}

}
