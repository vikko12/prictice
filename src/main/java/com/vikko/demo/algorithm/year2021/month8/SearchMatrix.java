package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/9/1 11:19
 * @Description:
 */
public class SearchMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		int row = matrix.length -1, col = matrix[0].length - 1;
		if(matrix[0][0] > target || matrix[row][col] < target){
			return false;
		}
		for(int i = 1; i <= row; i++){
			if(matrix[i][0] > target){
				row = i - 1;
				break;
			}
		}
		for(int j = 0; j <= col; j++){
			if(matrix[row][j] == target){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] a = {{1},{3}};
		boolean b = searchMatrix(a, 3);
		System.out.println(b);

	}

}
