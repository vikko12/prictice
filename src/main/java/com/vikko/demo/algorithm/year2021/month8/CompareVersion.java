package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/9/1 16:54
 * @Description:
 */
public class CompareVersion {


	/**
	 * *10 做累加，跳过'.'
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersion(String version1, String version2) {
		int n = version1.length(), m = version2.length();
		int i = 0, j = 0;
		while (i < n || j < m) {
			int x = 0;
			for (; i < n && version1.charAt(i) != '.'; ++i) {
				x = x * 10 + version1.charAt(i) - '0';
			}
			++i; // 跳过点号
			int y = 0;
			for (; j < m && version2.charAt(j) != '.'; ++j) {
				y = y * 10 + version2.charAt(j) - '0';
			}
			++j; // 跳过点号
			if (x != y) {
				return x > y ? 1 : -1;
			}
		}
		return 0;
	}


	public static int compareVersion2(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		for (int i = 0; i < v1.length || i < v2.length; ++i) {
			int x = 0, y = 0;
			if (i < v1.length) {
				x = Integer.parseInt(v1[i]);
			}
			if (i < v2.length) {
				y = Integer.parseInt(v2[i]);
			}
			if (x != y) {
				return x > y ? 1 : -1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int i = compareVersion2("0.1", "1.1");
		System.out.println(i);
	}

}
