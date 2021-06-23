package com.vikko.demo.algorithm.year2021.month5;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: vikko
 * @Date: 2021/5/25 16:43
 * @Description:
 */
public class SmallestK {

	public static void main(String[] args) {
		int[] a = {1,3,5,7,2,4,6,8};
		Arrays.sort(a);
		System.out.println(Arrays.toString(smallestK(a, 4)));
	}

	/**
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int[] smallestK(int[] arr, int k) {
		if (arr.length <= k) {
			return arr;
		}
		if (k == 0) {
			return new int[0];
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2)->v2-v1);
		for (int i : arr) {
			if (queue.size() < k) {
				queue.add(i);
			} else {
				Integer peek = queue.peek();
				if (peek >= i) {
					queue.poll();
					queue.add(i);
				}
			}
		}
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = queue.poll();
		}
		return res;
	}


	public int[] smallestK2(int[] arr, int k) {
		if (k > arr.length) return null;
		if (k == arr.length) return arr;
		int left = 0;
		int right = arr.length - 1;
		while (k > 0) {
			//得到cur 其左边为最小的arr.len-cur个
			int cur = fastSort(arr, left, right);
			//0-cur 和 0-cur-1 均为最小的
			if (cur == k - 1 || cur == k) break;
				//需要在左边的数组里面继续寻找，缩小右边界
			else if (cur > k) right = cur - 1;
				//需要在右边的数组继续找，缩小左边界
			else left = cur + 1;
		}
		return Arrays.copyOfRange(arr, 0, k);
	}

	//快排返回中间的值
	public int fastSort(int[] arr, int start, int end) {
		int left = start;
		int right = end;
		//待排序的第一个元素作为基准值
		int key = arr[left];

		//从左右两边交替扫描，直到left = right
		while (left < right) {
			while (right > left && arr[right] >= key) {
				//从右往左扫描，找到第一个比基准值小的元素
				right--;
			}

			//找到这种元素将arr[right]放入arr[left]中
			arr[left] = arr[right];

			while (left < right && arr[left] <= key) {
				//从左往右扫描，找到第一个比基准值大的元素
				left++;
			}

			//找到这种元素将arr[left]放入arr[right]中
			arr[right] = arr[left];
		}
		//基准值归位
		arr[left] = key;
		return left;
	}


}
