package com.vikko.demo.algorithm.year2021.month5;

import java.util.PriorityQueue;

/**
 * @author: vikko
 * @Date: 2021/5/14 18:19
 * @Description:
 */
public class FindKthLarge {

	public static void main(String[] args) {

	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int num : nums) {
			if(queue.size() < k){
				queue.offer(num);
			} else if (queue.peek() < num) {
				queue.poll();
				queue.offer(num);
			}
		}
		return queue.peek();
	}

}
