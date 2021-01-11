package com.vikko.demo.suanfa.year2021.month1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author: vikko
 * @Date: 2021/1/7 17:07
 * @Description:
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		System.out.println(Arrays.toString(getNum(nums, 9)));
	}

	public static int[] getNum(int[] nums, Integer target){

		if(Objects.isNull(nums) || nums.length == 0){
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			if(map.containsKey(target - val)){
				return new int[]{i, map.get(target - val)};
			}
			map.put(val, i);
		}
		return null;
	}
}
