package com.vikko.demo.suanfa.year2021.month5;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: vikko
 * @Date: 2021/5/18 15:47
 * @Description:
 */
public class MaxNumber {

	/**
	 * 错误
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @return
	 */
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		Deque<Integer> deque = new ArrayDeque<>();
		int len1 = nums1.length, len2 = nums2.length, i = 0, j = 0, count = 0;
		while (i < len1 && j < len2 && count < k){
			if(nums1[i] > nums2[j]){
				deque.addLast(nums1[i]);
				i++;
			}else {
				deque.addLast(nums2[j]);
				j++;
			}
			count++;
		}
		int[] result = new int[k];
		for (int l = 0; l < k; l++) {
			result[l] = deque.pollFirst();
		}
		return result;
	}

}
