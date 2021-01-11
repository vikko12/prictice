package com.vikko.demo.suanfa.year2021.month1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: vikko
 * @Date: 2021/1/7 17:17
 * @Description:
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] num = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> num1 = getNum2(num);
		System.out.println(num1);
	}

	public static List<List<Integer>> getNum(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int j = i; j < nums.length; j++) {
				int num = nums[j];
				if(map.containsKey(-val - num)&& !map.containsKey(num)){
					result.add(Arrays.asList(val, -val-num, num));
				}
					map.put(num,j);
			}
		}
		return result;
	}

	public static List<List<Integer>> getNum2(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			if(val > 0) {
				break;
			}
			if( i >= 1 && nums[i] == nums[i-1]){
				continue;
			}
			int left = i+1, right = nums.length -1;

			while (left < right){
				int sum = val + nums[left] + nums[right];
				if(sum == 0){
					result.add(Arrays.asList(val,nums[left],nums[right]));
					//去重
					while (left<right && nums[left] == nums[left+1]){
						left++;
					}
					while (left<right && nums[right] == nums[right-1]){
						right--;
					}
					left++;
					right--;
				}
				else if(sum > 0){
					right--;
				}else if(sum<0){
					left++;
				}


			}

		}
		return result;
	}
}
