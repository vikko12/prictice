package com.vikko.demo.suanfa.year2021.month4;

import java.util.Arrays;

/**
 * @author: vikko
 * @Date: 2021/4/6 14:56
 * @Description:
 */
public class RemoveDuplicate {

	public static void main(String[] args) {
		int[] a = {1,1,2,2,4,4,5,6,6,7};
		int i = removeDuplicate1(a);
		System.out.println(Arrays.toString(a));
		System.out.println(i);
	}


	public static int removeDuplicate(int[] nums){
		int i = 0, j = 1;
		while (j < nums.length) {
			if(nums[i] != nums[j]){
				i++;
				nums[i] = nums[j];
			}
			j++;
		}
		return i + 1 ;
	}

	public static int removeDuplicate1(int[] nums){
		int i = 1;
		for (int num : nums) {
			if(num > nums[i-1]){
				nums[i++] = num;
			}
		}
		return i;
	}


	public static int remove2Duplicates(int[] nums) {
		int i = 0;
		for (int n : nums){
			if (i < 2 || n > nums[i-2]){
				nums[i++] = n;
			}
		}
		return i;
	}

}
