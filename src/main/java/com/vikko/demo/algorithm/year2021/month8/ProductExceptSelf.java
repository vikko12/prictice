package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/9/1 13:49
 * @Description:
 */
public class ProductExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		if(nums == null || nums.length == 0){
			return nums;
		}
		int temp = 1;
		int zeroCount = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 0){
				zeroCount++;
			}else{
				temp *= nums[i];
			}
		}
		if(zeroCount >= 2){
			return new int[nums.length];
		}
		for(int i = 0; i < nums.length; i++){
			if(zeroCount == 0){
				nums[i] = temp / nums[i];
			}else {
				nums[i] = nums[i] == 0 ? temp : 0;
			}
		}
		return nums;
	}

	public int[] productExceptSelfCopy(int[] nums) {
		int[] res = new int[nums.length];
		int k = 1;
		for(int i = 0; i < res.length; i++){
			res[i] = k;
			// 此时数组存储的是除去当前元素左边的元素乘积
			k = k * nums[i];
		}
		k = 1;
		for(int i = res.length - 1; i >= 0; i--){
			res[i] *= k;
			k *= nums[i];
		}
		return res;
	}





}
