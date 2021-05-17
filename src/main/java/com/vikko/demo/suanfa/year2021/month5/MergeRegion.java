package com.vikko.demo.suanfa.year2021.month5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: vikko
 * @Date: 2021/5/13 15:53
 * @Description:
 */
public class MergeRegion {

	public int[][] merge(int[][] arr) {
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		List<int[]> list = new ArrayList<>();
		Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
		int i = 0;
		int n = arr.length;
		while (i < n) {
			int left = arr[i][0];
			int right = arr[i][1];
			while (i < n - 1 && right >= arr[i + 1][0]) {
				right = Math.max(right, arr[i + 1][1]);
				i++;
			}
			list.add(new int[]{left, right});
			i++;
		}
		return list.toArray(new int[list.size()][2]);
	}

}
