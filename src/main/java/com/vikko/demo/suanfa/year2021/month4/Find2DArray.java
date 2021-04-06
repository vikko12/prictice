package com.vikko.demo.suanfa.year2021.month4;

public class Find2DArray {

    public static void main(String[] args) {
        int[][] m = {{1,2, 5, 8, 9},{20, 21,  22, 23, 25},{27,29,31,33,35}};
        System.out.println(findNumberIn2DArray(m,8));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        return findColumn(matrix[row],target);
    }

    //
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static int findRow(int[][] matrix, int target) {
        int length = matrix.length;
        int l = 0;
        int r = length;
        while (l < r) {
            int m = l + (r - l) >> 1;
            if (matrix[m][0] > target) {
                r = m - 1;
                continue;
            } else if (matrix[m][0] < target) {
                l = m + 1;
                continue;
            }
            return m;
        }
        return -1;
    }

    public static Boolean findColumn(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int m = l + (r-l)>>1;
            if(arr[m] > target){
                r = m - 1;
            }else if(arr[m] < target){
                l = m+1;
            }else {
                return true;
            }
        }
        return false;
    }


}
