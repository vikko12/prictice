package com.vikko.demo.algorithm.year2021.month8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: vikko
 * @Date: 2021/8/12 17:38
 * @Description:
 */
public class FindAnagrams {

	public List<Integer> findAnagrams(String s, String p){
		List<Integer> result = new ArrayList<>();
		char [] sChar = s.toCharArray();
		char [] pChar = p.toCharArray();
		int [] curAToZ = new int[26];
		int [] aToZ = new int[26];
		for (char c : pChar) {
			aToZ[c - 'a']++;
		}
		for (int i = 0; i < sChar.length; i++) {
			if (i >= pChar.length) {
				curAToZ[sChar[i-pChar.length] - 'a']--;
			}
			curAToZ[sChar[i] - 'a']++;
			if (Arrays.equals(curAToZ, aToZ)) {
				result.add(i - pChar.length + 1);
			}
		}
		return result;
	}

}
