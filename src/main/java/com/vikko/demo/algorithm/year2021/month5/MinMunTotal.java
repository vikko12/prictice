package com.vikko.demo.algorithm.year2021.month5;

import java.util.List;

/**
 * @author: vikko
 * @Date: 2021/5/13 17:24
 * @Description:
 */
public class MinMunTotal {

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] dp = new int[n][n];
		dp[0][0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
			for (int j = 1; j < i; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
			}
			dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
		}
		int res = dp[n-1][0];
		for (int i = 1; i < n; i++) {
			res = Math.min(res, dp[n - 1][i]);
		}
		return res;
	}

}
