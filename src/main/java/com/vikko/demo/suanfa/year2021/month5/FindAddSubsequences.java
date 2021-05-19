package com.vikko.demo.suanfa.year2021.month5;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: vikko
 * @Date: 2021/5/19 14:52
 * @Description:
 */
public class FindAddSubsequences {

	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		List<List<Integer>> subsequences = findSubsequences(a);
		System.out.println(subsequences);
	}

	private static List<List<Integer>> res = new ArrayList<>();
	private static List<Integer> temp = new ArrayList<>();

	public static List<List<Integer>> findSubsequences(int[] nums) {
		backTrace(nums, 0);
		return res;
	}

	public static void backTrace(int[] nums, int index){
		if(index >= nums.length){
			return;
		}
		res.add(temp);
		for (int i = index; i < nums.length; i++) {
			temp.add(nums[i]);
			backTrace(nums, i+1);
			temp.remove(temp.size()-1);
		}
	}


}
