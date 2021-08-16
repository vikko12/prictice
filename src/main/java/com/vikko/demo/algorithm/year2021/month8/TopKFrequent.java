package com.vikko.demo.algorithm.year2021.month8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author: vikko
 * @Date: 2021/8/10 15:42
 * @Description:
 */
public class TopKFrequent {

	public static void main(String[] args) {
		int[] a = {1,1,1,2,2,3,4};
		int[] ints = topKFrequent(a, 2);
		System.out.println(Arrays.toString(ints));

	}

	public static int[] topKFrequent(int[] nums, int k) {
		//pre handle
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));

		for (Integer num : map.keySet()) {
			if(queue.size() < k){
				queue.offer(num);
			}else if(map.get(num) > map.get(queue.peek())){
				queue.poll();
				queue.offer(num);
			}
		}
		int[] res = new int[k];
		for (int i = 0; i < res.length; i++) {
			res[i] = queue.poll();
		}
		return res;

	}

}
