package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/8/24 16:04
 * @Description: leetcode647
 */
public class CountSubstring {

	int num = 0;
	public int countSubstrings(String s){
		char[] chars = s.toCharArray();
		for(int i = 0; i < chars.length; i++){
			helper(chars,i,i);
			helper(chars,i,i+1);
		}
		return num;
	}

	private void helper(char[] chars, int start, int end){
		while (start >= 0 && end < chars.length && chars[start] == chars[end]){
			num++;
			start--;
			end++;
		}
	}

}
