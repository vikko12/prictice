package com.vikko.demo.algorithm.year2021.month8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

/**
 * @author: vikko
 * @Date: 2021/8/25 17:28
 * @Description:
 */
public class NextPermutation {

	public static void main(String[] args) {
		Integer[] nums = {0,1,2,3,4,5};
		Arrays.sort(nums, 0, 6, (o1, o2)->o2-o1);

		System.out.println(Arrays.toString(nums));
	}

	public void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[i] >= nums[j]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void reverse(int[] nums, int start) {
		int left = start, right = nums.length - 1;
		while (left < right) {
			swap(nums, left++, right--);
		}
	}

	public void NextPermutation2(int[] nums) {
		if (nums.length == 1) {
			return;
		}
		int j = nums.length - 1;
		// 从后往前找到后面的比前面大的，再往前面一位就是带交换位
		while (j >= 1 && nums[j] <= nums[j - 1]) {
			j--;
		}
		// 特殊情况，已经是最大排列
		if (j == 0) {
			Arrays.sort(nums);
			return;
		}
		int k = nums.length - 1;
		// 从后往前找到第一个比待交换位大的
		while (k > j - 1 && nums[k] <= nums[j - 1]) {
			k--;
		}

		int temp = nums[j - 1];
		nums[j - 1] = nums[k];
		nums[k] = temp;

		Arrays.sort(nums, j, nums.length);
	}

}
