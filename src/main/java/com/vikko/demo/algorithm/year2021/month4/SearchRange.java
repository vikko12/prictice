package com.vikko.demo.algorithm.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/19 16:02
 * @Description:
 */
public class SearchRange {

	public static void main(String[] args) {
		int[] arr = {5, 7, 7, 8, 8, 10};

//		int[] ints = searchRange(arr, 2);
//		System.out.println(Arrays.toString(ints));
		System.out.println(findIndex(arr, 6));

	}

	public static int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[]{-1, -1};
		}
		int index = findIndex(nums, target);
		if (index == -1) {
			return new int[]{-1, -1};
		}
		int left = index, right = index;
		while (left > 0 && left < nums.length) {
			if (nums[left - 1] == target) {
				left--;
			}else break;
		}
		while (right >= 0 && right < nums.length - 1) {
			if (nums[right + 1] == target) {
				right++;
			}else break;
		}
		return new int[]{left, right};
	}

	public static int findIndex(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right ) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > target) {
				right = mid -1 ;
			} else if (nums[mid] < target) {
				left = mid + 1 ;
			} else {
				return mid;
			}
		}
		return -1;
	}


}
