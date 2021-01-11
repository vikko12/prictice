package com.vikko.demo.suanfa.year2020.dp;

/**
 * @author vikko
 * @date 2020/6/23 19:52
 */
public class MaxWay {
    public static void main(String[] args) {

        System.out.println(uniquePaths(6,6));
    }

    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            array[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            array[0][i] = 1;
        }
        for (int ii = 1; ii < m; ii++) {
            for (int kk = 1; kk < n; kk++) {
                array[ii][kk] = array[ii - 1][kk] + array[ii][kk - 1];
            }
        }
        return array[m - 1][n - 1];
    }
}
