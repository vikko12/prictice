package com.vikko.demo.algorithm.year2021.month4.huisu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: vikko
 * @Date: 2021/5/19 19:09
 * @Description:
 */
public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> res = new ArrayList<>();
		Deque<Integer> path = new ArrayDeque<>();
		dfs(candidates, 0, target, res, path, 0);
		return res;
	}

	private static void dfs(int[] candidates, int start, int target, List<List<Integer>> res, Deque<Integer> path, int sum){
		if(sum == target){
			res.add(new ArrayList<>(path));
			return;
		}else if(sum > target){
			return;
		}

		for(int i = start; i <= candidates.length-1; i++){
			sum += candidates[i];
			path.offerLast(candidates[i]);
			dfs(candidates, i  , target, res, path, sum);
			sum -= candidates[i];
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		int[] nums = {2,3,6,7};
		List<List<Integer>> lists = combinationSum(nums, 12);
		System.out.println(lists);
	}


}
