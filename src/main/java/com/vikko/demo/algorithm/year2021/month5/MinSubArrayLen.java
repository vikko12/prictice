package com.vikko.demo.algorithm.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/15 14:42
 * @Description:
 */
public class MinSubArrayLen {

	public static void main(String[] args) {
		int[] a = {4, 3};
		int i = minSubArrayLen(7, a);
		System.out.println(i);
	}

	public static int minSubArrayLen(int target, int[] nums) {
		int res = Integer.MAX_VALUE;
		int n = nums.length;
		for (int j = 0; j < n; j++) {
			int temTotal = 0;
			int len = 0;
			while (temTotal < target && j + len < n) {
				temTotal += nums[j + len];
				len++;
			}
			res = temTotal < target ? res : Math.min(res, len);
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}


	public static int minSubArrayLen2(int target, int[] nums) {
		int res = Integer.MAX_VALUE;
		int n = nums.length;
		int start = 0, end = 0, sum = 0;
		while (end < n) {
			sum += nums[end];
			while (sum >= target) {
				res = Math.min(res, end - start + 1);
				sum -= nums[start];
				start++;
			}
			end++;
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
