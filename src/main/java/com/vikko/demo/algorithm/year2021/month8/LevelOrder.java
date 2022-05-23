package com.vikko.demo.algorithm.year2021.month8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: vikko
 * @Date: 2021/8/25 14:26
 * @Description: 层序遍历 leetcode 102
 */
public class LevelOrder {

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.offerFirst(root);
		while (!deque.isEmpty()) {
			int count = deque.size();
			ArrayList<Integer> items = new ArrayList<>();
			while (count > 0) {
				TreeNode cur = deque.poll();
				if (cur.left != null) {
					deque.offerLast(cur.left);
				}
				if (cur.right != null) {
					deque.offerLast(cur.right);
				}
				items.add(cur.val);
				count--;
			}
			res.add(items);
		}
		return res;
	}
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		LinkedList<List<Integer>> res = new LinkedList<>();
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.offerFirst(root);
		while (!deque.isEmpty()) {
			int count = deque.size();
			ArrayList<Integer> items = new ArrayList<>();
			while (count > 0) {
				TreeNode cur = deque.poll();
				if (cur.left != null) {
					deque.offerLast(cur.left);
				}
				if (cur.right != null) {
					deque.offerLast(cur.right);
				}
				items.add(cur.val);
				count--;
			}
			res.addFirst(items);
		}
		return res;
	}

	

}
