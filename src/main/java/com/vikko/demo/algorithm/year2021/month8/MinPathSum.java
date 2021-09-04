package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/8/31 18:24
 * @Description:
 */
public class MinPathSum {

	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0){
			return 0;
		}
		int col = grid[0].length;
		int row = grid.length;
		int[][] dp = new int[row][col];
		dp[0][0] = grid[0][0];
		for(int i = 1; i< row; i++){
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		for(int j = 1; j < col; j++){
			dp[0][j] = dp[0][j-1] + grid[0][j];
		}
		for(int i = 1; i < row; i++){
			for(int j = 1; j < col; j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[row-1][col-1];
	}

}
