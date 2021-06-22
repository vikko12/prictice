package com.vikko.demo.algorithm.year2021.month5;

import java.util.Deque;
import java.util.LinkedList;

/**
 * todo
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

	/**
	 * 官方
	 * @param matrix
	 * @return
	 */
	public int maximalRectangle2(char[][] matrix) {
		int m = matrix.length;
		if (m == 0) {
			return 0;
		}
		int n = matrix[0].length;
		int[][] left = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
				}
			}
		}

		int ret = 0;
		// 对于每一列，使用基于柱状图的方法
		for (int j = 0; j < n; j++) {
			int[] up = new int[m];
			int[] down = new int[m];

			Deque<Integer> stack = new LinkedList<Integer>();
			for (int i = 0; i < m; i++) {
				while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
					stack.pop();
				}
				up[i] = stack.isEmpty() ? -1 : stack.peek();
				stack.push(i);
			}
			stack.clear();
			for (int i = m - 1; i >= 0; i--) {
				while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
					stack.pop();
				}
				down[i] = stack.isEmpty() ? m : stack.peek();
				stack.push(i);
			}

			for (int i = 0; i < m; i++) {
				int height = down[i] - up[i] - 1;
				int area = height * left[i][j];
				ret = Math.max(ret, area);
			}
		}
		return ret;
	}

}
