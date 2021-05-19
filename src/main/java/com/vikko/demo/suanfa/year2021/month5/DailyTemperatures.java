package com.vikko.demo.suanfa.year2021.month5;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: vikko
 * @Date: 2021/5/19 19:15
 * @Description:
 */
public class DailyTemperatures {

	public int[] dailyTemperatures(int[] T) {
		int length = T.length;
		int[] ans = new int[length];
		Deque<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < length; i++) {
			int temperature = T[i];
			while (!stack.isEmpty() && temperature > T[stack.peek()]) {
				int prevIndex = stack.pop();
				ans[prevIndex] = i - prevIndex;
			}
			stack.push(i);
		}
		return ans;
	}

}
