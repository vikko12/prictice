package com.vikko.demo.suanfa.year2021.month1;

/**
 * @author: vikko
 * @Date: 2021/1/11 15:49
 * @Description:
 */
public class MissingNum {

	public static void main(String[] args) {

	}

	public static int missingNum(int[] nums) {

		int numsSize = nums.length;
		// 对于有序数组, 大小为i的数应当处于下标为i的位置上, 如果不在, 说明在该数字之前发生了错位
		int left = 0, right = numsSize - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] != mid) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		// 如果从0 ~ n - 1都不缺值, 则缺少的是n
		return left == numsSize - 1 && nums[left] == left ? left + 1 : left;
	}
}
