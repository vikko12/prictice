package com.vikko.demo.suanfa.year2020;

import java.util.Objects;

/**
 * @author: vikko
 * @Date: 2020/12/16 17:43
 * @Description:
 */
public class LongestParam {

	public static void main(String[] args) {
		String[] strings = {"eat", "eae"};
		System.out.println(longestParam(strings));
	}

	public static String longestParam(String[] strs){
		if(Objects.isNull(strs) || strs.length == 0){
			return "";
		}
		if(strs.length == 1){
			return strs[0];
		}
		String result = strs[0];
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
			if(!str.startsWith(result)){
				str = str.substring(0,str.length()-1);
				i--;
			}
		}
		return result;
	}

	public static String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0) return "";
		String result = strs[0];
		if (strs.length == 1) return strs[0];
		for (int i = 0; i < strs.length; i++) {
			if (!strs[i].startsWith(result)) {
				result = result.substring(0, result.length() - 1);
				i--;
			}
		}

		return result;
	}

}
