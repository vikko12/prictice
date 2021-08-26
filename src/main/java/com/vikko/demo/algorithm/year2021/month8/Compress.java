package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/8/24 11:15
 * @Description:
 */
public class Compress {

	public int compress(char[] chars) {
		if (chars == null) {
			return 0;
		}
		int len = chars.length;
		int i = 0, j = 0, k = 0;
		while (j < len) {
			// 第三个指针k记录j起始位置:
			k = j;
			// 第一个位置指定直接复制
			chars[i++] = chars[j++];
			//跳过重复元素
			while (j < len && chars[j] == chars[i - 1]) {
				j++;
			}
			// 个数 > 1 则要在数组后面，i输出个数;
			if (j - k > 1) {
				i = append(chars, i, j - k);
			}
		}
		return i;
	}

	int append(char[] chs, int i, int num) {
		for (char ch : String.valueOf(num).toCharArray()) {
			chs[i++] = ch;
		}
		return i;
	}

}
