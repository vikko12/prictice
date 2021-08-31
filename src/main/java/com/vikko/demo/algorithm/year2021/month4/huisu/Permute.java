package com.vikko.demo.algorithm.year2021.month4.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: vikko
 * @Date: 2021/8/30 15:33
 * @Description: 全排列
 */
public class Permute {

	public static void main(String[] args) {
		int[] a ={1,2,3};
		permute(a);
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int[] visited = new int[nums.length];
		LinkedList<Integer> items = new LinkedList<>();
		backTrace(res, visited, items, nums);

		return res;
	}

	public static void backTrace(List<List<Integer>> res, int[] visited, LinkedList<Integer> items, int[] nums){
		if(nums.length == items.size()){
			res.add(new ArrayList<>(items));
			return;
		}
		for(int i = 0; i < nums.length; i++){
			if(visited[i] == 1){
				continue;
			}
			items.add(nums[i]);
			visited[i] = 1;

			backTrace(res, visited, items, nums);

			visited[i] = 0;
			items.removeLast();

		}

	}

}
