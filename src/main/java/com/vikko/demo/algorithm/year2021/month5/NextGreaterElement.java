package com.vikko.demo.algorithm.year2021.month5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author: vikko
 * @Date: 2021/5/18 19:01
 * @Description:
 */
public class NextGreaterElement {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Deque<Integer> stack = new ArrayDeque<>();
		HashMap<Integer, Integer> hasMap = new HashMap<Integer, Integer>();

		int[] result = new int[nums1.length];

		for(int num : nums2) {
			while(!stack.isEmpty() && stack.peek()<num){
				hasMap.put(stack.pop(), num);
			}
			stack.push(num);
		}

		for(int i = 0; i < nums1.length; i++) result[i] = hasMap.getOrDefault(nums1[i], -1);

		return result;
	}

	public int trap2(int[] height) {
		if (height == null) {
			return 0;
		}
		Deque<Integer> stack = new ArrayDeque<>();
		int ans = 0;
		for (int i = 0; i < height.length; i++) {
			while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
				int curIdx = stack.pop();
				while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
					stack.pop();
				}
				if (!stack.isEmpty()) {
					int stackTop = stack.peek();
					ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
				}
			}
			stack.add(i);
		}
		return ans;
	}

}
