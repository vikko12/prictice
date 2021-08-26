package com.vikko.demo.algorithm.year2021.month4.huisu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: vikko
 * @Date: 2021/8/26 16:32
 * @Description:
 */
public class Combine {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		Deque<Integer> path = new ArrayDeque<>();
		dfs(n, k, 1, path, res);
		return res;
	}

	private void dfs(int n, int k, int start, Deque<Integer> path, List<List<Integer>> res){
		if(path.size() == k){
			res.add(new ArrayList<>(path));
			return;
		}
		for(int i = start; i <= n; i++){
			path.add(i);
			dfs(n, k, i + 1, path, res);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		Combine solution = new Combine();
		int n = 5;
		int k = 3;
		List<List<Integer>> res = solution.combine(n, k);
		System.out.println(res);
	}

}
