package com.vikko.demo.algorithm.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/18 17:15
 * @Description:
 */
public class Rotate {

	public void rotate(int[] nums, int k) {
		int n = nums.length;
		int[] newArr = new int[n];
		for (int i = 0; i < n; ++i) {
			newArr[(i + k) % n] = nums[i];
		}
		System.arraycopy(newArr, 0, nums, 0, n);
	}


	public void rotate2(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start += 1;
			end -= 1;
		}
	}

}
