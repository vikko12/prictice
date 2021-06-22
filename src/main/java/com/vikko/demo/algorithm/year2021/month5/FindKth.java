package com.vikko.demo.algorithm.year2021.month5;

import java.util.Arrays;

/**
 * @author: vikko
 * @Date: 2021/5/26 11:08
 * @Description:
 */
public class FindKth {

	public static int findKth(int[] a, int n, int K) {
		// write code here
		quickSort(a, 0, n - 1);
		return a[n - K];
	}

	public static void quickSort(int[] a, int left, int right) {
		if (left >= right) {
			return;
		}
		int index = patition(a, left, right);
		quickSort(a, left, index - 1);
		quickSort(a, index + 1, right);
	}

	private static int patition(int[] a, int left, int right) {
		int begin = left;
		int end = right;
		int temp = a[left];
		while (begin < end) {
			while (begin < end && a[end] >= temp) {
				end--;
			}
			while (begin < end && a[begin] <= temp) {
				begin++;
			}
			swap(a, begin, end);
		}
		swap(a, left, begin);
		return begin;
	}

	private static void swap(int[] a, int begin, int end) {
		int tmp = a[begin];
		a[begin] = a[end];
		a[end] = tmp;
	}


	public static void main(String[] args) {
		int[] arr = {18, 20, 42, 55, 70, 4, 5, 3, 90, 0};
		qs(arr,0, arr.length-1,3);
		System.out.println(Arrays.toString(arr));
	}


	public static void qs(int[] arr, int left, int right, int k){
		if(left < right){
			if(left > k){
				return;
			}
			int p = partition(arr, left, right);
			qs(arr, left, p-1, k);
			qs(arr, p+1, right, k);
		}
	}

	public static int partition(int [] arr, int left, int right){
		int i = left, j = right;
		int temp = arr[left];
		while (i < j){
			while (i<j && arr[j] > temp){
				j--;
			}
			if(i<j){
				arr[i] = arr[j];
				i++;
			}

			while (i<j && arr[i] < temp){
				i++;
			}
			if(i<j){
				arr[j] = arr[i];
				j--;
			}
			arr[i] = temp;
		}
		return i;
	}
}
