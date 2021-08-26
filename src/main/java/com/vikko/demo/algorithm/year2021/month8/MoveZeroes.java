package com.vikko.demo.algorithm.year2021.month8;

import java.util.Arrays;

/**
 * @author: vikko
 * @Date: 2021/8/24 15:03
 * @Description: leetcode 283
 */
public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		moveZeroes2(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void moveZeroes(int[] nums){

		int i = 0, j = nums.length - 1;
		while (j > i){
			while (j > i && nums[j] == 0){
				j--;
			}
			if(j > i){
				nums[i++] = nums[j];
			}
			while (j > i && nums[i] != 0){
				i++;
			}
			if(j > i){
				nums[j--] = nums[i];
			}
		}
		nums[i] = 0;

	}

	public static void moveZeroes2(int[] nums){
		int i = 0, j = 0, len = nums.length;
		while (j < len){
			if (nums[j] != 0){
				swap(nums, i, j);
				i++;
			}
			j++;
		}
	}

	private static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}



}
