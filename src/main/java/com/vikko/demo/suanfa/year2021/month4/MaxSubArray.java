package com.vikko.demo.suanfa.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/16 15:11
 * @Description:
 */
public class MaxSubArray {

	public static void main(String[] args) {

	}

	public static int maxSubArray(int[] nums){
		int res = nums[0], pre = 0;
		for (int num : nums) {
			pre = Math.max(pre + num, num);
			res = Math.max(res, pre);
		}
		return res;
	}

}
