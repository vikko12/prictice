package com.vikko.demo.suanfa.year2021.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author: vikko
 * @Date: 2021/3/31 13:43
 * @Description:
 */
public class MergeSort {

	public static void mergeSort(int a[], int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			//左边的再分成，分成俩个更小的数组
			mergeSort(a, left, mid);
			//右边的再分，分成俩个更小的数组
			mergeSort(a, mid + 1, right);
			merge(a, left, mid, right);
		}
	}

	/**
	 * 合并 
	 */
	private static void merge(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int t = 0;
		//插入首个元素
		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		//将左边剩余元素填充进temp中，
		while (i <= mid) {
			temp[t++] = arr[i++];
		}
		//将右序列剩余元素填充进temp中
		while (j <= right) {
			temp[t++] = arr[j++];
		}
		for (int x = 0; x < temp.length; x++) {
			arr[left + x] = temp[x];
		}
	}

	public static void main(String[] args) {
		// 归并排序是指将两个有序的部分数组排序成整体有序的数组
		int[] array = {17, 25, 26, 3, 8, 9, 4, 92, 7};
		System.out.println(Arrays.toString(array));
		mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));

//		int i = 2;
//		System.out.println(array[++i]);
//		System.out.println("i===" + i);
	}

}
