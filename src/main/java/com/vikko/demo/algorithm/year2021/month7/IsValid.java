package com.vikko.demo.algorithm.year2021.month7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: vikko
 * @Date: 2021/7/30 18:01
 * @Description:
 */
public class IsValid {

	public static void main(String[] args) {
		boolean valid = isValid("([)]");
	}

	public static boolean isValid(String s) {

		Deque<Character> deque = new ArrayDeque<>();
		char[] chars = s.toCharArray();
		Map<Character, Character> map = new HashMap<>();
		map.put('[',']');
		map.put('{','}');
		map.put('(',')');
		for (char cur : chars) {
			if(map.containsKey(cur)){
				deque.offerLast(cur);
			}else {
				if(!deque.isEmpty() && map.get(deque.peekLast()) == cur){
					deque.removeLast();
				}else {
					return false;
				}
			}
		}
		return deque.isEmpty();
	}

}
