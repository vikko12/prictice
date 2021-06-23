package com.vikko.demo.algorithm.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/19 10:24
 * @Description:
 */
public class NumTrees {

	public int numTrees(int n){
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n+1; i++) {
			for (int j = 1; j <=i ; j++) {
				dp[i] = dp[j-1] + dp[i-j];
			}
		}
		return dp[n];
	}

}
