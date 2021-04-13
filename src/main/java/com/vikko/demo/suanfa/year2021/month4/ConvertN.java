package com.vikko.demo.suanfa.year2021.month4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author: vikko
 * @Date: 2021/4/13 15:07
 * @Description:
 */
public class ConvertN {

	public static void main(String[] args) {

		System.out.println(convert("ab", 1));
	}

	public static String convert(String s, int numRows){
		if(numRows == 1){
			return s;
		}
		List<StringBuilder> list = new ArrayList<>();
		IntStream.rangeClosed(1,numRows).forEach(i->list.add(new StringBuilder()));
		char[] chars = s.toCharArray();
		int row = 1;
		boolean down = false;
		for (char aChar : chars) {
			list.get(row-1).append(aChar);
			//换方向
			if(row == 1 || row == numRows){
				down = !down;
			}
			//增减row
			row += down ? 1 : -1;
		}
		StringBuilder result = new StringBuilder();
		list.forEach(result::append);
		return result.toString();
	}


}
