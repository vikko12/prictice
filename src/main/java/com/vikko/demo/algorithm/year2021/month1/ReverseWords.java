package com.vikko.demo.algorithm.year2021.month1;

/**
 * @author: vikko
 * @Date: 2021/1/11 14:12
 * @Description:
 */
public class ReverseWords {

	public static void main(String[] args) {

		String s = "i am a   student    ";
		System.out.println(reverseWords2(s));
	}

	public static String reverseWords(String s) {
		s = " " + s.trim();
		int last = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				String sub = s.substring(i, last).trim();
				if (!"".equals(sub)) {
					sb.append(sub).append(" ");
				}
				last = i;
			}
		}
		return sb.toString().trim();
	}


	public static String reverseWords2(String s) {
		s = " " + s;
		int i = s.length() - 1;
		int last = s.length();
		StringBuilder sb = new StringBuilder();
		while (i >= 0) {
			if (s.charAt(i) == ' ') {
				if (i != 0 && s.charAt(i - 1) == ' ') {
					i--;
				} else {
					sb.append(" ").append(s.substring(i, last));
				}
				last = i;
			}
			i--;
		}
		return sb.toString().trim();
	}
}
