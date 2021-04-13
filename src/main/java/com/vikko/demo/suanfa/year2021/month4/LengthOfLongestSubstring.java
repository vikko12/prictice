package com.vikko.demo.suanfa.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/7 12:02
 * @Description:
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		String s = "pwwkew";
		int i = lengthOfLongestSubstring(s);
		System.out.println(i);
	}

	public static int lengthOfLongestSubstring(String s) {
		/**
		 * 记录字符上一次出现的位置
		 * 索引是char的int值
		 * value是出现的位置
		 * 最后的res是等于当前位置减去上一次出现的位置
		 */

		int[] last = new int[128];
		for(int i = 0; i < 128; i++) {
			last[i] = -1;
		}
		int n = s.length();

		int res = 0;
		// 窗口开始位置
		int start = 0;
		for(int i = 0; i < n; i++) {
			int index = s.charAt(i);
			start = Math.max(start, last[index] + 1);
			res   = Math.max(res, i - start + 1);
			last[index] = i;
		}

		return res;
	}
}
