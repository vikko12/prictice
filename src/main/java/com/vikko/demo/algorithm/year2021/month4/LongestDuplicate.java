package com.vikko.demo.algorithm.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/8 20:05
 * @Description:
 */
public class LongestDuplicate {

	public static void main(String[] args) {
		System.out.println(longest("zzzzzbwbbbbbbbkb"));
	}

	public static String longest(String s){
		int start = 0;
		int max = 1;
		int i = 0;
		while (i< s.length()){
			int j = 1;
			while (i + j <s.length() && s.charAt(i) == s.charAt(i + j)){
				j++;
			}
			if(j > max){
				max = j;
				start = i;
			}
			i = i + j;

		}
		return s.substring(start, start + max);
	}

}
