package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/9/2 18:08
 * @Description: 剪绳子
 */
public class CuttingRope {

	public int cuttingRope(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * (i - j));
			}
		}
		return dp[n];
	}

}
