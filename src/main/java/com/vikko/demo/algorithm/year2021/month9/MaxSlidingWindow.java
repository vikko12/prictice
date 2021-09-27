package com.vikko.demo.algorithm.year2021.month9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: vikko
 * @Date: 2021/9/6 14:23
 * @Description:
 * @see com.vikko.demo.algorithm.year2021.month5.MaxSlidingWindow
 */
public class MaxSlidingWindow {

	public int[] maxSlidingWindow2(int[] nums, int k) {
		if(nums == null || nums.length == 0){
			return new int[0];
		}
		int len = nums.length;
		Deque<Integer> deque = new ArrayDeque<>();
		int[] res = new int[len -k + 1];
		for(int i = 0, j = 0; i < len; i++){
			if(!deque.isEmpty() && deque.peekFirst() < i-k + 1){
				deque.poll();
			}
			while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
				deque.pollLast();
			}
			deque.offerLast(i);
			if(i >= k - 1) {
				res[j++] = nums[deque.peek()];
			}
		}
		return res;
	}

}
