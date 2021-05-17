package com.vikko.demo.suanfa.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/13 16:54
 * @Description:
 */
public class Rob {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,6};
		System.out.println(rob(a));
	}

	public static int rob(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
		}
		return dp[nums.length -1];
	}

}
