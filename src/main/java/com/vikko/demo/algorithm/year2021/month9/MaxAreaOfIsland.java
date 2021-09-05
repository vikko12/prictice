package com.vikko.demo.algorithm.year2021.month9;

/**
 * @author vikko
 * @date 2021/9/5 14:51
 * @Description:
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(dfs(grid, i, j),res);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (grid[i][j] == 0 || i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        //此时把当前位置置为0，防止重复进来，相当于省略用visit[][].
        grid[i][j] = 0;
        //count要清空，不需要作为参数传入
        int count = 1;
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i, j - 1);
        count += dfs(grid, i, j + 1);
        return count;
    }

}
