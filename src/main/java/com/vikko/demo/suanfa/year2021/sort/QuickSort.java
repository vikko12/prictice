package com.vikko.demo.suanfa.year2021.sort;


import java.util.Arrays;

/**
 * @author: vikko
 * @Date: 2021/2/25 16:31
 * @Description:
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] a = {18, 2, 42, 55, 7, 4, 5, 3, 9, 0};
		System.out.println(Arrays.toString(a));
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}


	private static void quickSort(int[] a, int low, int high) {
		if (low < high) {
			int i = partition(a, low, high);
			quickSort(a, low, i - 1);
			quickSort(a, i + 1, high);
		}

	}

	private static int partition(int[] a, int low, int high) {
		int temp = a[low];
		int i = low, j = high;
		while (i < j) {
			while (i < j && a[j] > temp) {
				j--;
			}
			if (i < j) {
				a[i] = a[j];
				i++;
			}
			while (i < j && a[i] < temp) {
				i++;
			}
			if (i < j) {
				a[j] = a[i];
				j--;
			}
//			a[i] = temp;
		}
		a[i] = temp;
		return i;
	}
}
