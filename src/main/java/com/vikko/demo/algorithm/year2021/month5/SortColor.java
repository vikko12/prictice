package com.vikko.demo.algorithm.year2021.month5;

import java.util.Arrays;

/**
 * @author: vikko
 * @Date: 2021/5/14 14:14
 * @Description:
 */
public class SortColor {

	public static void main(String[] args) {
		int[] nums = {2,1,0,1,0};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void sortColors(int[] nums) {

		int left = 0, right = nums.length -1, i= 0;
		while (i <= right){
			if(nums[i] == 0){
				swap(nums,i,left);
				left++;
				i++;
			}else if(nums[i] == 2){
				swap(nums,i,right);
				right--;
			}else {
				i++;
			}
		}
	}

	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] =nums[j];
		nums[j] = temp;
	}

}
