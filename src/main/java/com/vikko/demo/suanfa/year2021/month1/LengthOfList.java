package com.vikko.demo.suanfa.year2021.month1;

import java.util.Arrays;

/**
 * @author: vikko
 * @Date: 2021/1/11 15:25
 * @Description:
 */
public class LengthOfList {

	public static void main(String[] args) {

	}

	public static int lengthOfList(int[] nums){

		int[] res = new int[nums.length];
		int len = 0;
		for (int num: nums) {
			int idx = Arrays.binarySearch(res, 0, len, num);
			idx = idx < 0?- idx - 1: idx;
			res[idx] = num;
			if (idx == len) {
				len++;
			}
		}
		return len;
	}

}
