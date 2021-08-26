package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/8/20 11:01
 * @Description:
 */
public class ReverseStr {

	public String reverseStr(String s, int k) {
		char[] chars = s.toCharArray();
		int length = chars.length;
		for(int i = 0; i < length; i += 2*k){
			reverse(chars, i, i + k);
		}
		return chars.toString();
	}

	private void reverse(char[] chars, int left, int right){
		right = Math.max(right, chars.length);
		while(left < right){
			char tem = chars[left];
			chars[left] = chars[right];
			chars[right] = tem;
			left ++;
			right--;
		}
	}

}
