package com.vikko.demo.algorithm.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/8 19:21
 * @Description:
 */
public class LongestHuiWen {

	public static void main(String[] args) {
		String s = "dabcbaaaaaa";
		String sub = huiWen(s);
		System.out.println(sub);
	}

	public static String huiWen(String s){
		//奇数
		char[] chars = s.toCharArray();
		int max = -1;
		int p = -1;
		boolean isFirst = true;
		for (int i = 0; i < chars.length; i++) {
			int length = 0;
			while (i-length >= 0 && i+ length < chars.length){
				if(i-length >= 0 && i+ length <= chars.length && chars[i-length] == chars[i+length]){
					length++;
				}else {
					break;
				}
			}
			if(2 * length - 1 >= max){
				max = 2 * length - 1;
				p = i;
			}}

		for (int i = 0; i < chars.length; i++) {
			int length2 = 0;
			while (i-length2 >= 0 && i+ length2 + 1 < chars.length){
				if(i-length2 >= 0 && i+ length2 + 1 < chars.length && chars[i-length2] == chars[i+ length2 + 1]){
					length2++;
				}else {
					break;
				}
			}
			if(2 * length2 > max){
				max = 2 * length2;
				p = i;
				isFirst = false;
			}

		}
		if(isFirst){
			return s.substring(p-max/2, p+max/2 + 1);
		}
		return s.substring(p-max/2+1, p+max/2 + 1);
	}

	public String same(String s){
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
