package com.vikko.demo.algorithm.year2021.sort.noDoc;

import com.vikko.demo.algorithm.year2021.month6.SortListByMerge;
import java.util.Arrays;

/**
 * @author: vikko
 * @Date: 2021/3/31 13:43
 * @Description:
 * @see SortListByMerge 这是对链表排序，也是用的归并
 */
public class MergeSort {

	public static void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(a, left, mid);
			mergeSort(a, mid + 1, right);
			doMerge(a, left, mid, right);
		}
	}
	private static void doMerge(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left, j = mid + 1,t = 0;
		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[t++] = arr[i++];
		}
		while (j <= right) {
			temp[t++] = arr[j++];
		}
		for (int x = 0; x < temp.length; x++) {
			arr[left + x] = temp[x];
		}
	}


}
