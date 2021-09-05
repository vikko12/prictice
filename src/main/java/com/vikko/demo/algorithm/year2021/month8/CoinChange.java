package com.vikko.demo.algorithm.year2021.month8;

import java.util.Arrays;

/**
 * @author: vikko
 * @Date: 2021/8/13 15:25
 * @Description:
 * @see
 */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i < coin) {
					continue;
				}
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}

}
