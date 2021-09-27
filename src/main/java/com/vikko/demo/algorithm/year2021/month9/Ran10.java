package com.vikko.demo.algorithm.year2021.month9;

/**
 * @author: vikko
 * @Date: 2021/9/10 16:19
 * @Description:
 */
public class Ran10 {

	public int rand10() {
		int a = rand7(), b = rand7();
		while (a == 7) {
			a = rand7();
		}
		while (b > 5) {
			b = rand7();
		}

		return ((a & 1) == 1 ? 0 : 5) + b;
	}

	public int rand7() {
		return 1;
	}

	public static void main(String[] args) {
		int a = 7;
		System.out.println(a & 1);
	}

}
