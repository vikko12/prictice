package com.vikko.demo.suanfa.year2021.month1;

/**
 * @author: vikko
 * @Date: 2021/1/8 16:41
 * @Description:
 */
public class SearchInsert {

	public static void main(String[] args) {
		int[] num = {1,2, 3};
		System.out.println(searchInsert(num, 2));
	}

	public static int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]>= target){
				return i;
			}
		}
		return nums.length;
	}

}
