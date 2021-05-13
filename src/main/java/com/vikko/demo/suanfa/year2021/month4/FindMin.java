package com.vikko.demo.suanfa.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/16 16:40
 * @Description:
 */
public class FindMin {

	public static void main(String[] args) {
		System.out.println();
	}

	public static int findMin(int[] nums) {
		int res = nums[0];
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i+1] < nums[i]){
				return nums[i+1];
			}
		}
		return res;
	}

	/**
	 * 二分
	 * @param nums
	 * @return
	 */
	public int findMin2(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int pivot = low + (high - low) / 2;
			if (nums[pivot] < nums[high]) {
				high = pivot;
			} else {
				low = pivot + 1;
			}
		}
		return nums[low];
	}
}
