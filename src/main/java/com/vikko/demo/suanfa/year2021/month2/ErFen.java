package com.vikko.demo.suanfa.year2021.month2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.xml.crypto.Data;

/**
 * @author: vikko
 * @Date: 2021/2/11 13:54
 * @Description:
 */
public class ErFen {

	private static List<Integer> filterNums = Arrays.asList(10, 20, 50, 71, 88);

	public static void main(String[] args) {
		int[] integers = IntStream.rangeClosed(0, 100)
				.filter(data -> !filterNums.contains(data)).toArray();
		int index = searchInsert(integers, 9);
		System.out.println(index);
	}

	public static int searchInsert(int[] nums, int target) {
		int l = 0, r = nums.length-1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] > target) {
				r = mid - 1;
			} else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				return mid;
			}
		}
		return nums.length;
	}

}
