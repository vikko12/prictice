package com.vikko.demo.algorithm.year2021.month5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: vikko
 * @Date: 2021/5/19 18:06
 * @Description:
 */
public class FindMaxLength {

	public int findMaxLength(int[] nums) {
		int[] arr = new int[2 * nums.length + 1];
		Arrays.fill(arr, -2);
		arr[nums.length] = -1;
		int maxlen = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			count = count + (nums[i] == 0 ? -1 : 1);
			if (arr[count + nums.length] >= -1) {
				maxlen = Math.max(maxlen, i - arr[count + nums.length]);
			} else {
				arr[count + nums.length] = i;
			}
		}
		return maxlen;
	}
	public static int findMaxLength2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int maxlen = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			count = count + (nums[i] == 1 ? 1 : -1);
			if (map.containsKey(count)) {
				maxlen = Math.max(maxlen, i - map.get(count));
			} else {
				map.put(count, i);
			}
		}
		return maxlen;
	}

	public static void main(String[] args) {
		int[] a = {0,1,1,1,1,1,1,0,0};
		int maxLength2 = findMaxLength2(a);
		System.out.println(maxLength2);
	}

//	public int findMaxLength(int[] nums){
//
//	}
}
