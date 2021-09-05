package com.vikko.demo.algorithm.year2021.sort;


import com.vikko.demo.algorithm.year2021.month6.SortListByQuick;
import java.util.Arrays;

/**
 * @author: vikko
 * @Date: 2021/2/25 16:31
 * @Description:
 * @see SortListByQuick
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {18, 2, 42, 55, 7, 4, 5, 3, 9, 0};
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			//分治拿到i
			int i = partition(arr, low, high);
			quickSort(arr, low, i - 1);
			quickSort(arr, i + 1, high);
		}
	}

	/**
	 * 以第一个元素为基准元素，把大的放基准元素的右边，小的放在左边，
	 * 最终返回基准元素的下标
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition(int[] arr, int low, int high) {
		//取第一个元素作为基准元素
		int temp = arr[low];
		//定义指针
		int i = low, j = high;
		//外层循环：控制循环范围
		while (i < j) {
			//内层循环：需要加上4个判断 i<j）
			while (i < j && arr[j] > temp) {
				j--;
			}
			if (i < j) {
				/**
				 * 将j的元素赋给i，注意此时arr中有两个值为arr[j]的元素，
				 * 但是无所谓(因为后续会有比基准元素大的值会替换掉后面这个arr[j])，只需要移动基准元素的下标即可
				 */
				arr[i] = arr[j];
				//其实这里的i++可以不写，后续会加上，但是++之后就少比较一次
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
