package com.vikko.demo.algorithm.year2021.month8;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

/**
 * @author: vikko
 * @Date: 2021/8/13 14:43
 * @Description:
 */
public class StackTest {

	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>();
		IntStream.rangeClosed(1,10).forEach(deque::addFirst);

		while (!deque.isEmpty()){
			System.out.println(deque.poll());
		}

	}

}
