package com.vikko.demo.algorithm.year2021.month8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: vikko
 * @Date: 2021/8/30 15:09
 * @Description:
 */
public class GenerateParenthesis {

	List<String> res = new ArrayList<>();
	public List<String> generateParenthesis(int n) {
		dfs(n, n, "");
		return res;
	}

	/**
	 * 只需要生成n个左括号和n个右括号
	 * @param left
	 * @param right
	 * @param curStr
	 */
	private void dfs(int left, int right, String curStr) {
		if (left == 0 && right == 0) {
			res.add(curStr);
			return;
		}

		// 如果左括号还剩余的话，可以拼接左括号
		if (left > 0) {
			dfs(left - 1, right, curStr + "(");
		}
		// 如果右括号剩余多于左括号剩余的话，可以拼接右括号
		if (right > left) {
			dfs(left, right - 1, curStr + ")");
		}
	}


}
