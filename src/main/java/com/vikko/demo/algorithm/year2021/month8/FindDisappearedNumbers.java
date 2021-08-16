package com.vikko.demo.algorithm.year2021.month8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: vikko
 * @Date: 2021/8/12 15:52
 * @Description:
 */
public class FindDisappearedNumbers {

	public static void main(String[] args) {
		int[] a = {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(a));
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int num : nums) {
			if (nums[Math.abs(num) - 1] > 0) {
				nums[Math.abs(num) - 1] = -nums[Math.abs(num) - 1];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				res.add(i + 1);
			}

		}
		return res;
	}

}
