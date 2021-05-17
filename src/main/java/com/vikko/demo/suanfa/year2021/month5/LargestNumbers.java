package com.vikko.demo.suanfa.year2021.month5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: vikko
 * @Date: 2021/5/14 10:21
 * @Description:
 */
public class LargestNumbers {

	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(nums));
	}

	public static String largestNumber(int[] nums) {
		PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
		for (int num : nums) {
			queue.offer(String.valueOf(num));
		}

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			sb.append(queue.poll());
		}
		if (sb.charAt(0) == '0') {
			return "0";
		}
		return sb.toString();
	}

	public static String largestNumber2(int[] nums) {

		String[] temp = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			temp[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(temp, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1+o2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (String s : temp) {
			sb.append(s);
			sb.deleteCharAt(0);
		}
		return sb.charAt(0) == '0' ? "0" : sb.toString();
	}


}
