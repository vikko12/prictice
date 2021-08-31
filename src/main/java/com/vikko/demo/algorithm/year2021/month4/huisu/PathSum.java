package com.vikko.demo.algorithm.year2021.month4.huisu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: vikko
 * @Date: 2021/8/26 17:34
 * @Description:
 */
public class PathSum {

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> res = new ArrayList<>();
		Deque<Integer> path = new ArrayDeque<>();
		dfs(root, targetSum, 0, res, path);
		return res;
	}

	private void dfs(TreeNode root, int target, int sum, List<List<Integer>> res, Deque<Integer> path){
		if(root == null){
			return;
		}
		sum += root.val;
		path.offerLast(root.val);
		if(sum == target && root.left == null && root.right == null){
			res.add(new ArrayList<>(path));
		}
		dfs(root.left, target, sum, res, path);
		dfs(root.right, target, sum, res, path);
		path.removeLast();
	}

}
