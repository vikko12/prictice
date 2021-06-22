package com.vikko.demo.algorithm.year2021.month4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: vikko
 * @Date: 2021/5/18 14:52
 * @Description:
 */
public class RemoveKdigits {

	public String removeKdigits(String num, int k) {
		if (num.length() == k) {
			return "0";
		}
		StringBuilder sb = new StringBuilder(num);
		for (int i = 1; i <= k; i++) {
			int index = 0;
			for (int j = 1; j < sb.length() && sb.charAt(j) >= sb.charAt(j - 1); j++) {
				index = j;
			}
			sb.deleteCharAt(index);
		}
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	/**
	 * 单调栈
	 * @param num
	 * @param k
	 * @return
	 */
	public static String removeKdigits2(String num, int k) {
		if (num.length() == k) return "0";
		int count = 0;
		Deque<Character> deque = new LinkedList<>();
		char[] chars = num.toCharArray();
		for (char curChar : chars) {
			while (!deque.isEmpty() && deque.peekLast() > curChar && count < k) {
				deque.removeLast();
				count++;
			}
			deque.addLast(curChar);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; !deque.isEmpty() && i < num.length() -k ; i++) sb.append(deque.pollFirst());
		while ( sb.charAt(0) == '0' && sb.length() > 1 ) sb.deleteCharAt(0);
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = removeKdigits2("1432219", 3);
		System.out.println(s);
	}
}

