package com.vikko.demo.algorithm.year2021.month5;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: vikko
 * @Date: 2021/5/19 13:54
 * @Description:
 */
public class FindBottomLeftValue {


	public static void main(String[] args) {

	}

	/**
	 * bfs
	 */
	public int findBottomLeftValue(TreeNode root) {
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		while (!deque.isEmpty()) {
			root = deque.poll();
			if (root.right != null) {
				deque.offer(root.right);
			}
			if (root.left != null) {
				deque.offer(root.left);
			}
		}
		return root.val;
	}

}
