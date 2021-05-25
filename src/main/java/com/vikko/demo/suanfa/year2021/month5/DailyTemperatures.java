package com.vikko.demo.suanfa.year2021.month5;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: vikko
 * @Date: 2021/5/19 19:15
 * @Description: 单调栈 每日温度
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


	public static int[] test(int[] temperatures) {
		int[] res = new int[temperatures.length];
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < temperatures.length; i++) {
			while (!deque.isEmpty() && temperatures[deque.peek()] < temperatures[i]) {
				res[deque.peek()] = i - deque.pop();
			}
			deque.push(i);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = {73,74,75,71,69,72,76,73};
		int[] test = test(a);
		System.out.println(Arrays.toString(test));
	}
}
