package com.vikko.demo.algorithm.year2021.month6;

/**
 * @author: vikko
 * @Date: 2021/6/28 20:20
 * @Description: leetcode 152
 */
public class MaxProduct {

	public int maxProduct(int[] nums) {
		//一个保存最大的，一个保存最小的。
		int max = Integer.MIN_VALUE, imax = 1, imin = 1;
		for (int i = 0; i < nums.length; i++) {
			//如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
			if (nums[i] < 0) {
				int tmp = imax;
				imax = imin;
				imin = tmp;
			}
			imax = Math.max(imax * nums[i], nums[i]);
			imin = Math.min(imin * nums[i], nums[i]);

			max = Math.max(max, imax);
		}
		return max;
	}

}
