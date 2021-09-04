package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/9/2 10:46
 * @Description: 旋转数组二分查找
 */
public class Search {

	/**
	 * 7 8 9 1 2 3 4 5 6
	 */
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int l = 0, r = nums.length - 1;
		while (r >= l) {
			int mid = l + (r - l) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (nums[mid] < nums[r]) {
				//右边是顺序的
				if (nums[mid] < target && target <= nums[r]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			} else {
				//左边是顺序
				if (nums[l] <= target && target < nums[mid]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
		}
		return -1;
	}

}
