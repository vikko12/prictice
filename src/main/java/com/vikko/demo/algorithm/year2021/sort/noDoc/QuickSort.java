package com.vikko.demo.algorithm.year2021.sort.noDoc;


import com.vikko.demo.algorithm.year2021.month6.SortListByQuick;
import java.util.Arrays;

/**
 * @author: vikko
 * @Date: 2021/2/25 16:31
 * @Description:
 * @see SortListByQuick
 */
public class QuickSort {


	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int i = partition(arr, low, high);
			quickSort(arr, low, i - 1);
			quickSort(arr, i + 1, high);
		}
	}


	private static int partition(int[] arr, int low, int high) {
		int temp = arr[low];
		int i = low, j = high;
		while (i < j) {
			while (i < j && arr[j] > temp) {
				j--;
			}
			if (i < j) {
				arr[i] = arr[j];
				i++;
			}
			while (i < j && arr[i] < temp) {
				i++;
			}
			if (i < j) {
				arr[j] = arr[i];
				j--;
			}
		}
		arr[i] = temp;
		return i;
	}
}
