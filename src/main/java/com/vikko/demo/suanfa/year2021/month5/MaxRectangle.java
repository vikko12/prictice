package com.vikko.demo.suanfa.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/13 16:16
 * @Description:
 */
public class MaxRectangle {

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;

		int m = matrix.length, n = matrix[0].length, area = 0, min;
		int[][][] dp = new int[m + 1][n + 1][2];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					if (j != 1 && matrix[i - 1][j - 2] == '1')
						dp[i][j][0] = dp[i][j - 1][0] + 1;
					else
						dp[i][j][0] = 1;

					if (i != 1 && matrix[i - 2][j - 1] == '1')
						dp[i][j][1] = dp[i - 1][j][1] + 1;
					else
						dp[i][j][1] = 1;

					min = dp[i][j][0];
					for (int k = 1; k <= dp[i][j][1]; k++) {
						min = Math.min(min, dp[i - k + 1][j][0]);
						area = Math.max(area, min * k);
					}
				}
			}
		}

		return area;
	}

}
