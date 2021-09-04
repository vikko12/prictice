package com.vikko.demo.algorithm.year2021.month8;


/**
 * @author: vikko
 * @Date: 2021/9/1 11:52
 * @Description:
 */
public class MaxProfit {

	public int maxProfit(int[] prices) {
		int ans = 0;
		int n = prices.length;
		for (int i = 1; i < n; ++i) {
			ans += Math.max(0, prices[i] - prices[i - 1]);
		}
		return ans;
	}


	public int maxProfit2(int[] prices) {
		int n = prices.length;
		int dp0 = 0, dp1 = -prices[0];
		for (int i = 1; i < n; ++i) {
			int newDp0 = Math.max(dp0, dp1 + prices[i]);
			int newDp1 = Math.max(dp1, dp0 - prices[i]);
			dp0 = newDp0;
			dp1 = newDp1;
		}
		return dp0;
	}


}
