package com.vikko.demo.suanfa.year2021.month1;

/**
 * @author: vikko
 * @Date: 2021/1/8 14:32
 * @Description:
 */
public class IsPalindrome {

	public static void main(String[] args) {
		System.out.println(		isPalindrome(232));
	}

	public static boolean isPalindrome(int x) {
		if(x<0){
			return false;
		}
		if(x == 0){
			return true;
		}
		char[] chars = String.valueOf(x).toCharArray();
		int length = chars.length;
		int left = 0, right = length -1;
		while (left < right){
			if(chars[left] != chars[right]){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
