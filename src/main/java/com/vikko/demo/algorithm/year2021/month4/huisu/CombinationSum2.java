package com.vikko.demo.algorithm.year2021.month4.huisu;

import com.google.common.collect.Lists;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: vikko
 * @Date: 2021/8/31 13:46
 * @Description:
 */
public class CombinationSum2 {


	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Deque<Integer> items = new ArrayDeque<>();
		Arrays.sort(candidates);
		dfs(res, items, 0, candidates, target, 0);
		return res.stream().distinct().collect(Collectors.toList());
	}

	private static void dfs(List<List<Integer>> res, Deque<Integer> items, int index,
			int[] candidates, int target, int sum) {
		if (target == sum) {
			res.add(new ArrayList<>(items));
		}

		for (int i = index; i < candidates.length; i++) {
//			while (!items.isEmpty() && i <= candidates.length -1 && items.peekLast() == candidates[i]){
//				i++;
//			}
//			if(i >= candidates.length){
//				break;
//			}
			sum += candidates[i];
			items.offerLast(candidates[i]);

//			System.out.println("递归之前 => " + items);
			dfs(res, items, i + 1, candidates, target, sum);

			sum -= candidates[i];
			items.removeLast();
//			System.out.println("===递归之后 => " + items);
		}
	}


	List<List<Integer>> list = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> combinationSum2Copy(int[] candidates, int target) {
		Arrays.sort(candidates);
		dfs(candidates, target, 0);
		return list;
	}

	private void dfs(int[] candidates, int target, int index) {
		if (target == 0) {
			list.add(new ArrayList<>(path));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				if (i > index && candidates[i] == candidates[i - 1]) {
					continue;
				}
				path.add(candidates[i]);
				dfs(candidates, target - candidates[i], i + 1);
				path.remove(path.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {2, 5, 2, 1, 2};
		System.out.println(combinationSum2(a, 5));
	}

}
