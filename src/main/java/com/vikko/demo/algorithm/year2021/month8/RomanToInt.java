package com.vikko.demo.algorithm.year2021.month8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: vikko
 * @Date: 2021/8/30 17:02
 * @Description:
 */
public class RomanToInt {

	public int romanToInt(String s) {

		Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}};

		int ans = 0;
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			int value = symbolValues.get(s.charAt(i));
			if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
				ans -= value;
			} else {
				ans += value;
			}
		}
		return ans;
	}

}
