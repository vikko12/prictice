package com.vikko.demo.algorithm.year2021.month1;

/**
 * @author: vikko
 * @Date: 2021/1/8 15:48
 * @Description:
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums = {1, 1};
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		int i = 0, j = 1;
		//可再优化，但是这样写方便李姐
		while (j < nums.length) {
			if(nums[i] == nums[j]){
				j++;
			}else {
				i++;
				nums[i] = nums[j];
				j++;
			}
		}
		return i + 1 ;
	}

}
