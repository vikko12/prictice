package com.vikko.demo.algorithm.year2021.month2;

/**
 * @author: vikko
 * @Date: 2021/2/8 18:26
 * @Description:
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		int res = lengthOfLastWord("a ");
		System.out.println(res);

	}

	public static int lengthOfLastWord(String s){

		if(s.equals("")){
			return 0;
		}
		int res = 0;
		for(int i = s.length() -1; i>= 0; i--){
			if(res == 0 && s.charAt(i) == ' '){
				continue;
			}
			if(s.charAt(i) == ' '){
				return res;
			}
			res++;
		}
		return res;
	}

}
