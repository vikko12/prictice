package com.vikko.demo.suanfa.year2021.month5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: vikko
 * @Date: 2021/5/27 11:08
 * @Description: https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class MaxSlidingWindow {

	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < k; ++i) {
			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
				deque.pollLast();
			}
			deque.offerLast(i);
		}

		int[] ans = new int[n - k + 1];
		ans[0] = nums[deque.peekFirst()];
		for (int i = k; i < n; ++i) {
			//如果当前值大的话，移除队列里的
			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
				deque.pollLast();
			}
			deque.offerLast(i);
			while (deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
			ans[i - k + 1] = nums[deque.peekFirst()];
		}
		return ans;
	}

}
