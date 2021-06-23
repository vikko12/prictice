package com.vikko.demo.algorithm.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/19 15:57
 * @Description: leetcode287
 */
public class FindDuplicate {

	public int findDuplicate(int[] nums) {
		int[] visit = new int[nums.length];
		for (int num : nums) {
			if(visit[num] == -1){
				return num;
			}else {
				visit[num] = -1;
			}
		}
		return -1;
	}



}
