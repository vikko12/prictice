package com.vikko.demo.suanfa.year2021.month5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author: vikko
 * @Date: 2021/5/18 11:27
 * @Description:
 */
public class SmallestSubquence {


	public String smallestSubsequence(String s) {
		int len = s.length();

		//转换原因是因为，在遍历输入字符串时，charAt方法会去检查数组下标是否越界
		char[] charArray = s.toCharArray();

		//记录在遍历过程中，出现字符的最后一个下标
		int[] lastIndex = new int[26];

		//记录输入字符串中，每一个出现的字符，最后一次出现的下标
		for (int i = 0; i < len; i++) {
			lastIndex[charArray[i] - 'a'] = i;
		}

		//记录字母升序排列的结果
		Deque<Character> stack = new ArrayDeque<>();

		//记录某一个字符在"栈"中是否出现
		boolean[] visited = new boolean[26];

		for (int i = 0; i < len; i++) {

			//如果某个字符在"栈"中已经存在，则丢弃该字符
			if (visited[charArray[i] - 'a']) {
				continue;
			}

			//"栈"顶元素的ASCII码值 比当前元素的ASCII码值 大
			// &&  "栈"顶元素在之后还会出现
			while (!stack.isEmpty()
					&& stack.peekLast() > charArray[i]
					&& lastIndex[stack.peekLast() - 'a'] > i) {
				Character top = stack.removeLast();
				visited[top - 'a'] = false;
			}

			//将元素入"栈"（不该入栈时，前面已经continue了）
			stack.addLast(charArray[i]);

			//设置该元素已经在栈内出现过了
			visited[charArray[i] - 'a'] = true;

		}

		//"栈"底到"栈"顶的顺序，就是我们的答案
		StringBuilder sb = new StringBuilder();
		for (Character ch : stack) {
			sb.append(ch);
		}
		return sb.toString();
	}

	/**
	 * 这个是错误的，顺序乱了
	 */
	public String smallestSubsequence2(String s) {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (queue.contains(c)) {
				continue;
			}
			queue.add(c);
		}
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			sb.append(queue.poll());
		}
		return sb.toString();
	}

	public static String smallestSubsequence3(String s) {
		Deque<Character> arrayDeque = new ArrayDeque<>();
		char[] chars = s.toCharArray();
		int[] lastIndex = new int[26];
		for (int i = 0; i < chars.length; i++) {
			lastIndex[chars[i] - 'a'] = i;
		}
		boolean[] visit = new boolean[26];

		for (int i = 0; i < chars.length; i++) {
			char currChar = chars[i];
			if (visit[currChar - 'a']) {
				continue;
			}
			while (!arrayDeque.isEmpty() && arrayDeque.peekLast() > currChar
					&& lastIndex[arrayDeque.peekLast() - 'a'] > i) {
				Character top = arrayDeque.removeLast();
				visit[top - 'a'] = false;
			}
			arrayDeque.addLast(currChar);
			//设置该元素已经在栈内出现过了
			visit[currChar - 'a'] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : arrayDeque) {
			sb.append(c);
		}
		return sb.toString();

	}

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		PriorityQueue<Character> queue = new PriorityQueue<>();
		String zaz = smallestSubsequence3("zaz");
		System.out.println(zaz);

	}

}
