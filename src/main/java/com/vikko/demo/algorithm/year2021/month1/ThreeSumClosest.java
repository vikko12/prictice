package com.vikko.demo.algorithm.year2021.month1;

import java.util.Arrays;

/**
 * @author: vikko
 * @Date: 2021/1/7 17:17
 * @Description:
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] num = {1,2,4,8,16,32,64,128};
		int closest = getClosest(num, 82);
		System.out.println(closest);
	}


	public static int getClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int sum = nums[1] + nums[2] + nums[0];
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int curSum = nums[i] + nums[left] + nums[right];
				if (Math.abs(target - curSum) < Math.abs(target - sum)) {
					sum = curSum;
				}
				if (target == curSum) {
					return target;
				} else if (target > curSum) {
					left++;
				} else {
					right--;
				}
			}
		}
		return sum;
	}
}
