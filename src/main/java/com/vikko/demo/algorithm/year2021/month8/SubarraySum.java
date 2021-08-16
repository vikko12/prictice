package com.vikko.demo.algorithm.year2021.month8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: vikko
 * @Date: 2021/8/10 17:11
 * @Description:
 */
public class SubarraySum {

	public int subarraySum(int[] nums, int k) {
		int pre = 0, count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0,1);
		for (int num : nums) {
			pre += num;
			count += map.getOrDefault(pre - k, 0);
			map.put(pre, map.getOrDefault(pre,0) + 1);
		}
		return count;
	}
}
